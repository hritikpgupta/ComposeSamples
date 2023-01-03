package com.hgupta.compose_animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hgupta.compose_animation.ui.theme.ComposeSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    AnimatedVisibilitySample()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .padding(4.dp)

    ) {
        AnimatedVisibilitySample()
    }
}