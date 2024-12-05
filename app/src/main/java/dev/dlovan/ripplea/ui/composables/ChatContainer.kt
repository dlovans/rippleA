package dev.dlovan.ripplea.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.json.JSONObject

@Composable
fun ChatContainer(messages: List<JSONObject>) {
    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        listState.animateScrollToItem(messages.size - 1)
    }

    LazyColumn (
        modifier = Modifier
            .padding(vertical = 10.dp),
        state = listState
    ) {
       items(messages) { message ->
           val sender = message.getString("sender")
           val content = message.getString("content")
           val isMine = message.getBoolean("isMine")
           ChatMessage(sender, content, isMine)
       }
       }
}

@Preview(showBackground = true)
@Composable
fun ChatContainerPreview() {
    val dummyMessages = listOf(
        JSONObject("""{"sender": "Pablito", "content": "whas goin on bro", "isMine": true}"""),
        JSONObject("""{"sender": "MisterCHEF", "content": "Sierra 117 ready to cook off", "isMine": false}""")
    )
    ChatContainer(dummyMessages)
}