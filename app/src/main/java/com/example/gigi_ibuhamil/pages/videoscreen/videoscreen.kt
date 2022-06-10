package com.example.gigi_ibuhamil.pages.videoscreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.Screen

@ExperimentalFoundationApi
@Composable
fun VideoScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        VideoTitle(navController)
        VideoPlayer()

    }
}

@Composable
fun VideoTitle(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Row() {
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(Screen.WelcomeScreen.route) { popUpTo(0) } }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "ArrowBack")
            }
            Text(
                text = "Video",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .weight(3f)
            )
        }
    }
}


@Composable
fun VideoPlayer() {
    val context = LocalContext.current
    val intent1 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zhawF9_lpM0")) }
    val intent2 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9C7FGC-ibY4")) }
    val intent3 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/k7kzc3Nof08")) }
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DaftarColor)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Column(Modifier
                .padding(10.dp), Arrangement.Center,Alignment.CenterHorizontally) {
                Text(
                    text = "Untuk pergi ke video pertama klik tombol di bawah",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.White,
                )
                Button(onClick = { context.startActivity(intent1) }) {
                    Text(
                        text = "Navigate to video 1!",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                    )
                }
            }
            Divider(color = Color.White, modifier = Modifier.fillMaxWidth().width(1.dp))
            Column(Modifier
                .padding(10.dp), Arrangement.Center,Alignment.CenterHorizontally) {
                Text(
                    text = "Untuk pergi ke video kedua klik tombol di bawah",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.White,
                )
                Button(onClick = { context.startActivity(intent2) }) {
                    Text(
                        text = "Navigate to video 2!",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                    )
                }
            }
            Divider(color = Color.White, modifier = Modifier.fillMaxWidth().width(1.dp))
            Column(Modifier
                .padding(10.dp), Arrangement.Center,Alignment.CenterHorizontally) {
                Text(
                    text = "Untuk pergi ke video ketiga klik tombol di bawah",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.White,
                )
                Button(onClick = { context.startActivity(intent3) }) {
                    Text(
                        text = "Navigate to video 3!",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                    )
                }
            }
        }
    }
}
































