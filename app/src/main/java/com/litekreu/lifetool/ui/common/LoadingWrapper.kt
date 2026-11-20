package com.litekreu.lifetool.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun LoadingWrapper(
    isLoading: Boolean,
    error: String?,
    content: @Composable () -> Unit
) {
    if (isLoading) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if (error !== null) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = error,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
    else content()
}