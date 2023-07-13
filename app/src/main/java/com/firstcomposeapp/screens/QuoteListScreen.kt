package com.firstcomposeapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.firstcomposeapp.R
import com.firstcomposeapp.models.Quote


@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            "Quotes App",
            modifier = Modifier.padding(top = 25.dp, bottom = 25.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily(Font(R.font.roboto_regular))
        )
        QuoteList(data = data,onClick)


    }
}