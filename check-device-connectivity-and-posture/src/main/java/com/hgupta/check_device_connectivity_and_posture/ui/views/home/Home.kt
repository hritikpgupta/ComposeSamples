package com.hgupta.check_device_connectivity_and_posture.ui.views.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Home(
    navigateToSettings: () -> Unit,
    //viewModel: HomeViewModel = viewModel()
) {
    //val viewState by viewModel.state.collectAsStateWithLifecycle()
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Green), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = navigateToSettings, modifier = Modifier.background(Color.Yellow)) {

            }
        }
    }
}