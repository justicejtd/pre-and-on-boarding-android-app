package com.example.wheelspinner.components.wheelSpinner

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.preandonboarding.components.wheelSpinner.WheelSpinnerState
import com.example.wheelspinner.components.popup.Popup
import com.example.wheelspinner.components.userProfile.UserProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun WheelSpinner(wheelSpinnerState: WheelSpinnerState, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var userImageBitmaps by remember { mutableStateOf(listOf<ImageBitmap>()) }
    val loader = ImageLoader(context)
    val configuration = LocalConfiguration.current
    val wheelSize = configuration.screenWidthDp * 0.65
    val rememberCoroutineScope = rememberCoroutineScope()


    LaunchedEffect(Unit) {
        rememberCoroutineScope.launch {
            wheelSpinnerState.wheelSpinner.users.forEach { user ->
                val req = ImageRequest.Builder(context)
                    .data(user.profile.image)
                    .target {
                        userImageBitmaps =
                            userImageBitmaps + listOf((it as BitmapDrawable).bitmap.asImageBitmap())
                    }
                    .build()
                loader.enqueue(req)
                withContext(Dispatchers.Default) {
                    delay(100)
                }
            }
        }
    }

    val angle: Float by animateFloatAsState(
        targetValue = wheelSpinnerState.angleTarget.toFloat(),
        animationSpec = tween(
            durationMillis = wheelSpinnerState.spinDuration,
            easing = LinearOutSlowInEasing
        ),
        finishedListener = {
            wheelSpinnerState.onFinished()
        }
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(text = wheelSpinnerState.text(), style = MaterialTheme.typography.displaySmall)
        WheelTarget(modifier = Modifier.size((wheelSize * 0.16).dp))
        Box(contentAlignment = Alignment.Center) {
            Wheel(
                imageBitmaps = userImageBitmaps,
                size = wheelSize.dp,
                modifier = Modifier.rotate(angle)
            )
            PlayButton(
                isEnabled = wheelSpinnerState.isPlayButtonEnabled,
                modifier = Modifier.size((wheelSize * 0.16).dp),
                onClick = { wheelSpinnerState.onSpinClick() }
            )
        }
    }
    wheelSpinnerState.selectedUser?.let { Popup({ wheelSpinnerState.onPopupClose() }) { UserProfile(it) } }
}