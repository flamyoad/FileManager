package com.flamyoad.common_ui.theme.widgets

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner

@Composable
fun AnimatedProgressIndicator(
    modifier: Modifier,
    progress: Float,
    color: Color = ProgressIndicatorDefaults.linearColor,
    trackColor: Color = ProgressIndicatorDefaults.linearTrackColor,
    animationDuration: Int = 1500,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
) {
    var progressState by remember { mutableFloatStateOf(0F) }
    val progressAnimation by animateFloatAsState(
        targetValue = progressState,
        animationSpec = tween(durationMillis = animationDuration, easing = FastOutSlowInEasing),
        label = "",
    )
    LinearProgressIndicator(
        progress = progressAnimation,
        modifier = modifier,
        color = color,
        trackColor = trackColor
    )
    LaunchedEffect(lifecycleOwner) {
        progressState = progress
    }
}