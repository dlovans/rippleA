package dev.dlovan.ripplea.models

/**
 * Represents a user in the application.
 */
data class User(
    val userId: String,
    val username: String,
    val isPremium: Boolean = false
)