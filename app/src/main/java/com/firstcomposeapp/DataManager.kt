package com.firstcomposeapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.firstcomposeapp.models.Quote
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {
     var dataList = emptyArray<Quote>()
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote:Quote?=null

    var isDataLoaded = mutableStateOf(false)
    fun loadAssertFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        dataList = Gson().fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true;
    }


    fun switchPages(quote: Quote?){
        if (currentPage.value == Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }

}