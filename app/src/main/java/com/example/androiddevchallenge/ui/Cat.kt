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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.CatInfo

@Composable
fun CatListLayout(catList: List<CatInfo>, onClick: (CatInfo) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(catList) {
            CatItemLayout(
                cat = it,
                Modifier.fillMaxWidth(), onClick
            )
        }
    }
}

@Composable
fun CatItemLayout(cat: CatInfo, modifier: Modifier = Modifier, onClick: (CatInfo) -> Unit) {
    Card(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(cat.picture),
                "Cat Name: ${cat.name}",
                Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(8.dp)
                    .width(180.dp)
            ) {
                Text("Name: ${cat.name}", fontWeight = FontWeight.Bold)
                Text("Age: ${cat.age}", fontWeight = FontWeight.Bold)
                Text("Gender: ${cat.gender}", fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = {
                    onClick(cat)
                }
            ) {
                Text(text = "Detail")
            }
        }
    }
}

@Composable
fun CatDetailInfo(cat: CatInfo, onClick: (Boolean?) -> Unit) {
    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = cat.picture), "Cat Name: ${cat.name}",
            Modifier
                .size(300.dp)
                .padding(top = 30.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(8.dp)
                .width(200.dp)
        ) {
            Text("Name: ${cat.name}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Location: ${cat.location}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Gender: ${cat.gender}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Age: ${cat.age}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(
                "vaccineInjected: ${cat.vaccineInjected}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Row {
            Button(
                onClick = {
                    if (!cat.isAdopted) {
                        cat.isAdopted = true
                        onClick(true)
                    } else {
                        cat.isAdopted = false
                        onClick(false)
                    }
                }
            ) {
                if (!cat.isAdopted) {
                    Text(text = "Adopt")
                } else {
                    Text(text = "Cancel")
                }
            }
            Button(
                onClick = {
                    onClick(null)
                },
                Modifier.padding(start = 30.dp)
            ) {
                Text(text = "Back")
            }
        }
    }
}
