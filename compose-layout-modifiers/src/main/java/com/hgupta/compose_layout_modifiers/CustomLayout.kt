package com.hgupta.compose_layout_modifiers

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hgupta.compose_layout_modifiers.ui.theme.ComposeSamplesTheme

@Composable
fun CustomLayout() {
    Column {
        BoxWithConstraints() {
            val minHeight = minHeight
            val maxHeight = maxHeight
            val minWidth = minWidth
            val maxWidth = maxWidth
            Column {
                Text(text = "Box With Constraints", modifier = Modifier
                    .drawBehind {
                        drawRect(
                            color = Color(0xFFBBAAEE)
                        )
                    }
                    .padding(4.dp))
                Text("My minHeight is $minHeight while my maxWidth is $maxWidth")
                Text("My minWidth is $minWidth while my maxHeight is $maxHeight")
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(modifier = Modifier
            .width(IntrinsicSize.Min)
            .align(Alignment.CenterHorizontally).border(0.7.dp, color = Color.DarkGray)) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.download),
                contentDescription = null,
                modifier = Modifier
                    .requiredSize(150.dp)
                    .clip(CircleShape)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_download_for_offline_24),
                contentDescription = null,
                modifier = Modifier
                    .requiredSize(30.dp)
                    .graphicsLayer {
                        this.translationX = -40.5f
                        this.translationY = -25.4f
                    }
                    .drawBehind {
                        drawCircle(color = Color.White, radius = 45f)
                    }
                    .align(Alignment.BottomEnd)

            )
        }
        Spacer(modifier = Modifier.height(15.dp))

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun DefaultPreview3() {
    ComposeSamplesTheme {
        CustomLayout()
    }
}