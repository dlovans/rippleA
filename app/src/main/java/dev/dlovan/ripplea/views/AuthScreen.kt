package dev.dlovan.ripplea.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dlovan.ripplea.R
import dev.dlovan.ripplea.ui.composables.AuthButton
import dev.dlovan.ripplea.ui.theme.Emerald
import dev.dlovan.ripplea.ui.theme.Stone
import dev.dlovan.ripplea.utils.AuthType

@Composable
fun AuthScreen(
    authType: AuthType = AuthType.SIGN_IN,
    onNavigateToChat: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Stone)
            .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth()
                .padding(start = 10.dp, top = 30.dp)
        ) {
            Text(
                if (authType == AuthType.SIGN_IN) "Welcome Back!" else "Get Started!",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                if (authType == AuthType.SIGN_IN) "Sign in to start chatting." else "Join and chat.",
                color = Color.White,
                fontSize = 15.sp)
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth()
                    .background(Stone)
                    .border(
                        width = 1.dp,
                        color = Emerald,
                        shape = RoundedCornerShape(15.dp)
                    )
            ) {
                Text("Email: ", color = Color.White, modifier = Modifier.padding(start = 20.dp))
                BasicTextField(
                    value = email,
                    maxLines = 1,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }

            // Password input
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth()
                    .background(Stone)
                    .border(
                        width = 1.dp,
                        color = Emerald,
                        shape = RoundedCornerShape(15.dp)
                    )
            ) {
                Text("Password: ", color = Color.White, modifier = Modifier.padding(start = 20.dp))
                BasicTextField(
                    value = password,
                    maxLines = 1,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }

            Text("Or", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

            AuthButton(
                AuthType.SIGN_IN,
                "Google",
                R.drawable.google
            ) {
                onNavigateToChat()
            }

            AuthButton(
                AuthType.SIGN_IN,
                "Apple",
                R.drawable.apple
            ) {
                onNavigateToChat()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen(onNavigateToChat = {})
}