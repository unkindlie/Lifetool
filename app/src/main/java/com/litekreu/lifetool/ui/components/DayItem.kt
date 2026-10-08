package com.litekreu.lifetool.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.litekreu.lifetool.R
import com.litekreu.lifetool.ui.theme.googleSansFamily

@Composable
fun DayItem(modifier: Modifier = Modifier, day: Int = 0, onClick: () -> Unit) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Column(
            modifier = modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "${stringResource(R.string.day)} $day",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                fontFamily = googleSansFamily
            )
            Text(text = "Something about the day", fontFamily = googleSansFamily)
        }
    }
}