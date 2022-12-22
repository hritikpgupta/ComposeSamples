package com.hgupta.compose_text_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hgupta.compose_text_list.ui.theme.ComposeSamplesTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSamplesTheme {
        MyApp()
    }
}

@OptIn(ExperimentalTextApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Text(text = stringResource(id = R.string.name))
        Text(text = stringResource(id = R.string.name), color = Color.Red)
        Text(text = stringResource(id = R.string.name), fontSize = 30.sp)
        Text(text = stringResource(id = R.string.name), fontStyle = FontStyle.Italic)
        Text(text = stringResource(id = R.string.name), fontWeight = FontWeight.Bold)
        Text(
            text = stringResource(id = R.string.name),
            textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
        Text(
            text = stringResource(id = R.string.name), style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Blue, offset = Offset(5.0f, 10.0f), blurRadius = 3f
                ),
            )
        )
        Text(
            text = "Text Spanning",
            textAlign = TextAlign.Center,
            modifier = Modifier.width(200.dp)
        )
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        })
        Text(
            "hello ".repeat(50),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(200.dp)
        )

        val GradientColors = listOf(Cyan, Blue.copy(alpha = 0.5f), Color.Magenta)
        Text(
            text = stringResource(id = R.string.test),
            style = TextStyle(brush = Brush.linearGradient(colors = GradientColors)),
            modifier = Modifier
                .background(color = Color.Black)
                .width(160.dp)
        )

        var text by remember { mutableStateOf("") }
        val brush = remember {
            Brush.linearGradient(
                colors = GradientColors
            )
        }

        TextField(
            value = text, onValueChange = { text = it }, textStyle = TextStyle(brush = brush)
        )
        Text(buildAnnotatedString {
            append("Do not allow people to dim your shine\n")
            withStyle(
                SpanStyle(
                    brush = Brush.linearGradient(
                        colors = GradientColors
                    )
                )
            ) {
                append("because they are blinded.")
            }
            append("\nTell them to put some sunglasses on.")
        })
        SelectionContainer {
            Text("This text is selectable")
        }
        SelectionContainer {
            Column {
                Text("This text is selectable")
                Text("This one too")
                Text("This one as well")
                DisableSelection {
                    Text("But not this one")
                    Text("Neither this one")
                }
                Text("But again, you can select this one")
                Text("And this one too")
            }
        }

        var textValue by remember { mutableStateOf("Hello") }
        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Label") })
        OutlinedTextField(value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Label") })

    }

//    Spacer(modifier = Modifier.height(2.dp))
//    val nameList = listOf("James", "Jerry", "Joshuwa", "John", "Jerald", "Jeff")
//    LazyColumn(
//        contentPadding = PaddingValues(4.dp),
//        verticalArrangement = Arrangement.spacedBy(5.dp), reverseLayout = true
//    ) {
//        items(nameList) { name ->
//            NameCard(name = name)
//        }
//    }

}

@Composable
fun NameCard(name: String) {
    androidx.compose.material.Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Red.copy(alpha = 0.6f)),
        modifier = Modifier.padding(top = 8.dp, start = 4.dp, end = 4.dp)
    ) {
        Text(
            text = name,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
    }

}

