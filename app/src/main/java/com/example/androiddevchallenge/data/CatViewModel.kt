package com.example.androiddevchallenge.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R

class CatViewModel: ViewModel() {
    val catList by mutableStateOf(
        listOf(
            CatInfo("Judy", "Alabama", "Female", "9 Month", "Yes", R.drawable.cat_judy),
            CatInfo("Bob", "Georgia", "Male", "6 Month", "Yes", R.drawable.cat_bob),
            CatInfo("Diana", "Connecticut", "Female", "3 Month", "Yes", R.drawable.cat_diana),
            CatInfo("Gary", "Kansas", "Male", "8 Month", "No", R.drawable.cat_gary),
            CatInfo("Tom", "Delaware", "Male", "3 Month", "Yes", R.drawable.cat_tom),
            CatInfo("Alice", "Colorado", "Female", "4 Month", "No", R.drawable.cat_alice),
            CatInfo("Martin", "Indiana", "Male", "2 Month", "No", R.drawable.cat_martin),
            CatInfo("Joan", "California", "Male", "4 Month", "No", R.drawable.cat_joan),
        )
    )
}