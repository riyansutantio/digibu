package com.example.gigi_ibuhamil.pages.firstscreen

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.models.User
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@ExperimentalFoundationApi
@Composable
fun FirstScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        FirstTitle(navController)
        Isi(navController)
    }
}

@Composable
fun FirstTitle(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Row(Modifier.padding(start = 10.dp)) {
            Text(
                text = "Personal Data",
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
    val TAG = "add user's data"
    val context = LocalContext.current
    val db = Firebase.firestore
    val name = SavedPreference.getDisplayName(context).toString()
    val email = SavedPreference.getEmail(context).toString()
    var namaController by remember { mutableStateOf(TextFieldValue(name)) }
    var emailController by remember { mutableStateOf(TextFieldValue(email)) }
    var tahunController by remember { mutableStateOf(TextFieldValue()) }
    var usiaController by remember { mutableStateOf(TextFieldValue()) }
    var alamatController by remember { mutableStateOf(TextFieldValue("")) }
    var desaController by remember { mutableStateOf(TextFieldValue("")) }
    val user = User(
        namaController.text,
        emailController.text,
        tahunController.text,
        usiaController.text,
        alamatController.text,
        desaController.text,
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
                        value = namaController,
                        onValueChange = { namaController = it },
                        enabled = false,
                        label = { Text("Nama", color = Color.White) },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = emailController,
                        onValueChange = { emailController = it },
                        enabled = false,
                        label = { Text("Email", color = Color.White) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                    )
                    OutlinedTextField(
                        value = tahunController,
                        label = { Text(text = "Tahun Kelahiran", color = Color.White) },
                        onValueChange = {
                            tahunController = it
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
                        value = usiaController,
                        label = { Text(text = "Usia Kehamilan (minggu)", color = Color.White) },
                        singleLine = true,
                        onValueChange = {
                            usiaController = it
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                    )
                    OutlinedTextField(
                        value = alamatController,
                        label = { Text(text = "Alamat", color = Color.White) },
                        singleLine = true,
                        onValueChange = {
                            alamatController = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                    )
                    OutlinedTextField(
                        value = desaController,
                        label = { Text(text = "Desa", color = Color.White) },
                        singleLine = true,
                        onValueChange = {
                            desaController = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                    )
                    Button(onClick = {
                        try {
                            db.collection("users").document(emailController.text)
                                .set(user)
                                .addOnSuccessListener {
                                    Toast.makeText(context,
                                        "Sucessfull add user's data",
                                        Toast.LENGTH_SHORT).show()
                                }.addOnFailureListener {
                                    Toast.makeText(context,
                                        "Failed add user's data",
                                        Toast.LENGTH_SHORT).show()
                                }
                        } catch (e: Exception){
                            println("we catch something")
                        }
                    }) {
                        Text(text = "Simpan ", color = Color.White, fontSize = 15.sp)
                    }
                }

            }
        }
    }
}
