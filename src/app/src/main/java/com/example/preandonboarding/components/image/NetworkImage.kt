package com.example.preandonboarding.components.image

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.ImageRequest
import com.example.preandonboarding.R
import com.example.preandonboarding.components.indicator.CustomCircleProgressIndicator

private const val DISK_CACHED_IMAGE_DIR = "network_cache"
private const val CROSS_FADE_TIME_MILLI = 500

/**
 * Loads image remotely based on a URL.
 */
@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    val context = LocalContext.current

    val imageLoader =
        ImageLoader.Builder(context)
            .components {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .memoryCache {
                MemoryCache.Builder(context)
                    .maxSizePercent(0.25)
                    .build()
            }
            .diskCache(
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve(DISK_CACHED_IMAGE_DIR))
                    .maxSizePercent(0.02)
                    .build()
            )
            .build()

    val imageRequest = ImageRequest.Builder(context)
        .data(url)
        .error(R.drawable.ic_baseline_error_24)
        .crossfade(CROSS_FADE_TIME_MILLI)
        .build()

    val painter = rememberAsyncImagePainter(model = imageRequest, imageLoader = imageLoader)

    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier,
        )
        if (painter.state is AsyncImagePainter.State.Loading) {
            CustomCircleProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}