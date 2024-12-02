package dev.dlovan.ripplea.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatField(modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(red = 54, green = 69, blue = 79))
            .border(
                width = 2.dp,
                color = Color(red = 52, green = 211, blue = 153),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        IconButton(
            onClick = { }
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Play Icon",
                tint = Color.White,
            )
        }
        TextField(
            value = message,
            placeholder = { Text("Type something...") },
            onValueChange = { message = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedPlaceholderColor = Color.White,
                focusedPlaceholderColor = Color.White
            ),
            modifier = Modifier.weight(1f)
        )
        IconButton(
            onClick = { }
        ) {
            Icon(
                Icons.Default.Build,
                contentDescription = "Play Icon",
                tint = Color.White
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ChatFieldPreview() {
    ChatField()
}