package dev.dlovan.ripplea.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.dlovan.ripplea.ui.theme.Stone
import dev.dlovan.ripplea.viewmodels.AuthViewModel
import kotlinx.serialization.Serializable

@Serializable
object Auth
@Serializable
object Chat

@Composable
fun RippleNavHost(
    navController: NavHostController = rememberNavController(),
    ) {
    val authViewModel = hiltViewModel<AuthViewModel>()
    val isAuthenticated = authViewModel.isAuthenticated.collectAsState()
    val isLoading = authViewModel.isLoading.collectAsState()

    if (isLoading.value) {
        Box(
            modifier = Modifier.fillMaxSize().background(Stone),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
        return
    }

    NavHost(
        navController = navController,
        startDestination = if (isAuthenticated.value) Chat else Auth
    ) {
        composable<Auth> {
            AuthScreen(
                onNavigateToChat = { navController.navigate(route = Chat) },
                authViewModel = authViewModel
            )
        }
        composable<Chat> {
            ChatScreen(
                authViewModel = authViewModel
            )
        }
    }
}