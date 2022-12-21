package com.hgupta.compose_layout_modifiers

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
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
            .padding(4.dp)
            .fillMaxSize()
/*            .pointerInput("dragging") {
                detectDragGestures { _, dragAmount ->
                    pointerOffSet += dragAmount
                }
            }
            .drawWithContent {
                drawContent()
                // draws a fully black area with a small keyhole at pointerOffset that’ll show part of the UI.
                drawRect(
                    Brush.radialGradient(
                        listOf(Color.Transparent, Color.Black),
                        center = pointerOffSet,
                        radius = 50.dp.toPx(),
                    )
                )
            }
            .onSizeChanged {
                pointerOffSet = Offset(it.width / 2f, it.height / 2f)
            }*/
    ) {
        CustomGraphicModifiers()
        ArtistCard()
        ImageCard()
        CoilImageCard()

    }
}





