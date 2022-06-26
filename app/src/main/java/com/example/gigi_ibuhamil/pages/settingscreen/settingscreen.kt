package com.example.gigi_ibuhamil.pages.settingscreen

import android.Manifest
import android.app.*
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.R
import com.example.gigi_ibuhamil.models.Result
import com.example.gigi_ibuhamil.models.settingModel
import com.example.gigi_ibuhamil.ui.DaftarColor
import com.example.gigi_ibuhamil.ui.NoButton
import com.example.gigi_ibuhamil.ui.YesButton
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.io.File


private const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34

private fun foregroundPermissionApproved(context: Context): Boolean {
    val writePermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    val readPermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, Manifest.permission.READ_EXTERNAL_STORAGE
    )

    return writePermissionFlag && readPermissionFlag
}

private fun requestForegroundPermission(context: Context) {
    val provideRationale = foregroundPermissionApproved(context = context)
    if (provideRationale) {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE
        )
    } else {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE
        )
    }
}

 suspend fun getDataFromFirestore(): List<Result> {
    val data = FirebaseFirestore.getInstance().collection("result").get().await()
    return data.documents.mapNotNull{
        doc -> doc.toObject(Result::class.java)
    }
}

private suspend fun getData(){
    try {
        val data = getDataFromFirestore()
        for (i in data.indices){
            Log.d("Data", data[i].email)
        }
    } catch (e: Exception){
        Log.d("Not Found", e.toString())
    }
}
@ExperimentalMaterialApi
fun makeNotif(
    context: Context,
    channelId : String,
    notificationId: Int,
    textTitle: String,
    textContent: String,
    priority: Int = NotificationCompat.PRIORITY_HIGH
){
    val file = File(Environment.getExternalStorageDirectory(), "Download/Hasil.xls")
    Log.d("File Name", file.toString())

    val uri = FileProvider.getUriForFile(context, context.applicationContext.packageName + ".provider", file)
    Log.d("Path File", "" + uri);

    val pdfOpenIntent = Intent(Intent.ACTION_VIEW)
    pdfOpenIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    pdfOpenIntent.clipData = ClipData.newRawUri("", uri)
    pdfOpenIntent.setDataAndType(uri, "application/*")
    pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

    try {
        context.startActivity(pdfOpenIntent)
    } catch (activityNotFoundException: ActivityNotFoundException) {
        Toast.makeText(context, "There is no app to load corresponding Excel", Toast.LENGTH_LONG).show()
    }
    val pendingIntent : PendingIntent = PendingIntent.getActivity(context,0,pdfOpenIntent,0)

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.mipmap.logoapp)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
    with(NotificationManagerCompat.from(context)){
        notify(notificationId,builder.build())
    }
}
fun createNotificationChannel(channelId: String, context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Ibu Peri Cerita"
        val desc = "Sistem pakar diagnosis gigi dan mulut ibu hamil"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = desc
        }
        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun SettingScreen(navController: NavController) = Box(
    modifier = Modifier
        .background(gradbg)
        .fillMaxSize()
) {
    Column {
        SettingTitle(navController)
        SettingsSection(items = lists().listsetting, navController = navController)
    }
}

@Composable
fun SettingTitle(navController: NavController) {
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
                onClick = { navController.navigate(Screen.WelcomeScreen.route) { popUpTo(0) } }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "ArrowBack")
            }
            Text(
                text = "Settings",
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
fun SettingsSection(items: List<settingModel>, navController: NavController) {
    val context = LocalContext.current
    requestForegroundPermission(context)
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
                if (SavedPreference.getRole(context).toString() == "admin") {
                    items(items.size) {
                        Settingitems(item = items[it], navController)
                    }
                } else {
                    items(items.size - 2) {
                        Settingitems(item = items[it], navController)
                    }
                }
            }
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun Settingitems(item: settingModel, navController: NavController) {
    val context = LocalContext.current
    val db = Firebase.firestore
    val result = db.collection("result")
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        LaunchedEffect(Unit) {
            createNotificationChannel("Ibu Peri Cerita", context )
        }
        val context = LocalContext.current
        var dialogState by remember { mutableStateOf(false) }
        var dialogStateCetak by remember { mutableStateOf(false) }
        var dialogStateAddAdmin by remember { mutableStateOf(false) }
        var emailController by remember { mutableStateOf(TextFieldValue()) }
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
                        text = "Apakah anda yakin untuk Log Out?"
                    )
                },
                confirmButton = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(YesButton),
                        onClick = {
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
                            getGoogleSignInClient(context).signOut().addOnCompleteListener {
                                Toast.makeText(context, "Logout Berhasil", Toast.LENGTH_SHORT)
                                    .show()
                                SavedPreference.setDefaultEmail(context)
                                SavedPreference.setDefaultName(context)
                                navController.navigate(Screen.LoginScreen.route) { popUpTo(0) }
                            }
                        }) {
                        Text(fontSize = 15.sp, text = "Ya", color = Color.White)
                    }
                }
            )
        }
        if (dialogStateCetak) {
            AlertDialog(
                modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                title = {},
                onDismissRequest = {
                    dialogStateCetak = false
                },
                text = {
                    Text(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        text = "Cetak hasil diagnosis kedalam bentuk pdf"
                    )
                },
                confirmButton = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(YesButton),
                        onClick = {
                            dialogStateCetak = false
                            GlobalScope.launch (Dispatchers.Main) {
                                getData()
                                CreateCsv()
                            }
                            makeNotif(
                                context,
                                "Ibu Peri Cerita",
                                0,
                                "Successfully download Excel file",
                                "Click to open file"
                            )
                            Toast.makeText(context,"Generating Excel File, Check Notification", Toast.LENGTH_SHORT).show()
                        }) {
                        Text(fontSize = 15.sp, text = "Cetak", color = Color.White)
                    }
                },
                dismissButton = {}
            )
        }
        if (dialogStateAddAdmin) {
            AlertDialog(
                modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                title = {},
                onDismissRequest = {
                    dialogStateAddAdmin = false
                },
                text = {
                    Column() {
                        Text(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            text = "Tambah Admin"
                        )
                        OutlinedTextField(
                            value = emailController,
                            onValueChange = { emailController = it },
                            label = { Text("Email", color = Color.Blue) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Blue,
                                unfocusedBorderColor = Color.Blue,
                                cursorColor = Color.Blue),
                        )
                    }
                },
                confirmButton = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(YesButton),
                        onClick = {
                            dialogStateAddAdmin = false

                        }) {
                        Text(fontSize = 15.sp, text = "Add Admin", color = Color.White)
                    }
                },
                dismissButton = {}
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DaftarColor)
                .clickable {
                    when (item.id) {
                        "S01" -> navController.navigate(Screen.AkunScreen.route)
                        "S02" -> navController.navigate(Screen.HistoryScreen.route)
                        "S03" -> dialogState = true
                        "S04" -> dialogStateCetak = true
                        "S05" -> dialogStateAddAdmin = true
                    }
                }
        ) {
            Text(
                text = item.setting,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }



}
