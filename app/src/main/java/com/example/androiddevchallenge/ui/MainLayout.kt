package com.example.androiddevchallenge

import android.content.Context
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
        CatListLayout(context, viewModel.catList)
    }
}