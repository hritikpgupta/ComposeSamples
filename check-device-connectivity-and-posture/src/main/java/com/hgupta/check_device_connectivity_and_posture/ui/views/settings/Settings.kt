package com.hgupta.check_device_connectivity_and_posture.ui.views.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Settings(
    //navigateToPlayer: (String) -> Unit,
    //viewModel: HomeViewModel = viewModel()
) {
    //val viewState by viewModel.state.collectAsStateWithLifecycle()
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.Magenta)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Magenta)
        ) {

        }
    }
}