/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R

class CatViewModel : ViewModel() {
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
    var currentCat: CatInfo? by mutableStateOf(null)
}