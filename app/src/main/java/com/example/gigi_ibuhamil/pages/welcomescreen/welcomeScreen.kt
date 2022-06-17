package com.example.gigi_ibuhamil.pages.welcomescreen

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.ui.*
import com.example.gigi_ibuhamil.R
import com.example.gigi_ibuhamil.models.featured
import com.example.gigi_ibuhamil.util.*


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(gradbg)
            .padding(start = 5.dp, end = 5.dp, top = 5.dp)
    ) {
        Column {
            LogoutButton(navController)
            GreetingSection()
            MainMenu(navController)
            SecondMainMenu(navController)
            FeatureSection(
                features = lists().menulist,navController)
        }
    }
}

@Composable
fun LogoutButton(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.End
    ) {
        Text(text = "", modifier = Modifier.weight(3f))
        PopUpLogout(navController)
    }
}

@Composable
fun PopUpLogout(navController: NavController) {
    Column(
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "setting",
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(Screen.SettingScreen.route)
                    },
            )
        }
    }
}
@ExperimentalMaterialApi
@Composable
fun GreetingSection() {
    val context = LocalContext.current
    val name = SavedPreference.getDisplayName(context).toString()
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 10.dp)
    ) {
        Text(
            text = "Welcome",
            style = MaterialTheme.typography.h3
        )
        Text(
            text = "To Ibu Peri Cerita, ",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = name,
            style = MaterialTheme.typography.h6
        )
    }

}

@Composable
fun MainMenu(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screen.DiagnosisScreen.route)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(LightRed)
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()

        ){
            Column(
            ) {
                Text(
                    text = "Diagnosis",
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = "Tekan Untuk Memulai Diagnosis",
                    style = MaterialTheme.typography.body1
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.ic_diagnosis),
                contentDescription ="Menu Gejala"
            )

        }
    }
}
@Composable
fun SecondMainMenu(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(LightBlue)
                .padding(10.dp)
                .background(LightBlue)
                .clickable {
                    navController.navigate(Screen.EbookScreen.route)
                }
                .weight(1f)

        ){
            Text(
                text = "E-Book",
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "Tekan Untuk Melihat Modul",
                style = MaterialTheme.typography.body2
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(LightBlue)
                .padding(10.dp)
                .background(LightBlue)
                .clickable {
                    navController.navigate(Screen.VideoScreen.route)
                }
                .weight(1f)

        ){
            Text(
                text = "Video",
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "Tekan Untuk Melihat Video",
                style = MaterialTheme.typography.body2
            )
        }
    }
}
@ExperimentalFoundationApi
@Composable
fun FeatureSection(features: List<featured>,navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.dp,end = 7.dp,bottom = 10.dp),
            modifier = Modifier.fillMaxHeight(),
            content = {
                items(features.size){
                    FeaturedItems(feature = features[it],navController)
                }
            }
        )
    }
}


@ExperimentalFoundationApi
@Composable
fun FeaturedItems(feature: featured,navController: NavController) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
            .clickable {
                when (feature.id) {
                    "DG" -> navController.navigate(Screen.GejalaScreen.route)
                    "DP" -> navController.navigate(Screen.PenyakitScreen.route)
                    "P" -> navController.navigate(Screen.PetunjukScreen.route)
                    "T" -> navController.navigate(Screen.TentangScreen.route)
                }
            },
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //medium color path
        val mediumColoredPath1 = Offset(0f, height * 0.3f)
        val mediumColoredPath2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPath3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPath4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPath5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPath1.x, mediumColoredPath1.y)
            standardQuadFromTo(mediumColoredPath1, mediumColoredPath2)
            standardQuadFromTo(mediumColoredPath2, mediumColoredPath3)
            standardQuadFromTo(mediumColoredPath3, mediumColoredPath4)
            standardQuadFromTo(mediumColoredPath4, mediumColoredPath5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        //light color path
        val lightColoredPath1 = Offset(0f, height * 0.35f)
        val lightColoredPath2 = Offset(width * 0.1f, height * 0.4f)
        val lightColoredPath3 = Offset(width * 0.3f, height * 0.35f)
        val lightColoredPath4 = Offset(width * 0.65f, height.toFloat())
        val lightColoredPath5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(mediumColoredPath1.x, mediumColoredPath1.y)
            standardQuadFromTo(lightColoredPath1, lightColoredPath2)
            standardQuadFromTo(lightColoredPath2, lightColoredPath3)
            standardQuadFromTo(lightColoredPath3, lightColoredPath4)
            standardQuadFromTo(lightColoredPath4, lightColoredPath5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h5,
                lineHeight = 25.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Image(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "arrow",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 5.dp, horizontal = 10.dp),
                tint = Color.White
            )
            /*Text(
                text = "Start",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        when (feature.id) {
                            "DG" -> navController.navigate(Screen.GejalaScreen.route)
                            "DP" -> navController.navigate(Screen.PenyakitScreen.route)
                            "P" -> navController.navigate(Screen.PetunjukScreen.route)
                            "T" -> navController.navigate(Screen.TentangScreen.route)
                        }
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 5.dp, horizontal = 10.dp)
            )*/
        }
    }
}
