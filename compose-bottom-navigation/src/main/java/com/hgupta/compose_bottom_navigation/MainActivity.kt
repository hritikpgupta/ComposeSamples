package com.hgupta.compose_bottom_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.hgupta.compose_bottom_navigation.ui.theme.ComposeSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSamplesTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background,
                ) {
                    Scaffold(
                        scaffoldState = rememberScaffoldState(),
                        bottomBar = {
                            CustomBottomNavigation(
                                navController = navController,
                            )
                        }, topBar = { AppBar() },
                        floatingActionButtonPosition = FabPosition.End,
                        isFloatingActionButtonDocked = true,
                        floatingActionButton = {
                            FloatingActionButton(
                                backgroundColor = Color.Red,
                                content = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                }, onClick = { /*TODO*/ })
                        }) { innerPadding ->
                        NavigationGraph(
                            navController = navController, modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}
