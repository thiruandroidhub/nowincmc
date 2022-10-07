package com.example.nowincmc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nowincmc.ui.component.NicBackground
import com.example.nowincmc.ui.component.NicNavigationBar
import com.example.nowincmc.ui.component.NicNavigationBarItem

@OptIn(
    ExperimentalMaterial3Api::class,
)
@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()
    NicBackground {
        Scaffold(
            modifier = Modifier,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            bottomBar = { BottomBar(navController = navController) }
        ) {
            BottomNavGraph(navHostController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.ForYou,
        BottomBarScreen.Interests
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(color = MaterialTheme.colorScheme.surface) {
        NicNavigationBar(
            modifier = Modifier.windowInsetsPadding(
                WindowInsets.safeDrawing.only(
                    WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
                )
            )
        ) {
            screens.forEach {
                AddItem(
                    screen = it,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NicNavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            val icon = if (selected) {
                screen.selectedIcon
            } else {
                screen.unselectedIcon
            }
            when (icon) {
                is Icon.ImageVectorIcon -> Icon(
                    imageVector = icon.imageVector,
                    contentDescription = null
                )
                is Icon.DrawableResourceIcon -> Icon(
                    painter = painterResource(id = icon.id),
                    contentDescription = null
                )
            }
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
    )
}