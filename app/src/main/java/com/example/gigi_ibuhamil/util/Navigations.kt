package com.example.gigi_ibuhamil.util

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gigi_ibuhamil.models.AuthViewModel
import com.example.gigi_ibuhamil.pages.aboutscreen.AboutScreen
import com.example.gigi_ibuhamil.pages.beratbadanscreen.BeratBadanScreen
import com.example.gigi_ibuhamil.pages.diagnosisscreen.DiagnosisScreen
import com.example.gigi_ibuhamil.pages.ebookscreen.EbookScreen
import com.example.gigi_ibuhamil.pages.firstscreen.FirstScreen
import com.example.gigi_ibuhamil.pages.gejalascreen.GejalaScreen
import com.example.gigi_ibuhamil.pages.kesimpulanscreen.KesimpulanScreen
import com.example.gigi_ibuhamil.pages.loginscreen.LoginScreen
import com.example.gigi_ibuhamil.pages.penyakitscreen.PenyakitScreen
import com.example.gigi_ibuhamil.pages.perilakuscreen.PerilakuScreen
import com.example.gigi_ibuhamil.pages.petunjukscreen.PetunjukScreen
import com.example.gigi_ibuhamil.pages.polamakanscreen.PolaMakanScreen
import com.example.gigi_ibuhamil.pages.splashscreen.SplashScreen
import com.example.gigi_ibuhamil.pages.videoscreen.VideoScreen
import com.example.gigi_ibuhamil.pages.welcomescreen.WelcomeScreen

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigations() {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(route = Screen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(authViewModel = AuthViewModel(),navController)
        }
        composable(route = Screen.WelcomeScreen.route){
            WelcomeScreen(navController)
        }
        composable(route = Screen.DiagnosisScreen.route){
            DiagnosisScreen(navController)
        }
        composable(route = Screen.GejalaScreen.route){
            GejalaScreen(navController)
        }
        composable(route = Screen.TentangScreen.route){
            AboutScreen(navController)
        }
        composable(route = Screen.PenyakitScreen.route){
            PenyakitScreen(navController)
        }
        composable(route = Screen.PetunjukScreen.route){
            PetunjukScreen(navController)
        }
        composable(route = Screen.EbookScreen.route){
            EbookScreen(navController)
        }
        composable(route = Screen.VideoScreen.route){
            VideoScreen(navController)
        }
        composable(route = Screen.InformationScreen.route){
            FirstScreen(navController)
        }
        composable(route = Screen.BeratBadanScreen.route){
            BeratBadanScreen(navController)
        }
        composable(route = Screen.PolaMakanScreen.route){
            PolaMakanScreen(navController)
        }
        composable(route = Screen.PerilakuScreen.route){
            PerilakuScreen(navController)
        }
        composable(route = Screen.KesimpulanScreen.route){
            KesimpulanScreen(navController)
        }

    }
}