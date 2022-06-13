package com.example.gigi_ibuhamil.pages.polamakanscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.models.listpolamakan
import com.example.gigi_ibuhamil.ui.YesButton
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import com.example.gigi_ibuhamil.util.lists
import java.math.RoundingMode

val TAG = "Pertanyaan Polamakan"
val ques:List<listpolamakan> = lists().polamakanlist
var total = 0
var cur = 0
var result = "default"
@ExperimentalFoundationApi
@Composable
fun PolaMakanScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        var dialogState by remember { mutableStateOf(false) }
        val context = LocalContext.current
        PolaMakanTitle(navController)
        Question(quest = ques, navController = navController)
        if(cur == 5 ){
            dialogState = true
            if (dialogState == true){
                if (total <= 20 && total >= 14) {
                    result = "Baik"
                }else if(total <= 13 && total >= 7){
                    result = "Sedang"
                }else if(total <= 6 && total >= 0) {
                    result = "Buruk"
                }
                AlertDialog(
                    modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                    onDismissRequest = { dialogState = false},
                    title = {
                        Text(
                            fontSize = MaterialTheme.typography.h5.fontSize,
                            textAlign = TextAlign.Center,
                            text = "Hasil Perhitungan Pola Makan Anda"
                        )
                    },
                    text = {
                        if (total <= 20 && total >= 14) {
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Jumlah Skor anda : ${
                                    total
                                } \nPola Makan anda termasuk kedalam kategori baik"
                            )
                        }else if(total <= 13 && total >= 7){
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Jumlah Skor anda : ${
                                    total
                                } \nPola Makan anda termasuk kedalam kategori sedang"
                            )
                        }else if(total <= 6 && total >= 0){
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Jumlah Skor anda : ${
                                    total
                                } \nPola Makan anda termasuk kedalam kategori buruk"
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                SavedPreference.setPola(context, result)
                                dialogState = false
                                ResultReturn("Default")
                                CurReturn(0)
                                total = 0
                                navController.navigate(Screen.PolaMakanScreen.route){popUpTo(0)}
                            }) {
                            Text(fontSize = 15.sp,text = "Mengulang proses perhitungan" )
                        }
                    },
                    dismissButton = {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                SavedPreference.setPola(context, result)
                                dialogState = false
                                ResultReturn("Default")
                                CurReturn(0)
                                total = 0
                                navController.navigate(Screen.PerilakuScreen.route){popUpTo(0)}
                            }) {
                            Text(fontSize = 15.sp,text = "Lanjutkan Assessment")
                        }
                    }
                )
            }

        }
    }
}

@Composable
fun PolaMakanTitle(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Row(Modifier.padding(start = 10.dp)) {
            Text(
                text = "Pola Makan",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .weight(3f)
            )
        }
    }
}

@Composable
fun Question(quest:List<listpolamakan>, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        for (i in quest) {
            if (i.idpertanyaan == cur) {
                Pertanyaan(item = i, navController = navController)
            }
        }
    }
}

@Composable
fun Pertanyaan(item: listpolamakan, navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.soal,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 50.dp)
        )
        Column() {
            Row(){
                Button(
                    onClick = {
                        total = total + item.point1
                        cur = item.next
                        navController.navigate(Screen.PolaMakanScreen.route)
                        Log.d(TAG,"Diagnosa Pilihan ${item.jawaban1}")
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(YesButton),
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = item.jawaban1,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Button(
                    onClick = {
                        cur = item.next
                        total = total + item.point2
                        navController.navigate(Screen.PolaMakanScreen.route)
                        Log.d(TAG,"Diagnosa Pilihan ${item.jawaban2}")
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(YesButton),
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = item.jawaban2,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Row(){
                Button(
                    onClick = {
                        cur = item.next
                        total = total + item.point3
                        navController.navigate(Screen.PolaMakanScreen.route)
                        Log.d(TAG,"Diagnosa Pilihan ${item.jawaban3}")
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(YesButton),
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = item.jawaban3,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Button(
                    onClick = {
                        cur = item.next
                        total = total + item.point4
                        navController.navigate(Screen.PolaMakanScreen.route)
                        Log.d(TAG,"Diagnosa Pilihan ${item.jawaban4}")

                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(YesButton),
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = item.jawaban4,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}

fun ResultReturn(item: String): String {
    result = item
    return result
}
fun CurReturn(item: Int): Int {
    cur = item
    return cur
}