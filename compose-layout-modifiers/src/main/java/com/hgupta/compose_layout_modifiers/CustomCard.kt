package com.hgupta.compose_layout_modifiers

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ArtistCard() {
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
                modifier = Modifier.size(width = 400.dp, height = 80.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredSize(80.dp)
                        .border(BorderStroke(2.dp, Color.Red.copy(alpha = 0.5f)), CircleShape)
                        .weight(1f)
                        .padding(4.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .weight(3f)
                ) {
                    Text(
                        text = "Hritik Gupta",
                        modifier = Modifier.paddingFromBaseline(top = 10.dp),
                        style = TextStyle(
                            color = Color.Black.copy(alpha = 0.7f),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                    Text(
                        text = "3 minutes ago",
                        color = Color.Black.copy(alpha = 0.4f),
                        modifier = Modifier.offset(x = 0.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold, fontSize = 16.sp
                        )
                    )

                }
            }
        }
    }
}

@Composable
fun CoilImageCard() {
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Magenta.copy(alpha = 0.6f)),
        modifier = Modifier.padding(top = 8.dp, start = 4.dp, end = 4.dp, bottom = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = 0.4f))
                .padding(4.dp)
        ) {
            AsyncImage(
                model = "https://developer.android.com/static/images/jetpack/compose/graphics-bw.png",
                contentDescription = "Test",
                modifier = Modifier
                    .requiredSize(80.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
            )
        }
    }
}