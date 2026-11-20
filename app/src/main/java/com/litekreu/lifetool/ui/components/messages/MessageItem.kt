package com.litekreu.lifetool.ui.components.messages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.litekreu.lifetool.data.entities.SavedMessageEntity

@Composable
fun RemovalWarning(
    onRemove: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Outlined.Warning,
                contentDescription = "Message removal warning"
            )
        },
        title = {
            Text("Removal Warning")
        },
        text = {
            Text("Are you sure you want to remove this message?")
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = onRemove) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "Dismiss")
            }
        }
    )
}

@Composable
fun MessageItem(
    message: SavedMessageEntity,
    onRemove: () -> Unit
) {
    var dialogRemovalValue: Int? by remember { mutableStateOf(null) }

    if (dialogRemovalValue !== null) {
        RemovalWarning(
            onDismissRequest = {
                dialogRemovalValue = null
            },
            onRemove = {
                onRemove()
                dialogRemovalValue = null
            }
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth(0.85f)
                .padding(vertical = 4.dp)
        ) {
            Column(modifier = Modifier.padding(
                horizontal = 6.dp,
                vertical = 4.dp
            )) {
                Text(
                    text = "#${message.id}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = message.text,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 18.sp
                )
            }
        }
        IconButton(onClick = { dialogRemovalValue = message.id }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Remove the message"
            )
        }
    }
}