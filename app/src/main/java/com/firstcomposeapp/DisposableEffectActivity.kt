package com.firstcomposeapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ProduceStateScope
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme
import kotlinx.coroutines.delay

class DisposableEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                // mediaComposable()
                producerStateApp()
            }
        }
    }
}


@Composable
fun mediaComposable() {
    var context = LocalContext.current
    DisposableEffect(Unit) {
        var mediaPlayer = MediaPlayer.create(context, R.raw.goat)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }


}

@Preview
@Composable
fun producerStateApp() {
    loader()
}

@Composable
fun loader() {

    var degree = produceState(initialValue = 0) {
        while (true) {
            delay(1000)
            value = (value + 30) % 360
        }
    }

    Box(modifier = Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center, content = {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(degree.value.toFloat())
            )
            Text(
                text = "Loading", color = Color.Black, style = MaterialTheme.typography.titleMedium
            )
        }

    })


}


