package com.example.compose_navigation_drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(title = {
        Text(text = "Welcome", style = TextStyle(color = Color.White), fontSize = 24.sp)
    }, backgroundColor = Color.Red, elevation = 4.dp, navigationIcon = {
        IconButton(onClick = onNavigationIconClick) {
            Icon(
                Icons.Default.Menu,
                contentDescription = null,
            )
        }
    })
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth().background(color = Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody( onItemClick: (NavDrawerItem) -> Unit) {
    val navItems = listOf(
        NavDrawerItem.Home,
        NavDrawerItem.Network,
        NavDrawerItem.AddPost,
        NavDrawerItem.Notification,
        NavDrawerItem.Jobs
    )

    LazyColumn {
        items(navItems) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(item) }
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
