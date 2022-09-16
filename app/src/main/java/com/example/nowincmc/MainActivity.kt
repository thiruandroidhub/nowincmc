package com.example.nowincmc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nowincmc.ui.screens.SetupNavGraph
import com.example.nowincmc.ui.theme.NowincmcTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NowincmcTheme {
                navController = rememberNavController()
                SetupNavGraph(navHostController = navController)
            }

            // TODO add bottombar navigation
        }
    }
}