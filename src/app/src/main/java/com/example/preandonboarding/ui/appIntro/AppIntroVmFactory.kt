package com.example.preandonboarding.ui.appIntro

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.preandonboarding.data.api.service.appIntroPage.AppIntroRepo
import com.example.preandonboarding.data.api.service.module.ModuleRepo
import com.example.preandonboarding.utils.constants.FactoryConstants.FACTORY_EXCEPTION_MSG
import com.example.preandonboarding.utils.handlers.module.FeatureModuleManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import java.lang.IllegalArgumentException

/**
 * Handles the initialization for AppIntro viewModel
 */
class AppIntroVmFactory(
    private val moduleRepo: ModuleRepo,
    private val appIntroRepo: AppIntroRepo,
    private val context: Context,
) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppIntroViewModel::class.java)) {
            return AppIntroViewModel(
                moduleRepo = moduleRepo,
                appIntroRepo = appIntroRepo,
                featureModuleManager = FeatureModuleManager(
                    SplitInstallManagerFactory.create(context)
                )
            ) as T
        }
        throw IllegalArgumentException(FACTORY_EXCEPTION_MSG)
    }
}