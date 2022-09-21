package com.example.nowincmc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nowincmc.ui.screens.MainScreen
import com.example.nowincmc.ui.theme.NowincmcTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NowincmcTheme {
                MainScreen()
            }
        }
    }
}