package com.example.composebasics

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
            ) {
                JetImage(image = painterResource(R.drawable.bg_compose_background))
                Title(
                    name = stringResource(R.string.jetpack_compose_tutorial),
                    modifier = Modifier.padding(16.dp), fontSize = 24
                )
                Paragraph(
                    paragraph = stringResource(R.string.jetpack_compose_is_a_modern_toolkit),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
                Paragraph(
                    paragraph = stringResource(R.string.in_this_tutorial),
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
    }
}

@Composable
fun JetImage(image: Painter, modifier: Modifier = Modifier) {
    Image(painter = image, contentDescription = null, modifier = modifier)
}

@Composable
fun Paragraph(paragraph: String, modifier: Modifier = Modifier,textAlign: TextAlign = TextAlign.Start) {
    Text(text = paragraph, modifier = modifier,style = TextStyle(textAlign = textAlign))
}

@Composable
fun Title(
    name: String,
    modifier: Modifier = Modifier,
    fontSize: Int,
    fontWeight: FontWeight = FontWeight.W300
) {
    Text(
        text = name,
        style = TextStyle(
            fontSize = fontSize.sp,
            textAlign = TextAlign.Center,
            fontWeight = fontWeight
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun TextBox(title: String, desc: String, color: Color, modifier: Modifier = Modifier) {

    Surface(
        color = color, modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Title(name = title, fontSize = 16, modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold)
            Paragraph(paragraph = desc, modifier = Modifier.padding(16.dp))
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    ComposeBasicsTheme {
        Scaffold {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                JetImage(image = painterResource(R.drawable.ic_task_completed))
                Title(
                    name = stringResource(R.string.all_tasks_completed),
                    fontSize = 16,
                    modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Title(
                    name = "Nice work!",
                    fontSize = 16,
                    modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun ComposeQuadrant() {
    ComposeBasicsTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
            ) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(Color.Green))
                {
                    TextBox(
                        title = stringResource(R.string.text_composable),
                        desc = stringResource(R.string.displays_text),
                        color = Color(0xFFEADDFF),
                        modifier = Modifier.weight(1f)

                    )
                    TextBox(
                        title = stringResource(R.string.image_composable),
                        desc = stringResource(R.string.creates_a_composable),
                        color = Color(0xFFD0BCFF),
                        modifier = Modifier.weight(1f)

                    )

                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Green))
                {
                    TextBox(
                        title = stringResource(R.string.row_composable),
                        desc = stringResource(R.string.a_layout_composable),
                        color = Color(0xFFB69DF8),
                        modifier = Modifier.weight(1f)

                    )
                    TextBox(
                        title = stringResource(R.string.column_composable),
                        desc = stringResource(R.string.a_layout),
                        color = Color(0xFFF6EDFF),
                        modifier = Modifier.weight(1f)

                    )

                }



            }
        }
    }
}