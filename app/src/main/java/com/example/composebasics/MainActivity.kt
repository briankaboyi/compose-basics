package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column {
                JetImage(image = painterResource(R.drawable.bg_compose_background))
                Title(
                    name = stringResource(R.string.jetpack_compose_tutorial),
                    modifier = Modifier.padding(innerPadding).align(Alignment.CenterHorizontally),
                )
                Paragraph(paragraph = stringResource(R.string.jetpack_compose_is_a_modern_toolkit), modifier = Modifier.padding(start = 16.dp,end = 16.dp)  )
                Paragraph(paragraph = stringResource(R.string.in_this_tutorial), modifier = Modifier.padding(16.dp))
            }

        }
    }
}
@Composable
fun JetImage(image: Painter, modifier: Modifier=Modifier){
    Image(painter = image, contentDescription = null, modifier = modifier )

}
@Composable
fun Paragraph(paragraph:String ,modifier: Modifier=Modifier){
 Text(text = paragraph, modifier = modifier)
}
@Composable
fun Title(name:String,modifier: Modifier = Modifier){
    Text(text = name, style = TextStyle(fontSize = 24.sp,),  modifier = Modifier.padding(16.dp))
}