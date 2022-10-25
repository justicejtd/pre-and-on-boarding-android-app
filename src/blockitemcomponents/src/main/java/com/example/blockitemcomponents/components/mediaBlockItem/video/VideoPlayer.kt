package com.example.blockitemcomponents.components.mediaBlockItem.video

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView


@Composable
fun VideoPlayer(url: String, playWhenReady: Boolean, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val mediaItem = MediaItem.fromUri(url)
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            this.setMediaItem(mediaItem)
        }
    }

    LaunchedEffect(exoPlayer) {
        exoPlayer.prepare()
        exoPlayer.playWhenReady = playWhenReady
    }

    Box(modifier = modifier) {
        val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
        DisposableEffect(lifecycleOwner, AndroidView(
            factory = {

                // Player view for our video player
                StyledPlayerView(context).apply {
                    player = exoPlayer
                    layoutParams =
                        FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams
                                .MATCH_PARENT,
                            ViewGroup.LayoutParams
                                .MATCH_PARENT
                        )
                }
            }
        )) {
            val lifecycle = lifecycleOwner.lifecycle
            val observer = LifecycleEventObserver { _, event ->
                when (event) {
                    Lifecycle.Event.ON_PAUSE -> {
                        exoPlayer.playWhenReady = false
                    }
                    Lifecycle.Event.ON_RESUME -> {
                        exoPlayer.playWhenReady = false
                    }
                    Lifecycle.Event.ON_DESTROY -> {
                        exoPlayer.run {
                            stop()
                            release()
                        }
                    }
                    else -> {}
                }
            }
            lifecycle.addObserver(observer)
            onDispose {
                lifecycle.removeObserver(observer)
            }
        }
    }
}