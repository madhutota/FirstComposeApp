package com.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    circleImage()
                }
            }
        }
    }
}

//Modifier

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun firstFunction(
) {
    Text(
        text = "Hello Modifier",
        color = Color.White,
        //modifier = Modifier.size(100.dp).background(Color.Red)
        modifier = Modifier
            .background(Color.Blue)
            .requiredHeight(200.dp)
            .requiredWidth(200.dp)
            .padding(8.dp)
            .border(4.dp, Color.Red)
            .clip(CircleShape)
            .background(Color.Yellow)
    )


}

@Composable
fun circleImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Circle Image",
        modifier = Modifier.size(100.dp).clip(CircleShape).border(2.dp, Color.Red, CircleShape)
    )
}

