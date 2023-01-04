package com.hgupta.compose_material_samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hgupta.compose_material_samples.ui.theme.ComposeSamplesTheme
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSamplesTheme {
        MyApp()
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(orientation = Orientation.Vertical, state = rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarSample()
        Spacer(modifier = Modifier.height(18.dp))
        BadgeBoxDemo()
        OutlinedButtonExample()
        TextButtonExample()
        Divider(startIndent = 8.dp, thickness = 2.dp, color = Color.Black)
        CircularIndicatorExample()
        Spacer(modifier = Modifier.height(2.dp))
        DropdownDemo()
        CheckBoxDemo()
        ExtendedFloatingActionButtonDemo()
        Spacer(modifier = Modifier.height(12.dp))
        LinearProgressIndicator()
        Spacer(modifier = Modifier.height(12.dp))
        LinearProgressIndicator(progress = 0.654f)
//        Spacer(modifier = Modifier.height(6.dp))
//        ShowSheet()
        Spacer(modifier = Modifier.height(4.dp))
        RadioButtonSample()
        MySliderDemo()
        SnackbarDemo()
        SwitchDemo()

    }
}

@Composable
fun TopAppBarSample(){
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text("I'm a TopAppBar")
            },
            backgroundColor =  MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            })

    }
}

@Composable
fun BadgeBoxDemo() {
    var value by remember { mutableStateOf(1) }
    BadgedBox(
        badge = {
            Badge(
                contentColor = Color.White, modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            ) { Text("$value", style = TextStyle(fontSize = 18.sp)) }
        }, modifier = Modifier
            .background(color = Color.White)
            .size(50.dp)

    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier
                .size(50.dp)
                .clickable { value += 1 },
        )
    }
}

@Composable
fun OutlinedButtonExample() {
    OutlinedButton(onClick = { /* Do something! */ }) {
        Text("I'm an Outlined Button")
    }
}

@Composable
fun TextButtonExample() {
    TextButton(
        onClick = {}
    ) {
        Text("Text Button Example")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShowSheet() {
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(sheetContent = {
        LazyColumn {
            items(25) {
                ListItem(text = { Text("Item $it") }, icon = {
                    Icon(
                        Icons.Default.Favorite, contentDescription = "Localized description"
                    )
                })
            }
        }
    }, sheetState = state) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { state.show() } }) {
                Text("Click to show sheet")
            }
        }
    }
}

@Composable
fun CircularIndicatorExample() {
    Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.padding(top = 4.dp)) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.width(10.dp))
        CircularProgressIndicator(progress = 0.75f)
        Spacer(modifier = Modifier.width(10.dp))
        CircularProgressIndicator(progress = 0.35f, strokeWidth = 2.dp)
    }
}

@Composable
fun DropdownDemo() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C")
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .height(20.dp)
            .wrapContentSize(Alignment.TopStart)
    ) {
        Text(
            items[selectedIndex],
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(50.dp)
                .clickable(onClick = { expanded = true })
                .background(
                    Color.Gray
                )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(50.dp)
                .background(
                    Color.Red
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    Text(text = s)
                }
            }
        }
    }
}

@Composable
fun CheckBoxDemo() {
    val checkedState = remember { mutableStateOf(true) }
    Checkbox(checked = checkedState.value, onCheckedChange = { checkedState.value = it })
}

@Composable
fun ExtendedFloatingActionButtonDemo() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Filled.Favorite, "") },
        text = { Text("FloatingActionButton") },
        onClick = { /*do something*/ },
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    )
}

@Composable
fun RadioButtonSample() {
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun MySliderDemo() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Text(text = sliderPosition.toString())
    Slider(
        value = sliderPosition,
        steps = 5,
        valueRange = 1f..5f,
        onValueChange = { sliderPosition = it })
}

@Composable
fun SnackbarDemo() {
    Column {
        val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }

        Button(onClick = { setSnackBarState(!snackbarVisibleState) }) {
            if (snackbarVisibleState) {
                Text("Hide Snackbar")
            } else {
                Text("Show Snackbar")
            }
        }
        if (snackbarVisibleState) {
            Snackbar(
                action = {
                    Button(onClick = {}) {
                        Text("MyAction")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "This is a snackbar!") }
        }
    }
}

@Composable
fun SwitchDemo() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}


