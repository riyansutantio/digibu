package com.example.gigi_ibuhamil.pages.kesimpulanscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen


@ExperimentalFoundationApi
@Composable
fun KesimpulanScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        KesimpulanTitle()
        Isi(navController)
    }
}

@Composable
fun KesimpulanTitle() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Row(Modifier.padding(start = 10.dp)) {
            Text(
                text = "Kesimpulan",
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
    val context = LocalContext.current
    val nama = SavedPreference.getDisplayName(context = context).toString()
    val diagnosis = SavedPreference.getDiagnosis(context = context).toString()
    val email = SavedPreference.getEmail(context = context).toString()
    val bmi = SavedPreference.getBMI(context = context).toString()
    val perilaku = SavedPreference.getPerilaku(context = context).toString()
    val pola = SavedPreference.getPola(context = context).toString()
    var dialogState by remember { mutableStateOf(false) }

    var namaController by remember { mutableStateOf(TextFieldValue(nama)) }
    var emailController by remember { mutableStateOf(TextFieldValue(email)) }
    var diagnosisController by remember { mutableStateOf(TextFieldValue(diagnosis)) }
    var bmiController by remember { mutableStateOf(TextFieldValue(bmi)) }
    var perilakuController by remember { mutableStateOf(TextFieldValue(perilaku)) }
    var polaController by remember { mutableStateOf(TextFieldValue(pola)) }
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
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (dialogState == true) {
                    AlertDialog(
                        modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                        onDismissRequest = { dialogState = false },
                        title = {
                            Text(
                                fontSize = MaterialTheme.typography.h5.fontSize,
                                textAlign = TextAlign.Center,
                                text = "Peringatan"
                            )
                        },
                        text = {
                            Text(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                text = "Data hasil diagnosis anda akan kami rekam untuk kepentingan penelitian dan data pribadi anda akan kami jaga kerahasiaannya."
                            )
                        },
                        confirmButton = {
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                onClick = {
                                    dialogState = false
                                    navController.navigate(Screen.WelcomeScreen.route) { popUpTo(0) }
                                    SavedPreference.setDefaultDiagnosis(context)
                                    SavedPreference.setDefaultBMI(context)
                                    SavedPreference.setDefaultPerilaku(context)
                                    SavedPreference.setDefaultPolaMakan(context)
                                }) {
                                Text(fontSize = 15.sp, text = "Baik saya mengerti")
                            }
                        },
                        dismissButton = {
                        }
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(5.dp)
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
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    OutlinedTextField(
                        value = emailController,
                        onValueChange = { emailController = it },
                        enabled = false,
                        label = { Text("E-Mail", color = Color.White) },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    OutlinedTextField(
                        value = diagnosisController,
                        onValueChange = { diagnosisController = it },
                        enabled = false,
                        label = { Text("Diagnosis", color = Color.White) },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    OutlinedTextField(
                        value = bmiController,
                        onValueChange = { bmiController = it },
                        enabled = false,
                        label = { Text("BMI", color = Color.White) },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    OutlinedTextField(
                        value = perilakuController,
                        onValueChange = { perilakuController = it },
                        enabled = false,
                        label = { Text("Perilaku Kesgilut", color = Color.White) },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    OutlinedTextField(
                        value = polaController,
                        onValueChange = { polaController = it },
                        enabled = false,
                        label = { Text("Pola Makan", color = Color.White) },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            cursorColor = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    Button(onClick = {
                        dialogState = true
                    }) {
                        Text(text = "Back to home")
                    }
                }
            }
        }
    }
}
