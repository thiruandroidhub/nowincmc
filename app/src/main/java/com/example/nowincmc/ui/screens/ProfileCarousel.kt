package com.example.nowincmc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class User(val id: String, val name: String, val url: String)

@Composable
fun UsersCarousel(
    users: List<User>,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()
    val tag = "forYou:users"

    LazyRow(
        modifier = modifier.testTag(tag),
        contentPadding = PaddingValues(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        state = lazyListState
    ) {
        items(items = users, key = { item -> item.id }) { user ->
            ProfileElement(
                name = user.name,
                url = user.url
            )
        }
    }
}

@Composable
fun ProfileElement(
    name: String,
    url: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            model = url,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileElementPreview() {
    ProfileElement(name = "thiru", url = "https://github.com/thiruandroidhub.png")
}