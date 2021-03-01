package com.example.androiddevchallenge

import android.content.Context
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.CatViewModel
import kotlinx.coroutines.launch

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