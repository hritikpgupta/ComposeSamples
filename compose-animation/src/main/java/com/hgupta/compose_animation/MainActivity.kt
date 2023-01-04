package com.hgupta.compose_animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.hgupta.compose_animation.ui.theme.ComposeSamplesTheme
import kotlin.math.roundToInt
import androidx.compose.ui.graphics.Color as cc

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSamplesTheme {
                // A surface container using the 'background' color from the theme
                var selected by remember { mutableStateOf(false) }
                // Animates changes when `selected` is changed.
                val transition = updateTransition(selected, label = "")
                val borderColor by transition.animateColor(label = "") { isSelected ->
                    if (isSelected) cc(2247)
                    else cc(2247)
                }
                val elevation by transition.animateDp(label = "") { isSelected ->
                    if (isSelected) 10.dp else 2.dp
                }
                val color = remember { Animatable(cc.Yellow) }
                var offsetXx by remember { mutableStateOf(0f) }

                Surface(
                    onClick = { selected = !selected },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(2.dp, borderColor),
                    elevation = elevation
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .scrollable(
                                orientation = Orientation.Vertical,
                                state = rememberScrollState()
                            )
                            .padding(16.dp)
                    ) {
                        Text(text = "Hello, world!")
                        // AnimatedVisibility as a part of the transition.
                        transition.AnimatedVisibility(
                            visible = { targetSelected -> targetSelected },
                            enter = expandVertically(),
                            exit = shrinkVertically()
                        ) {
                            Text(text = "It is fine today.")
                        }
                        // AnimatedContent as a part of the transition.
                        transition.AnimatedContent { targetState ->
                            if (targetState) {
                                Text(text = "Selected")
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Phone, contentDescription = "Phone"
                                )
                            }
                        }
                        Text(
                            modifier = Modifier
                                .offset { IntOffset(offsetXx.roundToInt(), 0) }
                                .draggable(orientation = Orientation.Horizontal,
                                    state = rememberDraggableState { delta ->
                                        offsetXx += delta
                                    }),
                            text = "Drag me!",
                        )
                        Box() {
                            var offsetX by remember { mutableStateOf(0f) }
                            var offsetY by remember { mutableStateOf(0f) }
                            Box(
                                Modifier
                                    .offset {
                                        IntOffset(
                                            offsetX.roundToInt(), offsetY.roundToInt()
                                        )
                                    }
                                    .background(cc.Blue)
                                    .size(50.dp)
                                    .pointerInput(Unit) {
                                        detectDragGestures { change, dragAmount ->
                                            change.consumeAllChanges()
                                            offsetX += dragAmount.x
                                            offsetY += dragAmount.y
                                        }
                                    })
                        }
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    AnimatedVisibilitySample()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeableSample() {
    val width = 96.dp
    val squareSize = 48.dp
    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

    Box(
        modifier = Modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .background(cc.LightGray)
    ) {
        Box(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(squareSize)
                .background(cc.DarkGray)
        )
    }
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