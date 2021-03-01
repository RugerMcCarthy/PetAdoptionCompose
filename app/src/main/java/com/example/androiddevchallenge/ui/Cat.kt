package com.example.androiddevchallenge

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.CatInfo
import kotlinx.coroutines.coroutineScope


@Composable
fun CatListLayout(context: Context, catList: List<CatInfo>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(catList) {
            CatItemLayout(context, cat = it,
                Modifier
                    .fillMaxWidth())
        }
    }
}

@Composable
fun CatItemLayout(context: Context, cat: CatInfo, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(
                painterResource(cat.picture),
                "Picture of dog: ${cat.name}",
                Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(8.dp).width(150.dp)) {
                Text("Name: ${cat.name}", fontWeight= FontWeight.Bold)
                Text("Location: ${cat.location}", fontWeight= FontWeight.Bold)
                Text("Gender: ${cat.gender}", fontWeight= FontWeight.Bold)
                Text("Age: ${cat.age}", fontWeight= FontWeight.Bold)
                Text("vaccineInjected: ${cat.vaccineInjected}", fontWeight= FontWeight.Bold)
            }
            Log.d("gzz", "cat:${cat} ${cat.hashCode()} ${cat.isAdopted}")
            Button(onClick = {
                if (!cat.isAdopted) {
                    Toast.makeText(context, "Cat ${cat.name} is adopted", Toast.LENGTH_SHORT).show()
                    cat.isAdopted = true
                } else {
                    Toast.makeText(context, "Cat ${cat.name} is unadopted", Toast.LENGTH_SHORT).show()
                    cat.isAdopted = false
                }}){
                    if (!cat.isAdopted) {
                        Text(text = "ADOPT")
                    } else {
                        Text(text = "UNADOPT")
                    }
            }
        }
    }
}