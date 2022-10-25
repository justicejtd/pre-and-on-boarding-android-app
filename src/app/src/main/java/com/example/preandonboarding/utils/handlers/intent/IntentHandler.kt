package com.example.preandonboarding.utils.handlers.intent

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.preandonboarding.utils.constants.MimeType

object IntentHandler {
    fun openPdfFile(uri: Uri, context: Context, toastErrorMsg: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, MimeType.MIME_TYPE_PDF)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        try {
            ContextCompat.startActivity(context, intent, null)
        } catch (e: ActivityNotFoundException) {
            Toast
                .makeText(context, toastErrorMsg, Toast.LENGTH_LONG)
                .show()
        }
    }
}