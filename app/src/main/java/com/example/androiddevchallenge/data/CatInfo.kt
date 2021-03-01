package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

data class CatInfo(val name: String,
                   val location: String,
                   val gender: String,
                   val age: String,
                   val vaccineInjected: String,
                   @DrawableRes val picture: Int
                   ) {
    var isAdopted: Boolean by mutableStateOf(false)
}