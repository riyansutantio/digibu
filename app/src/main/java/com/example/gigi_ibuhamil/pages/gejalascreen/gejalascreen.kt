@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.gigi_ibuhamil.pages.gejalascreen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.models.listgejala
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.Screen
import com.example.gigi_ibuhamil.util.lists

@ExperimentalFoundationApi
@Composable
fun GejalaScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        GejalaTitle(navController)
        GejalaSection(
            gejala = lists().gejalalist
        )
    }
}

@Composable
fun GejalaTitle(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Row() {
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(Screen.WelcomeScreen.route){popUpTo(0)} }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "ArrowBack")
            }
            Text(
                text = "BMI dan Pola Makan",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(bottom = 30.dp).weight(3f)
            )
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun GejalaSection(gejala:List<listgejala>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(1),
            contentPadding = PaddingValues(5.dp),
            modifier = Modifier
                .fillMaxHeight(),
            content = {
                items(gejala.size){
                    Gejalaitems(item = gejala[it],iter = it)
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Gejalaitems(item: listgejala, iter: Int) {
    var expandableState by remember { mutableStateOf(false) }
    var lines = 1
    val rotation by animateFloatAsState(
        targetValue =
        if (expandableState) 180f
        else 0f
    )
    BoxWithConstraints(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            onClick = {
                expandableState = !expandableState
            }
        ){
            Surface(
                modifier = Modifier
                    .background(DaftarColor)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = item.id,
                            fontSize = 25.sp,
                            color = Color.White,
                            textAlign = TextAlign.Left,
                            maxLines = lines,
                            modifier = Modifier
                                .background(DaftarColor)
                                .padding(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .weight(6f)
                        )
                        Button(
                            modifier = Modifier
                                .weight(1f)
                                .rotate(rotation),
                            onClick = {expandableState = !expandableState}) {
                            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "arrow")
                        }
                    }
                    if(expandableState){
                        lines = 2
                        Column(
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Text(
                                text = "\nDeskripsi",
                                fontSize = 25.sp
                            )
                            Text(
                                text = item.namagejala,
                                fontSize = 20.sp
                            )

                        }
                    }
                }
            }
        }
    }
}
