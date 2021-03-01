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
package com.example.androiddevchallenge

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.CatViewModel

@Composable
fun MainLayout(context: Context){
    val snackbarHostState = SnackbarHostState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Cat Adoption")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        val viewModel: CatViewModel = viewModel()
        if (viewModel.currentCat == null) {
            CatListLayout(viewModel.catList) {
                viewModel.currentCat = it
            }
        } else {
            CatDetailInfo(viewModel.currentCat!!) {
                isAdopted ->
                if (isAdopted != null) {
                    var currentCat = viewModel.currentCat!!
                    if (isAdopted) {
                        Toast.makeText(context, "Cat ${currentCat.name} is adopted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Cat ${currentCat.name} adopt is cancel", Toast.LENGTH_SHORT).show()
                    }
                }
                viewModel.currentCat = null
            }
        }
    }
}