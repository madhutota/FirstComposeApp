package com.firstcomposeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true, heightDp = 500, widthDp = 300)
@Composable
fun previewItem() {
    LazyColumn(content = {
        items(populateList()) { category ->
            listCardItem(imd = category.imageId, title = category.title, subTitle = category.desc)
        }
    })
}

@Composable
fun listCardItem(imd: Int, title: String, subTitle: String) {

    Card(
        modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imd),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)

            )
            ItemDescription(title, subTitle, Modifier.weight(.8f))

        }
    }

}

@Composable
private fun ItemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.titleSmall)
        Text(
            text = subTitle,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Thin
        )


    }
}

data class Category(val imageId: Int, val title: String, val desc: String)

fun populateList(): MutableList<Category> {
    val listData = mutableListOf<Category>()
    listData.add(Category(R.drawable.profile, "Karthik", "2D Animator"))
    listData.add(Category(R.drawable.profile, "Satish", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Prudhvi", "Freelancer"))
    listData.add(Category(R.drawable.profile, "Anil K", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Satish", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Prudhvi", "Freelancer"))
    listData.add(Category(R.drawable.profile, "Anil K", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Satish", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Prudhvi", "Freelancer"))
    listData.add(Category(R.drawable.profile, "Anil K", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Satish", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Prudhvi", "Freelancer"))
    listData.add(Category(R.drawable.profile, "Anil K", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Satish", "Android Dev"))
    listData.add(Category(R.drawable.profile, "Prudhvi", "Freelancer"))
    listData.add(Category(R.drawable.profile, "Anil K", "Android Dev"))
    return listData
}