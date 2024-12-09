package dev.dlovan.ripplea.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dlovan.ripplea.ui.composables.ChatContainer
import dev.dlovan.ripplea.ui.composables.ChatField
import dev.dlovan.ripplea.ui.theme.Stone
import org.json.JSONObject

@Composable
fun ChatScreen(location: String = "Abyss") {

    val dummyMessages = listOf(
        JSONObject("""{"sender": "Pablito", "content": "whas goin on bro", "isMine": true}"""),
        JSONObject("""{"sender": "MisterCHEF", "content": "Sierra 117 ready to cook off", "isMine": false}"""),
        JSONObject("""{"sender": "ElPadre", "content": "MisterChef, wanna tell me whad u doin on dat ship, que?", "isMine": false}""")
    )
    Box(
        modifier = Modifier
            .background(Stone)
            .padding(20.dp, 30.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(location, modifier = Modifier.padding(top = 30.dp).align(Alignment.CenterHorizontally), color = Color.White, fontSize = 30.sp)
            Column (
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Bottom
            ) {
                ChatContainer(dummyMessages)
            }
            ChatField()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}