package com.hgupta.compose_layout_modifiers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hgupta.compose_layout_modifiers.ui.theme.ComposeSamplesTheme


@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun DefaultPreview2() {
    ComposeSamplesTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            CustomGraphicModifiers()
        }
    }
}


@Composable
fun CustomGraphicModifiers() {
    val brush = Brush.linearGradient(
        listOf(
            Color(0xFF9E82F0), Color(0xFF42A5F5)
        )
    )
    Row {
        Text(
            text = "Sample",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .drawBehind {
                    drawRect(
                        color = Color(0xFFBBAAEE)
                    )
                }
                .padding(4.dp),
        )
        Text(
            text = "Images",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .drawBehind {
                    drawRect(
                        brush
                    )
                }
                .padding(4.dp),
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
    Row {
        Text(
            text = "Transformation x",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .graphicsLayer { this.scaleX = 0.9f }
                .drawBehind {
                    drawRect(
                        color = Color(0xFFBBAAEE)
                    )
                }
                .padding(4.dp),
        )
        Text(
            text = "Transformation y",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .graphicsLayer { this.scaleY = 1.3f }
                .drawBehind {
                    drawRect(
                        brush
                    )
                }
                .padding(4.dp),
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
    Row {
        Text(
            text = "Translation x",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .graphicsLayer { this.translationX = 48.4f }
                .drawBehind {
                    drawRect(
                        color = Color(0xFFBBAAEE)
                    )
                }
                .padding(4.dp),
        )
        Text(
            text = "Translation y",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .graphicsLayer { this.translationY = -60.3f }
                .drawBehind {
                    drawRect(
                        brush
                    )
                }
                .padding(4.dp),
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
    Row {
        Text(
            text = "Rotation x",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .graphicsLayer { this.rotationX = 48.4f }
                .drawBehind {
                    drawRect(
                        color = Color(0xFFBBAAEE)
                    )
                }
                .padding(4.dp),
        )
        Text(
            text = "Rotation y",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .graphicsLayer { this.rotationY = -60.3f }
                .drawBehind {
                    drawRect(
                        brush
                    )
                }
                .padding(4.dp),
        )
        Text(
            text = "Rotation z",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .graphicsLayer { this.rotationZ = -20.3f }
                .drawBehind {
                    drawRect(
                        brush
                    )
                }
                .padding(4.dp),
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
    Column(modifier = Modifier.padding(16.dp)) {
        Box(modifier = Modifier
            .size(200.dp)
            .border(2.dp, Color.Black)
            .graphicsLayer {
                clip = true
                shape = CircleShape
                translationY = 50.dp.toPx()
            }
            .background(Color(0xFFF06292))) {
            Text(
                text = "Hello Compose",
                style = TextStyle(color = Color.Black, fontSize = 46.sp),
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(500.dp))
                .background(Color.White)
        ) {
            Image(painter = painterResource(id = R.drawable.download),
                contentScale = ContentScale.FillBounds,
                contentDescription = "clock",
                modifier = Modifier
                    .requiredSize(200.dp)
                    .graphicsLayer {
                        this.alpha = 0.5f
                    })
        }

    }

}