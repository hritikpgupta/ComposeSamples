package com.hgupta.compose_layout_modifiers

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hgupta.compose_layout_modifiers.ui.theme.ComposeSamplesTheme

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun DefaultPreview() {
    ComposeSamplesTheme {
        MyApp()
    }
}

@Composable
fun MyApp() {
    val scrollState = rememberScrollState()
    var pointerOffSet by remember {
        mutableStateOf(Offset(0f, 0f))
    }
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
//            .pointerInput("dragging") {
//                detectDragGestures { _, dragAmount ->
//                    pointerOffSet += dragAmount
//                }
//            }
//            .drawWithContent {
//                drawContent()
//                // draws a fully black area with a small keyhole at pointerOffset that’ll show part of the UI.
//                drawRect(
//                    Brush.radialGradient(
//                        listOf(Color.Transparent, Color.Black),
//                        center = pointerOffSet,
//                        radius = 80.dp.toPx(),
//                    )
//                )
//            }
//            .onSizeChanged {
//                pointerOffSet = Offset(it.width / 2f, it.height / 2f)
//            }
    ) {
        CustomLayout()
        CustomGraphicModifiers()
        ArtistCard()
        ImageCard()
        CoilImageCard()
    }
}





