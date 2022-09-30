package com.example.nowincmc.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.nowincmc.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
) {
    object ForYou : BottomBarScreen(
        route = "foryou",
        title = "ForYou",
        selectedIcon = Icon.DrawableResourceIcon(NicIcons.MenuBook),
        unselectedIcon = Icon.DrawableResourceIcon(NicIcons.MenuBookBorder),
    )

    object Interests : BottomBarScreen(
        route = "interests",
        title = "Interests",
        selectedIcon = Icon.DrawableResourceIcon(NicIcons.Bookmarks),
        unselectedIcon = Icon.DrawableResourceIcon(NicIcons.BookmarkBorder),
    )
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}

object NicIcons {
    val MenuBook = R.drawable.ic_menu_book
    val MenuBookBorder = R.drawable.ic_menu_book_border
    val BookmarkBorder = R.drawable.ic_bookmark_border
    val Bookmarks = R.drawable.ic_bookmarks
}