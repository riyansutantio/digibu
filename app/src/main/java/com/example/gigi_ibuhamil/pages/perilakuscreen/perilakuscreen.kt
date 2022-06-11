package com.example.gigi_ibuhamil.pages.perilakuscreen

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
import com.example.gigi_ibuhamil.models.listperilaku
import com.example.gigi_ibuhamil.models.listpolamakan
import com.example.gigi_ibuhamil.ui.YesButton
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import com.example.gigi_ibuhamil.util.lists
import java.math.RoundingMode

val TAG = "Pertanyaan Perilaku"
val ques:List<listperilaku> = lists().perilakulist
var total = 0
var cur = 0
var result = "default"
@ExperimentalFoundationApi
@Composable
fun PerilakuScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        var dialogState by remember { mutableStateOf(false) }
        val context = LocalContext.current
        PerilakuTitle(navController)
        Question(quest = ques, navController = navController)
        if(cur == 2 ){
            dialogState = true
            if (dialogState == true){
                if (total == 5) {
                    result = "Salah"
                }else if(total == 9 ){
                    result = "Kurang tepat"
                }else if(total== 7){
                    result = "Sudah tepat"
                }else if(total== 11){
                    result = "Sangat tepat"
                }
                AlertDialog(
                    modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                    onDismissRequest = { dialogState = false},
                    title = {
                        Text(
                            fontSize = MaterialTheme.typography.h5.fontSize,
                            textAlign = TextAlign.Center,
                            text = "Hasil Perhitungan Perilaku Kesgilut anda"
                        )
                    },
                    text = {
                        if (total == 5) {
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Jumlah Skor anda : ${
                                    total
                                } \nPerilaku kesehatan gigi dan mulut anda salah "
                            )
                        }else if(total == 9 ){
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Jumlah Skor anda : ${
                                    total
                                } \nPerilaku kesehatan gigi dan mulut anda kurang tepat "
                            )
                        }else if(total== 7){
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Jumlah Skor anda : ${
                                    total
                                } \nPerilaku kesehatan gigi dan mulut anda sudah tepat "
                            )
                        }else if(total== 11){
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Jumlah Skor anda : ${
                                    total
                                } \nPerilaku kesehatan gigi dan mulut anda sangat tepat "
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                SavedPreference.setPerilaku(context, result)
                                Toast.makeText(context,
                                    SavedPreference.getPerilaku(context),
                                    Toast.LENGTH_SHORT).show()
                                dialogState = false
                                ResultReturn("Default")
                                CurReturn(0)
                                total = 0
                                navController.navigate(Screen.PerilakuScreen.route){popUpTo(0)}
                            }) {
                            Text(fontSize = 15.sp,text = "Mengulang proses perhitungan" )
                        }
                    },
                    dismissButton = {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                SavedPreference.setPerilaku(context, result)
                                Toast.makeText(context,
                                    SavedPreference.getPerilaku(context),
                                    Toast.LENGTH_SHORT).show()
                                dialogState = false
                                ResultReturn("Default")
                                CurReturn(0)
                                total = 0
                                navController.navigate(Screen.KesimpulanScreen.route){popUpTo(0)}
                            }) {
                            Text(fontSize = 15.sp,text = "Lanjutkan Ke Halaman kesimpulan")
                        }
                    }
                )
            }

        }
    }
}

@Composable
fun PerilakuTitle(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Row(Modifier.padding(start = 10.dp)) {
            Text(
                text = "Perilaku Kesgilut",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .weight(3f)
            )
        }
    }
}

@Composable
fun Question(quest:List<listperilaku>, navController: NavController) {
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
fun Pertanyaan(item: listperilaku, navController: NavController) {
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
        Row(){
            Button(
                onClick = {
                    total = total + item.point1
                    Toast.makeText(context,
                        total.toString(),
                        Toast.LENGTH_SHORT).show()
                    cur = item.next
                    navController.navigate(Screen.PerilakuScreen.route)
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
                    Toast.makeText(context,
                        total.toString(),
                        Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.PerilakuScreen.route)
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