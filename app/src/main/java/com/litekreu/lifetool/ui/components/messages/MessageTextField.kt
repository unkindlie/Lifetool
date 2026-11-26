package com.litekreu.lifetool.ui.components.messages

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun MessageTextField(
    modifier: Modifier = Modifier,
    textState: TextFieldState = rememberTextFieldState(),
    onSubmit: () -> Unit,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val fieldColor by animateColorAsState(
        targetValue = if (isFocused) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.outline
        },
        animationSpec = tween(
            durationMillis = 250,
            easing = FastOutSlowInEasing
        ),
        label = "Field border color"
    )

    BasicTextField(
        state = textState,
        textStyle = MaterialTheme.typography.titleMedium.copy(
            color = MaterialTheme.colorScheme.primaryFixed
        ),
        lineLimits = TextFieldLineLimits.MultiLine(1, 3),
        cursorBrush = SolidColor(fieldColor),
        interactionSource = interactionSource,
        decorator = { inner ->
            Box(modifier = modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = fieldColor,
                    shape = CircleShape
                )
                .padding(start = 16.dp, end = 4.dp, top = 4.dp, bottom = 4.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        inner()
                    }
                    FilledTonalIconButton(
                        onClick = onSubmit,
                        enabled = textState.text.isNotBlank()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                }
            }
        }
    )
}