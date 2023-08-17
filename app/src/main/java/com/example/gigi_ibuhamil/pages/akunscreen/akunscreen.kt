package com.example.gigi_ibuhamil.pages.akunscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.models.User
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.YesButton
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

@ExperimentalFoundationApi
@Composable
fun AkunScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        AkunTitle(navController)
        Isi(navController)
    }
}

@Composable
fun AkunTitle(navController: NavController) {
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
                onClick = {
                    navController.navigate(Screen.SettingScreen.route) {
                        popUpTo(0)
                    }
                }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "ArrowBack")
            }
            Text(
                text = "Ubah Data Akun",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .weight(3f)
            )
        }
    }
}

@Composable
fun Isi(navController: NavController) {
    Column() {
        FormItems(navController)
    }
}

@Composable
fun FormItems(navController: NavController) {
    val context = LocalContext.current
    val db = Firebase.firestore
    val savedNama = SavedPreference.getDisplayName(context).toString()
    val savedEmail = SavedPreference.getEmail(context).toString()
    val savedAlamat = SavedPreference.getAlamat(context).toString()
    val savedDesa = SavedPreference.getDesa(context).toString()
    val savedUsia = SavedPreference.getUsia(context).toString()
    val savedTahun = SavedPreference.getTahun(context).toString()
    var nama by remember { mutableStateOf(TextFieldValue(savedNama)) }
    var email by remember { mutableStateOf(TextFieldValue(savedEmail)) }
    var alamat by remember { mutableStateOf(TextFieldValue(savedAlamat)) }
    var desa by remember { mutableStateOf(TextFieldValue(savedDesa)) }
    var tahun_kelahiran by remember { mutableStateOf(TextFieldValue(savedTahun)) }
    var usia_kelahiran by remember { mutableStateOf(TextFieldValue(savedUsia)) }
    var dialogState by remember { mutableStateOf(false) }
    val user = User(
        nama.text,
        email.text,
        tahun_kelahiran.text,
        usia_kelahiran.text,
        alamat.text,
        desa.text,
        "user")

    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DaftarColor)
        ) {
            Column() {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(15.dp)
                        .verticalScroll(rememberScrollState())
                        .weight(1f, false)
                ) {
                    OutlinedTextField(
                        value = nama,
                        label = { Text(text = "Nama", color = Color.White) },
                        onValueChange = {
                            nama = it
                        },
                        enabled = false,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White,
                        ),
                    )
                    OutlinedTextField(
                        value = email,
                        label = { Text(text = "E-Mail", color = Color.White) },
                        onValueChange = {
                            email = it
                        },
                        enabled = false,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White,
                        ),
                    )
                    OutlinedTextField(
                        value = alamat,
                        label = { Text(text = "Alamat", color = Color.White) },
                        onValueChange = {
                            alamat = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White,
                        ),
                    )
                    OutlinedTextField(
                        value = desa,
                        label = { Text(text = "Desa", color = Color.White) },
                        onValueChange = {
                            desa = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White,
                        ),
                    )
                    OutlinedTextField(
                        value = tahun_kelahiran,
                        label = { Text(text = "Tahun kelahiran", color = Color.White) },
                        onValueChange = {
                            tahun_kelahiran = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White,
                        ),
                    )
                    OutlinedTextField(
                        value = usia_kelahiran,
                        label = { Text(text = "Usia Kehamilan", color = Color.White) },
                        onValueChange = {
                            usia_kelahiran = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White,
                        ),
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(YesButton),
                        onClick = {
                            if (nama.text == "" || email.text == "" ||
                                alamat.text == "" || desa.text == "" ||
                                tahun_kelahiran.text == "" || usia_kelahiran.text == ""
                            ) {
                                Toast.makeText(context, "Mohon untuk tidak mengosongi input",
                                    Toast.LENGTH_SHORT).show()
                            } else {
                                dialogState = true
                            }
                        }) {
                        Text(text = "Update Data", color = Color.White, fontSize = 15.sp)
                    }
                    if (dialogState == true) {
                        AlertDialog(
                            modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                            onDismissRequest = { dialogState = false },
                            title = {
                                Text(
                                    fontSize = MaterialTheme.typography.h5.fontSize,
                                    textAlign = TextAlign.Center,
                                    text = "Mohon cek ulang data anda"
                                )
                            },
                            text = {
                                Text(
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                    text = "Pastikan anda telah memasukan data yang sesuai dengan identitas anda"
                                )
                            },
                            confirmButton = {
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    onClick = {
                                        dialogState = false
                                    }) {
                                    Text(fontSize = 15.sp, text = "Kembali")
                                }
                            },
                            dismissButton = {
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    onClick = {
                                        //tempat buat update data ke firestore
                                        try {
                                            db.collection("users").document(email.text)
                                                .set(user)
                                                .addOnSuccessListener {
                                                    navController.navigate(Screen.WelcomeScreen.route) {
                                                        popUpTo(0)
                                                    }
                                                    Toast.makeText(context,
                                                        "Berhasil mengupdate data user",
                                                        Toast.LENGTH_SHORT).show()
                                                }.addOnFailureListener {
                                                    Toast.makeText(context,
                                                        "Gagal mengupdate data user",
                                                        Toast.LENGTH_SHORT).show()
                                                }
                                        } catch (e: Exception) {
                                            println("we catch something")
                                        }
                                    }) {
                                    Text(fontSize = 15.sp, text = "Simpan Data")
                                }
                            }
                        )
                    }
                }

            }
        }
    }
}