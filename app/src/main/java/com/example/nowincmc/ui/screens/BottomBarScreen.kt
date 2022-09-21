package com.example.nowincmc.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object ForYou : BottomBarScreen(
        route = "foryou",
        title = "ForYou",
        icon = Icons.Default.Home
    )

    object Interests : BottomBarScreen(
        route = "interests",
        title = "Interests",
        icon = Icons.Default.Settings
    )
}