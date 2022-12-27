package com.example.compose_navigation_drawer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.compose_navigation_drawer.ui.theme.ComposeSamplesTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSamplesTheme {
                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()
                val scope = rememberCoroutineScope()
                Scaffold(scaffoldState = scaffoldState,
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    topBar = {
                        AppBar(onNavigationIconClick = {
                            scope.launch {
                                if (scaffoldState.drawerState.isClosed) scaffoldState.drawerState.open()
                            }
                        })
                    },
                    drawerContent = {
                        DrawerHeader()
                        CustomDrawerNavigation(navController) {
                            scope.launch {
                                if (scaffoldState.drawerState.isOpen) scaffoldState.drawerState.close()
                            }
                        }
                    }) { innerPadding ->
                    NavigationGraph(
                        navController = navController, modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}