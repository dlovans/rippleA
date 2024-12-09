package dev.dlovan.ripplea.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object Auth
@Serializable
object Chat

@Composable
fun RippleNavHost(
    navController: NavHostController = rememberNavController()
    ) {
    NavHost(
        navController = navController,
        startDestination = Auth
    ) {
        composable<Auth> {
            AuthScreen(
                onNavigateToChat = { navController.navigate(route = Chat) }
            )
        }
        composable<Chat> {
            ChatScreen()
        }

    }
}