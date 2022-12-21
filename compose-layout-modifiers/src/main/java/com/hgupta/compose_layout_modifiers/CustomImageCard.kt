package com.hgupta.compose_layout_modifiers

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageCard() {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Red.copy(alpha = 0.6f)),
        modifier = Modifier.padding(top = 8.dp, start = 4.dp, end = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = 0.4f))
                .padding(4.dp), verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.size(width = 400.dp, height = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)))
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)))
                )
                Image(
                    contentScale = ContentScale.FillHeight,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)))
                )


            }
            Row(
                modifier = Modifier.size(width = 400.dp, height = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)))
                )
                Image(
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)))
                )
                Image(
                    contentScale = ContentScale.Inside,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)))
                )


            }
            Row(
                modifier = Modifier.size(width = 400.dp, height = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(CircleShape)
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(4.dp, Color.Yellow.copy(alpha = 0.4f)), CircleShape)
                        .padding(4.dp)
                        .clip(CircleShape)
                )


            }
            Row(
                modifier = Modifier
                    .size(width = 400.dp, height = 100.dp)
                    .padding(top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .border(BorderStroke(4.dp, rainbowColorsBrush), CircleShape)
                        .padding(4.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(16f / 9f)
                )

            }
            Row(
                modifier = Modifier.size(width = 400.dp, height = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    colorFilter = ColorFilter.tint(Color.Red, blendMode = BlendMode.Darken),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(CircleShape)
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    colorFilter = ColorFilter.tint(Color.Red, blendMode = BlendMode.ColorDodge),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(CircleShape)
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(CircleShape)
                )
            }
            Row(
                modifier = Modifier.size(width = 400.dp, height = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.ColorBurn),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(CircleShape)
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    colorFilter = ColorFilter.tint(Color.Red, blendMode = BlendMode.Difference),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(CircleShape)
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(5f) }),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .clip(CircleShape)
                )
            }
            Row(
                modifier = Modifier.size(width = 400.dp, height = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .blur(
                            radiusX = 5.dp, radiusY = 5.dp, edgeTreatment = BlurredEdgeTreatment(
                                RoundedCornerShape(8.dp)
                            )
                        )
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .blur(
                            radiusX = 5.dp,
                            radiusY = 5.dp,
                            edgeTreatment = BlurredEdgeTreatment.Unbounded
                        )
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .blur(
                            radiusX = 5.dp,
                            radiusY = 5.dp,
                            edgeTreatment = BlurredEdgeTreatment.Rectangle
                        )
                )
            }
            Row(
                modifier = Modifier.size(width = 400.dp, height = 100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(90.dp)
                        .blur(
                            radiusX = 2.dp, radiusY = 2.dp, edgeTreatment = BlurredEdgeTreatment(
                                CircleShape
                            )
                        )
                )
            }
        }
    }
}