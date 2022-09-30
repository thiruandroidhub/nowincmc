package com.example.nowincmc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.nowincmc.ui.screens.MainScreen
import com.example.nowincmc.ui.theme.NowinCmcTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            NowinCmcTheme (
                dynamicColor = true
            ) {
                MainScreen()
            }
        }
    }
}
