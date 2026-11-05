package com.litekreu.lifetool.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.litekreu.lifetool.data.entities.TaskEntity

@Composable
fun TaskItem(
    task: TaskEntity,
    onClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.tertiaryContainer,
        modifier = Modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp)),
        onClick = onClick
    ) {
        Column (modifier = Modifier.fillMaxSize()
            .padding(12.dp)) {
            Text(
                text = task.title,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.titleLarge
            )
            Text("Something about the task")
        }
    }
}