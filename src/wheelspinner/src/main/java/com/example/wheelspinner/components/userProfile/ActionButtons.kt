package com.example.wheelspinner.components.userProfile

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.preandonboarding.data.model.user.User
import com.example.wheelspinner.R
import com.example.wheelspinner.components.button.roundedSquareButton.RoundedSquareIconButton


private const val INTENT_EMAIL_URI = "mailto:"
private const val INTENT_DIAL_PRE_FIX_URI = "tel:"

@Composable
fun ActionButtons(
    user: User, modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val context = LocalContext.current

    val actionSendToIntent = Intent(Intent.ACTION_SENDTO)
    // Only email apps should handle this
    actionSendToIntent.data = Uri.parse(INTENT_EMAIL_URI)
    actionSendToIntent.putExtra(Intent.EXTRA_EMAIL, user.email)
    actionSendToIntent.putExtra(
        Intent.EXTRA_SUBJECT,
        stringResource(id = R.string.subject_meet_your_colleague)
    )

    val actionDailIntent = Intent(Intent.ACTION_DIAL)
    actionDailIntent.data = Uri.parse(INTENT_DIAL_PRE_FIX_URI.plus({ user.profile.phone }))
    val buttonSize = 48
    val iconSize = buttonSize * 0.8

    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
        RoundedSquareIconButton(
            onClick = { uriHandler.openUri(user.profile.linkedIn) },
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(buttonSize.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_linkedin_svg),
                contentDescription = stringResource(id = R.string.contentDescription_linkedin_icon),
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(iconSize.dp)
            )
        }
        RoundedSquareIconButton(
            onClick = { startActivity(context, actionSendToIntent, null) },
            color = MaterialTheme.colorScheme.primary,

            modifier = Modifier.size(buttonSize.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = stringResource(id = R.string.contentDescription_email_icon),
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(iconSize.dp)
            )
        }
        RoundedSquareIconButton(
            onClick = { startActivity(context, actionDailIntent, null)},
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(buttonSize.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = stringResource(id = R.string.contentDescription_phone_icon),
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(iconSize.dp)
            )
        }
    }
}