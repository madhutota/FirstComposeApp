package com.firstcomposeapp.remember


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class SplashActivity : ComponentActivity() {
    val TAG = SplashActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                app()
            }
        }
    }
}


fun a() {
    Log.d("ComposeSample", "I am from A")
}

fun b() {
    Log.d("ComposeSample", "I am from B")
}

@Composable
fun app() {
    var state by remember { mutableStateOf(::a) }
    Button(onClick = {
        state = ::b
    }) {
        Text(text = "Click state")
    }
    LandingScreen(state)
}

@Composable
fun LandingScreen(value: () -> Unit) {
    val stateValue by rememberUpdatedState(value)

    LaunchedEffect(true) {
        delay(2000)
        stateValue()
    }

}