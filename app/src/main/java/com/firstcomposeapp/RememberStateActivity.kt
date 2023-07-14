package com.firstcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme
import kotlinx.coroutines.delay

class RememberStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {

                CounterApp()
                // A surface container using the 'background' color from the theme
            }
        }
    }

    @Preview
    @Composable
    private fun CounterApp() {
        var count = remember { mutableStateOf<Int>(0) }
        LaunchedEffect(key1 = Unit) {
            delay(2000)
            count.value = 20
        }
        rememberStateComposeApp(count.value)
    }

    @Composable
    private fun updateCounterValue(value: Int) {


        Text(text = value.toString())

        rememberStateComposeApp(value)
    }


    //RememberState Compose

    @Composable
    fun rememberStateComposeApp(value: Int){
        var state = rememberUpdatedState(newValue = value)

        LaunchedEffect(key1 = Unit ){
            delay(5000)

            Log.d("RememberStateComposeApp",state.value.toString())

        }

        Text(text = value.toString())

    }


}

