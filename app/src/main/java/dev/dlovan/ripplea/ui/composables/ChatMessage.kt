package dev.dlovan.ripplea.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatMessage(username: String,message: String, isMe: Boolean) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(if (isMe) Color.Green else Color.Gray)
            .padding(10.dp)

    ) {
        Text(text = "@$username")
        Text(text = message)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatMessagePreview() {
    ChatMessage("Dlovan","Hello", true)
}