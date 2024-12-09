package dev.dlovan.ripplea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.dlovan.ripplea.views.ChatScreen
import dev.dlovan.ripplea.views.RippleNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RippleNavHost()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ChatScreen()
}