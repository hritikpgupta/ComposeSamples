package com.hgupta.compose_animation

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilitySample() {


    Column(modifier = Modifier.fillMaxSize()) {
        var visible by remember { mutableStateOf(false) }
        var isRound by remember { mutableStateOf(false) }
        val density = LocalDensity.current
        Button(onClick = {
            visible = !visible
            isRound = !isRound
        }) {
            Text(text = "Toggle")
        }
        val borderRadius by animateIntAsState(
            targetValue = if (isRound) 100 else 0, animationSpec = tween(
                durationMillis = 500, delayMillis = 10, easing = FastOutLinearInEasing
            )
        )
//        val transition = updateTransition(targetState = isRound, label = null)
//        val color by transition.animateColor(
//            transitionSpec = { tween(1000) },
//            label = "color",
//            targetValueByState = { validRound ->
//                if (validRound) Color.Green else Color.Red
//            })
        val repetable = rememberInfiniteTransition()
        val color by repetable.animateColor(
            initialValue = Color.Red, targetValue = Color.Green, animationSpec = infiniteRepeatable(
                repeatMode = RepeatMode.Reverse, animation = tween(2000)
            )
        )
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderRadius))
                .background(color)
        ) {

        }
//        AnimatedVisibility(
//            visible = visible,
//            modifier = Modifier.size(width = 100.dp, height = 100.dp),
//            enter = slideInHorizontally() + fadeIn()
//        ) {
//            Box(
//                modifier = Modifier
//                    .background(Color.Green)
//                    .size(width = 50.dp, height = 50.dp)
//            )
//        }
        AnimatedContent(targetState = visible,
            modifier = Modifier.size(width = 100.dp, height = 100.dp),
            content = { isVisible ->
                if (isRound) {
                    Box(modifier = Modifier.background(Color.Green))
                } else {
                    Box(modifier = Modifier.background(Color.Yellow))
                }
            },
            transitionSpec = {
                slideInHorizontally(initialOffsetX = { if (visible) it else -it }) with slideOutHorizontally(
                    targetOffsetX = { if (visible) -it else it })
            })

        AnimatedContent(targetState = visible, transitionSpec = {
            fadeIn(
                animationSpec = tween(
                    150, 150
                )
            ) with fadeOut(animationSpec = tween(150)) using SizeTransform { initialSize, targetSize ->
                if (targetState) {
                    keyframes {
                        // Expand horizontally first.
                        IntSize(targetSize.width, initialSize.height) at 150
                        durationMillis = 300
                    }
                } else {
                    keyframes {
                        // Shrink vertically first.
                        IntSize(initialSize.width, targetSize.height) at 150
                        durationMillis = 300
                    }
                }
            }
        }) { targetExpanded ->
            if (targetExpanded) {
                Box(
                    modifier = Modifier
                        .size(width = 400.dp, height = 250.dp)
                        .background(color = Color.Cyan.copy(0.4f)),
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier.size(width = 50.dp, height = 50.dp)
                )
            }
        }
    }


}