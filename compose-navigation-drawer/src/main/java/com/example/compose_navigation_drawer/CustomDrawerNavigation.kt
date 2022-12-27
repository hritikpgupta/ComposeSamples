package com.example.compose_navigation_drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CustomDrawerNavigation(navController: NavController, onItemClick: (NavDrawerItem) -> Unit) {

    val navItems = listOf(
        NavDrawerItem.Home,
        NavDrawerItem.Network,
        NavDrawerItem.AddPost,
        NavDrawerItem.Notification,
        NavDrawerItem.Jobs
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    LazyColumn {
        items(navItems) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    onItemClick(item)
                }
                .padding(16.dp)) {
                Icon(painter = painterResource(id = item.icon), contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontSize = 16.sp)
                )
            }

        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = NavDrawerItem.Home.screenRoute) {
        composable(NavDrawerItem.Home.screenRoute) {
            HomeScreen()
        }
        composable(NavDrawerItem.Network.screenRoute) {
            NetworkScreen()
        }
        composable(NavDrawerItem.AddPost.screenRoute) {
            AddPostScreen()
        }
        composable(NavDrawerItem.Notification.screenRoute) {
            NotificationScreen()
        }
        composable(NavDrawerItem.Jobs.screenRoute) {
            JobScreen()
        }
    }
}