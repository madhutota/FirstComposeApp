package com.firstcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    listItemLayout(R.drawable.down, "Madhu", "Software Developer")
                }
            }
        }
    }
}

@Composable
fun listItemLayout(imageId: Int, name: String, occupation: String) {
    Row(Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imageId), contentDescription = "", Modifier.size(30.dp)
        )
        Column {
            Text(
                text = name, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp
            )
            Text(
                text = occupation,
                color = Color.Black,
                fontWeight = FontWeight.Thin,
                fontSize = 14.sp
            )
        }

    }

}

@Preview(showBackground = true, heightDp = 500, widthDp = 300)
@Composable
fun boxLayout() {

    listItemLayout(R.drawable.down, "Madhu", "Software Developer")
    //Frame Layout
    Box(contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.down), contentDescription = "Down Arrow")
        Image(painter = painterResource(id = R.drawable.up), contentDescription = "Up Arrow")

    }

}


//@Preview(showBackground = true, heightDp = 500, widthDp = 300)
@Composable
fun columnAndRow() {

    Column(
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start

        ) {
            Text(text = "Hello", fontSize = 16.sp, color = Color.Blue)
            Text(text = "Hello", fontSize = 14.sp, color = Color.Blue)
            textInput()
        }

        Row() {
            Text(text = "Row1", fontSize = 16.sp, color = Color.Blue)
            Text(text = "Row2", fontSize = 14.sp, color = Color.Blue)
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textInput() {
    var state = remember { mutableStateOf("") }
    TextField(value = state.value, onValueChange = {
        state.value = it
        Log.e("OnValueChange", it.toString())

    }, singleLine = true)

}
