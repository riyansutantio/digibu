package com.example.gigi_ibuhamil.pages.ebookscreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.PdfViewer
import com.example.gigi_ibuhamil.util.Screen
import com.example.gigi_ibuhamil.R
import com.example.gigi_ibuhamil.ui.NoButton
import com.example.gigi_ibuhamil.ui.YesButton

@ExperimentalFoundationApi
@Composable
fun EbookScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        EbookTitle(navController)
        Isi()
    }
}

@Composable
fun EbookTitle(navController: NavController) {
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
                text = "E-Book",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .weight(3f)
            )
        }
    }
}

@Composable
fun Isi() {
    Column() {
        EbookItems()
    }
}

@Composable
fun EbookItems() {
    val context = LocalContext.current
    val intent1 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/0/folders/1vsouDmNBY6UGXDtC035YBjEyx9PYZRZk")) }
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Column() {
                    Text(
                        text = "Silahkan baca modul yang sudah disediakan oleh tim dengan menekan tombol dibawah ini.",
                        textAlign = TextAlign.Left,
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                    Button(
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(YesButton),
                        onClick = { context.startActivity(intent1) }) {
                        Text(
                            text = "Unduh Modul",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color.White,
                        )
                    }
                }
                //ComposePDFViewer()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposePDFViewer() {
    var isLoading by remember { mutableStateOf(false) }
    var currentLoadingPage by remember { mutableStateOf<Int?>(null) }
    var pageCount by remember { mutableStateOf<Int?>(null) }

    Box {
        PdfViewer(
            modifier = Modifier.fillMaxSize(),
            pdfResId = R.raw.sample,//letak pdf
            loadingListener = { loading, currentPage, maxPage ->
                isLoading = loading
                if (currentPage != null) currentLoadingPage = currentPage
                if (maxPage != null) pageCount = maxPage
            }
        )
        if (isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Gray
                    ),
                verticalArrangement = Arrangement.Center
            ) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    progress = if (currentLoadingPage == null || pageCount == null) 0f
                    else currentLoadingPage!!.toFloat() / pageCount!!.toFloat()
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 5.dp)
                        .padding(horizontal = 30.dp),
                    text = "${currentLoadingPage ?: "-"} pages loaded/${pageCount ?: "-"} total pages"
                )
            }
        }
    }
}
