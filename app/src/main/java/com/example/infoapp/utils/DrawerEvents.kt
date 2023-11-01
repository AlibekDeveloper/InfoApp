package com.example.infoapp.utils

sealed class DrawerEvents {
    data class onItemClick(val title: String, val index: Int): DrawerEvents()
}
