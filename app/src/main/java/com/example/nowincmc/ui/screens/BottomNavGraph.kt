package com.example.nowincmc.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BottomNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.ForYou.route
    ) {
        composable(
            route = BottomBarScreen.ForYou.route,
        ) {
            ForYouScreen(navHostController)
        }
        composable(
            route = BottomBarScreen.Interests.route,
        ) {
            InterestsScreen(navHostController)
        }
    }
}