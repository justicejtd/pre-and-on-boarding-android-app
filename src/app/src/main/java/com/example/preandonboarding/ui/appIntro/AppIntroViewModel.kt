@file:OptIn(ExperimentalPagerApi::class, ExperimentalPagerApi::class)

package com.example.preandonboarding.ui.appIntro

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.preandonboarding.data.api.service.appIntroPage.AppIntroRepo
import com.example.preandonboarding.data.api.service.module.ModuleRepo
import com.example.preandonboarding.data.model.appIntro.AppIntroConfig
import com.example.preandonboarding.data.model.Module
import com.example.preandonboarding.utils.handlers.module.ModulesInitHandler
import com.example.preandonboarding.utils.handlers.module.FeatureModuleManager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val LOADING_STATUS_DOWNLOADING = "Downloading..."
private const val LOADING_STATUS_INSTALLING = "Installing..."
private const val LOADING_STATUS_FAILED = "Installation failed"
private const val LOADING_STATUS_USER_CONFIRMATION = "Require user confirmation"
private const val LOADING_STATUS_CANCELING = "Canceling..."
private const val LOADING_STATUS_CANCELED = "Canceled"
private const val LOADING_STATUS_DOWNLOADED = "Downloaded"
private const val LOADING_STATUS_PENDING = "Pending..."
private const val LOADING_STATUS_UNKNOWN = "Error, contact your administrator"
private const val LOADING_STATUS_LOADING = "Loading..."

class AppIntroViewModel(
    private val moduleRepo: ModuleRepo,
    private val appIntroRepo: AppIntroRepo,
    private val featureModuleManager: FeatureModuleManager
) : ViewModel() {

    /**
     * Keeps track of of the loading screen.
     */
    var isAppIntroLoading by mutableStateOf(true)
        private set

    /**
     * keeps track of the skip button is visible or not.
     */
    var isSkipBtnVisible by mutableStateOf(true)
        private set

    /**
     * Keeps track of the app intro pages.
     */
    val pager: PagerState = PagerState(0)

    /**
     * Keeps track of the loading status (downloading, installing, error).
     */
    var loadingStatus by mutableStateOf(LOADING_STATUS_LOADING)
        private set

    /**
     * Keeps track if "Get Started" button should be enabled or not.
     */
    var isGetStartedBtnEnabled by mutableStateOf(false)
        private set

    /**
     * Keeps track if loading indicator should be shown or not.
     */
    var isLoadingVisible by mutableStateOf(true)
        private set

    var appIntroConfigs by mutableStateOf(listOf<AppIntroConfig>())
        private set

    var navigateToDashBoard by mutableStateOf(false)
        private set

    var navigateToLogin by mutableStateOf(false)
        private set

    init {
        handleModules()
        ModulesInitHandler().initializeCompose()
    }

    private fun getAppIntroPageConfigs(modules: List<Module>) {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
            navigateToLogin = true
        }
        ) {
            // Get conversations
            val response = appIntroRepo.getAppIntroPages()

            if (response.isSuccessful) {
                // Update conversation list
                response.body()?.let {
                    appIntroConfigs = it

                    withContext(Dispatchers.Main) {
                        isAppIntroLoading = false
                    }

                    // Download and install missing modules
                    downloadAndInstallModules(modules)
                }
            } else {
                navigateToLogin = true
            }
        }
    }

    private fun handleModules() {
        isAppIntroLoading = true
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
            navigateToLogin = true
        }
        ) {
            // Get module names
            val response = moduleRepo.getModulesNames()

            if (response.isSuccessful) {
                // Request to download and install modules
                response.body()?.let {
                    withContext(Dispatchers.Main) {
                        loadModules(it)
                    }
                }
            } else {
                navigateToLogin = true
            }
        }
    }

    /**
     * Load features based on module names.
     * @param modules names of the modules that needs to be installed
     */
    private fun loadModules(modules: List<Module>) {

        val missingModules = modules.filterNot { module ->
            featureModuleManager.isModuleInstalled(module)
        }

        // If there is no modules to be installed then navigate to dashboard screen
        if (missingModules.isEmpty()) {
            navigateToDashBoard = true
        } else {
            getAppIntroPageConfigs(missingModules)
        }
    }

    private fun downloadAndInstallModules(modules: List<Module>) {
        // Listen to split install state update
        featureModuleManager.registerListener(installStateListener)

        featureModuleManager.downloadAndInstallModules(modules = modules).addOnFailureListener {
            loadingStatus = LOADING_STATUS_FAILED
        }
    }

    private fun unregisterListener() {
        featureModuleManager.unregisterListener(installStateListener)
    }

    /**
     *  Listener used to handle changes in state for install requests.
     */
    private val installStateListener = SplitInstallStateUpdatedListener { state ->
        when (state.status()) {
            SplitInstallSessionStatus.DOWNLOADING -> {
                //  In order to see this, the application has to be uploaded to the Play Store.
                loadingStatus = LOADING_STATUS_DOWNLOADING
            }
            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                /*
                  This may occur when attempting to download a sufficiently large module.

                  In order to see this, the application has to be uploaded to the Play Store.
                  Then features can be requested until the confirmation path is triggered.
                 */
                loadingStatus = LOADING_STATUS_USER_CONFIRMATION
                // Todo handle startIntentSender(state.resolutionIntent()?.intentSender, null, 0, 0, 0)
            }
            SplitInstallSessionStatus.INSTALLED -> {
                loadingStatus = ""
                isLoadingVisible = false
                isGetStartedBtnEnabled = true
                unregisterListener()
            }

            SplitInstallSessionStatus.INSTALLING -> {
                loadingStatus = LOADING_STATUS_INSTALLING
            }
            SplitInstallSessionStatus.FAILED -> {
                loadingStatus = LOADING_STATUS_FAILED
            }
            SplitInstallSessionStatus.CANCELED -> {
                loadingStatus = LOADING_STATUS_CANCELED
            }
            SplitInstallSessionStatus.CANCELING -> {
                loadingStatus = LOADING_STATUS_CANCELING
            }
            SplitInstallSessionStatus.DOWNLOADED -> {
                loadingStatus = LOADING_STATUS_DOWNLOADED
            }
            SplitInstallSessionStatus.PENDING -> {
                loadingStatus = LOADING_STATUS_PENDING
            }
            SplitInstallSessionStatus.UNKNOWN -> {
                loadingStatus = LOADING_STATUS_UNKNOWN
            }
        }
    }

    /**
     * Skips to the final page of the app intro.
     */
    fun onSkip() {
        viewModelScope.launch {
            pager.scrollToPage(page = pager.pageCount - 1)
        }
    }

    /**
     * Checks if the skip button needs to be visible or not based on the current page.
     */
    fun onPageChange() {
        if (pager.currentPage == pager.pageCount - 1) {
            isSkipBtnVisible = false
        } else if (isSkipBtnVisible.not()) {
            isSkipBtnVisible = true
        }
    }
}