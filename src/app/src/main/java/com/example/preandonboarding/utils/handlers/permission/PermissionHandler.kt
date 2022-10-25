package com.example.preandonboarding.utils.handlers.permission

import android.os.Build
import android.os.Environment

object PermissionHandler {
    fun isScopedStoragePermissionNeeded(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()
    }
}