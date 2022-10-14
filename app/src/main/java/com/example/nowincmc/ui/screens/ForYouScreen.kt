package com.example.nowincmc.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nowincmc.R

@Composable
fun ForYouScreen(
    navHostController: NavHostController,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        UsersCarousel(
            users = listOf(
                User(
                    id = "1",
                    name = stringResource(id = R.string.user_name1),
                    url = "https://github.com/thiruandroidhub.png"
                ),
                User(
                    id = "2",
                    name = stringResource(id = R.string.user_name2),
                    url = "https://pbs.twimg.com/profile_images/1431339735931305989/nOE2mmi2_400x400.jpg"
                ),
                User(
                    id = "3",
                    name = stringResource(id = R.string.user_name3),
                    url = "https://pbs.twimg.com/profile_images/1437506849016778756/pG0NZALw_400x400.jpg"
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ForYouScreenPreview() {
    ForYouScreen(rememberNavController())
}