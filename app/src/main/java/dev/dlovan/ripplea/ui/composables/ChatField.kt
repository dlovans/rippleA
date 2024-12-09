package dev.dlovan.ripplea.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dlovan.ripplea.R
import dev.dlovan.ripplea.ui.theme.Emerald
import dev.dlovan.ripplea.ui.theme.Stone

@Composable
fun ChatField(modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Stone)
            .border(
                width = 2.dp,
                color = Emerald,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(end = 10.dp)
    ) {
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

        if (message.isNotEmpty()) {
            IconButton(
                onClick = { },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_send_24),
                    contentDescription = "Play Icon",
                    tint = Color.White
                )
            }
        }

//        if (message.isEmpty()) {
//            Row {
//                IconButton(
//                    onClick = { },
//                    modifier = Modifier.size(35.dp)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_camera_alt_24),
//                        contentDescription = "Play Icon",
//                        tint = Color.White
//                    )
//                }
//
//                IconButton(
//                    onClick = { },
//                    modifier = Modifier.size(35.dp)
//
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_keyboard_voice_24),
//                        contentDescription = "Play Icon",
//                        tint = Color.White
//                    )
//                }
//            }
//        } else {
//            IconButton(
//                onClick = { },
//                modifier = Modifier.size(35.dp)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_send_24),
//                    contentDescription = "Play Icon",
//                    tint = Color.White
//                )
//            }
//        }
    }
}

@Preview (showBackground = true)
@Composable
fun ChatFieldPreview() {
    ChatField()
}