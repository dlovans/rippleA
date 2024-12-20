package dev.dlovan.ripplea.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.dlovan.ripplea.R
import dev.dlovan.ripplea.ui.composables.AuthButton
import dev.dlovan.ripplea.ui.theme.Emerald
import dev.dlovan.ripplea.ui.theme.Stone
import dev.dlovan.ripplea.utils.AuthType
import dev.dlovan.ripplea.viewmodels.AuthViewModel

@Composable
fun AuthScreen(
    authType: AuthType = AuthType.SIGN_IN,
    onNavigateToChat: () -> Unit,
    authViewModel: AuthViewModel
) {
    var authTypeState by remember { mutableStateOf(authType) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Stone)
            .padding(10.dp)
            .padding(WindowInsets.safeContent.asPaddingValues())

    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Text(
                if (authTypeState == AuthType.SIGN_IN) "Welcome Back!" else "Get Started!",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                if (authTypeState == AuthType.SIGN_IN) "Sign in to start chatting." else "Join and chat.",
                color = Color.White,
                fontSize = 20.sp)
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    maxLines = 1,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }

            Button(
                onClick = {
                    onNavigateToChat()
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Emerald
                ),
                border = BorderStroke(1.dp, Emerald)
            ) {
                Text("Start Chatting")
            }

            Text("Or", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

            AuthButton(
                authTypeState,
                "Google",
                R.drawable.google
            ) {
                onNavigateToChat()
            }

            AuthButton(
                authTypeState,
                "Apple",
                R.drawable.apple
            ) {
                onNavigateToChat()
            }

            Box (
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        if (authTypeState == AuthType.SIGN_IN) "Don't have an account?" else "Already have an account?",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Text(
                        if (authTypeState == AuthType.SIGN_IN) "Sign Up" else "Sign In",
                        color = Emerald,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable {
                            authTypeState = when (authTypeState) {
                                AuthType.SIGN_IN -> AuthType.SIGN_UP
                                AuthType.SIGN_UP -> AuthType.SIGN_IN
                            }
                        }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen(onNavigateToChat = {}, authViewModel = hiltViewModel())
}