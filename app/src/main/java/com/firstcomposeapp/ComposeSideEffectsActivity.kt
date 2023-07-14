package com.firstcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme

class ComposeSideEffectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                previewFunction()
            }
        }
    }
}

@Composable
fun previewFunction() {

    var count = remember { mutableStateOf(0) }

   var value = count.value % 3==0;

    LaunchedEffect(key1 = value){
        Log.e("Counter App LaunchedEffect", "Second${count.value}")
    }


    Button(onClick = { count.value++ }) {
        Text(text = "Increment Count")

    }


}