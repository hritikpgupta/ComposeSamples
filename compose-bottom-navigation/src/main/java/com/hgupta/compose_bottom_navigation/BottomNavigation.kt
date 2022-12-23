package com.hgupta.compose_bottom_navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    CustomBottomNavigation(navController = rememberNavController())
}

@Composable
fun CustomBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Network,
       // BottomNavItem.AddPost,
        BottomNavItem.Notification,
        BottomNavItem.Jobs
    )
    BottomAppBar(
        backgroundColor = colorResource(id = R.color.purple_500),
        elevation = 0.dp,
        cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 100))
    ) {
        BottomNavigation(
            elevation = 0.dp,
            modifier = Modifier.padding(0.dp, 0.dp, 60.dp, 0.dp),
            backgroundColor = colorResource(id = R.color.purple_500), contentColor = Color.Black
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(selected = currentRoute == item.screenRoute,
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title, fontSize = 9.sp) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    onClick = {
                        navController.navigate(item.screenRoute) {
                            navController.graph.startDestinationRoute?.let { screenRoute ->
                                popUpTo(screenRoute) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    })
            }

        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeScreen()
        }
        composable(BottomNavItem.Network.screenRoute) {
            NetworkScreen()
        }
        composable(BottomNavItem.AddPost.screenRoute) {
            AddPostScreen()
        }
        composable(BottomNavItem.Notification.screenRoute) {
            NotificationScreen()
        }
        composable(BottomNavItem.Jobs.screenRoute) {
            JobScreen()
        }
    }
}