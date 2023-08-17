package com.example.gigi_ibuhamil.pages.historyscreen

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.database.HistoryItem
import com.example.gigi_ibuhamil.database.HistoryViewModel
import com.example.gigi_ibuhamil.database.HistoryViewModelFactory
import com.example.gigi_ibuhamil.models.listgejala
import com.example.gigi_ibuhamil.models.settingModel
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.NoButton
import com.example.gigi_ibuhamil.ui.YesButton
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import com.example.gigi_ibuhamil.util.getGoogleSignInClient
import com.example.gigi_ibuhamil.util.lists
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HistoryScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    val context = LocalContext.current
    val mTodoViewModel: HistoryViewModel = viewModel(
        factory = HistoryViewModelFactory(context.applicationContext as Application)
    )
    val items = mTodoViewModel.readAllData.observeAsState(listOf()).value
    Log.d("history",items.toString())
    Column {
        HistoryTitle(navController)
        HistorySection(list = items, mTodoViewModel)
    }
}

@Composable
fun HistoryTitle(navController: NavController) {
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
                onClick = { navController.navigate(Screen.SettingScreen.route) { popUpTo(0) } }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "ArrowBack")
            }
            Text(
                text = "History",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .weight(3f)
            )
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HistorySection(list: List<HistoryItem>, mTodoViewModel: HistoryViewModel) {
    val context = LocalContext.current
    var dialogState by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        if (dialogState) {
            AlertDialog(
                modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                title = {},
                onDismissRequest = {
                    dialogState = false
                },
                text = {
                    Text(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        text = "Apakah anda yakin untuk menghapus semua history? \n Semua data tidak akan bisa anda lihat kembali"
                    )
                },
                confirmButton = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(YesButton),
                        onClick = {
                            SavedPreference.setDefaultId(context)
                            dialogState = false
                        }) {
                        Text(fontSize = 15.sp, text = "Tidak", color = Color.White)
                    }
                },
                dismissButton = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(NoButton),
                        onClick = {
                            dialogState = false
                            mTodoViewModel.deleteAllHistory()
                            Toast.makeText(context, "History dihapus", Toast.LENGTH_SHORT).show()
                        }) {
                        Text(fontSize = 15.sp, text = "Ya", color = Color.White)
                    }
                }
            )
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 7.5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(NoButton),
                onClick = {
                dialogState = true
            }) {
                Text(text = "Delete all history",fontSize = 15.sp, color = Color.White)
            }
        }
        LazyColumn() {
            items(list) { history ->
                Historyitems(
                    nama = history.Name,
                    bmi = history.Bmi,
                    diagnose = history.Diagnosis,
                    email = history.Email,
                    pola = history.Pola,
                    prilaku = history.Perilaku,
                    tahun = history.Tahun,
                    usia = history.Usia
                )
            }
        }
    }
}

@Composable
fun Historyitems(nama:String, email: String, tahun:String, diagnose:String, bmi:String, prilaku:String,pola:String, usia:String) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DaftarColor)
                .padding(5.dp)
        ) {
            Row {
                Column() {
                    Text(
                        text = "Nama",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "Email",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "Tahun Lahir",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "Usia Kehamilan",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "Diagnosis",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "BMI",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "Pola Makan",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "Perilaku Kesgilut",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                Column() {
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = " : ",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                Column() {
                    Text(
                        text = nama,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = email,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 15.sp,
                        maxLines = 1,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = tahun,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = usia,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = diagnose,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = bmi,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = pola,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = prilaku,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }

            }
        }
    }
}