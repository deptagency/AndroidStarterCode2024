package com.androidstartercode2024.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidstartercode2024.R
import com.androidstartercode2024.ui.components.TopAppBar
import com.androidstartercode2024.ui.theme.AndroidStarterCode2024Theme

@Composable
fun HomeScreen(
    homeUiState: HomeViewModel.HomeUiState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                appbarTitle = stringResource(id = R.string.home)
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(padding)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (homeUiState) {
                    is HomeViewModel.HomeUiState.Error -> {
                        Text(
                            text = homeUiState.errorMessage,
                            color = Color.Red
                        )
                    }

                    is HomeViewModel.HomeUiState.Loading -> {
                        CircularProgressIndicator()
                    }

                    is HomeViewModel.HomeUiState.Idle -> {
                        val answer = homeUiState.answer
                        Text(
                            text = "The answer is: $answer",
                            color = Color.Black,
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    )
}

@Preview(apiLevel = 31, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AndroidStarterCode2024Theme {
        HomeScreen(homeUiState = HomeViewModel.HomeUiState.Idle(true))
    }
}