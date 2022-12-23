package com.hgupta.compose_bottom_navigation

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(text = "Welcome", style = TextStyle(color = Color.White), fontSize = 24.sp)
        },
        backgroundColor = Color.Red,
        elevation = 4.dp,
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_cached_24),
                contentDescription = null, modifier = Modifier.clickable {
                    println("Hamburger Clicked")
                }
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_dehaze_24),
                contentDescription = null,
                modifier = Modifier.clickable {
                    println("Refresh Clicked")
                }
            )
        }
    )
}