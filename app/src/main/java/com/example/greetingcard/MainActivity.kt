package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage("Fatima", "all of us")
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, from: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Top,
        modifier = modifier.padding(24.dp)){
           Text(
                text = stringResource(R.string.hello, name),
                fontSize = 70.sp,
                lineHeight = 100.sp

            )
            Text(
                text = stringResource(R.string.signature, from),
                fontSize = 20.sp

                )
        }

    }

@Composable
fun GreetingImage(name: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.image1)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(name = name ,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
    }

}



@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        GreetingImage("Fatima","all of us")
    }
}