package com.example.preandonboarding.utils.handlers.fileDownload

import androidx.lifecycle.LifecycleOwner
import androidx.work.*

private const val WORK_INFO_STATE_FAILED = "Downloading failed!"
private const val ONE_FILE_DOWNLOAD_WORK_PREFIX = "oneFileDownloadWork_"

class FileDownloadHandler(private val workManager: WorkManager) {
    fun startDownloadingFile(
        file: File,
        success: (String) -> Unit,
        failed: (String) -> Unit,
        running: () -> Unit,
        context: LifecycleOwner
    ) {
        val data = Data.Builder()
        data.apply {
            putString(FileDownloadWorker.FileParams.KEY_FILE_NAME, file.name)
            putString(FileDownloadWorker.FileParams.KEY_FILE_URL, file.url)
            putString(FileDownloadWorker.FileParams.KEY_FILE_TYPE, file.type)
        }

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresStorageNotLow(true)
            .setRequiresBatteryNotLow(true)
            .build()

        val fileDownloadWorker = OneTimeWorkRequestBuilder<FileDownloadWorker>()
            .setConstraints(constraints)
            .setInputData(data.build())
            .build()

        workManager.enqueueUniqueWork(
            "$ONE_FILE_DOWNLOAD_WORK_PREFIX${System.currentTimeMillis()}",
            ExistingWorkPolicy.KEEP,
            fileDownloadWorker
        )

        workManager.getWorkInfoByIdLiveData(fileDownloadWorker.id)
            .observe(context) { info ->
                info?.let {
                    when (it.state) {
                        WorkInfo.State.SUCCEEDED -> {
                            success(
                                it.outputData.getString(FileDownloadWorker.FileParams.KEY_FILE_URI)
                                    ?: ""
                            )
                        }
                        WorkInfo.State.FAILED -> {
                            failed(WORK_INFO_STATE_FAILED)
                        }
                        WorkInfo.State.RUNNING -> {
                            running()
                        }
                        else -> {
                            failed(WORK_INFO_STATE_FAILED)
                        }
                    }
                }
            }
    }
}