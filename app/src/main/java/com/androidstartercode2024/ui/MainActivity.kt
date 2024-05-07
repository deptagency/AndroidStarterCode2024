package com.androidstartercode2024.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androidstartercode2024.ui.navigation.Graph
import com.androidstartercode2024.ui.navigation.MainRoute
import com.androidstartercode2024.ui.screens.home.HomeScreen
import com.androidstartercode2024.ui.screens.home.HomeViewModel
import com.androidstartercode2024.ui.theme.AndroidStarterCode2024Theme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStarterCode2024Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mainNavController = rememberNavController()

                    NavHost(
                        navController = mainNavController,
                        route = Graph.MAIN,
                        startDestination = MainRoute.Home.name
                    ) {
                        composable(
                            route = MainRoute.Home.name
                        ) {
                            val homeViewModel = koinViewModel<HomeViewModel>()
                            val homeUiState by homeViewModel.homeUiState.collectAsStateWithLifecycle()

                            HomeScreen(
                                homeUiState = homeUiState
                            )
                        }
                    }
                }
            }
        }
    }
}

