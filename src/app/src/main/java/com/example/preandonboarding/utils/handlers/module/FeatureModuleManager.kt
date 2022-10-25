package com.example.preandonboarding.utils.handlers.module

import com.example.preandonboarding.data.model.Module
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.tasks.Task

class FeatureModuleManager(private val splitInstallManager: SplitInstallManager) {

    private fun createRequest(modules: List<Module>): SplitInstallRequest {
        // Create new split install request builder
        val requestBuilder = SplitInstallRequest.newBuilder()

        // Add all request modules to request builder
        for (module in modules) {
            requestBuilder.addModule(module.name)
        }

        return requestBuilder.build()
    }

    /***
     * Downloads and install request modules from Google play store.
     * @param modules
     * @return Task<Int>
     */
    fun downloadAndInstallModules(
        modules: List<Module>
    ): Task<Int> {
        return splitInstallManager.startInstall(createRequest(modules = modules))
    }

    fun isModuleInstalled(module: Module): Boolean {
        return splitInstallManager.installedModules.contains(module.name)
    }

    fun registerListener(installStateListener: SplitInstallStateUpdatedListener) {
        splitInstallManager.registerListener(installStateListener)
    }

    fun unregisterListener(installStateListener: SplitInstallStateUpdatedListener) {
        splitInstallManager.unregisterListener(installStateListener)
    }
}