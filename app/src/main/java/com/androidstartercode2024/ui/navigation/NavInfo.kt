package com.androidstartercode2024.ui.navigation

object Graph {
    const val MAIN = "main_graph"
}

sealed class MainRoute(val name: String) {
    data object Home: MainRoute("Home")
}