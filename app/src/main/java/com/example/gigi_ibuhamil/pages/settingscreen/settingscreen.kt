package com.example.gigi_ibuhamil.pages.settingscreen

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
                onClick = { navController.navigate(Screen.WelcomeScreen.route){popUpTo(0)} }
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


@ExperimentalFoundationApi
@Composable
fun SettingsSection(items:List<settingModel>,navController: NavController) {
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
                items(items.size){
                    Settingitems(item = items[it], navController)
                }
            }
        )
    }
}

@Composable
fun Settingitems(item: settingModel,navController: NavController) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {val context = LocalContext.current
        var dialogState by remember { mutableStateOf(false) }
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
                        Text(fontSize = 15.sp, text = "Tidak",color = Color.White,)
                    }
                },
                dismissButton = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(NoButton),
                        onClick = {
                            getGoogleSignInClient(context).signOut().addOnCompleteListener{
                                Toast.makeText(context, "Logout Berhasil", Toast.LENGTH_SHORT).show()
                                SavedPreference.setDefaultEmail(context)
                                SavedPreference.setDefaultName(context)
                                navController.navigate(Screen.LoginScreen.route){popUpTo(0)}
                            }
                        }) {
                        Text(fontSize = 15.sp, text = "Ya",color = Color.White,)
                    }
                }
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
                        "S04" -> navController.navigate(Screen.TentangScreen.route)
                    }
                }
        ){
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
