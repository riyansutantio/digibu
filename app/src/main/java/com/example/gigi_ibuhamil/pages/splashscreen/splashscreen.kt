package com.example.gigi_ibuhamil.pages.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gigi_ibuhamil.R
import com.example.gigi_ibuhamil.ui.gradbg
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Splash(navController)
}

@Composable
fun Splash(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    val context = LocalContext.current
    val savedEmail = SavedPreference.getEmail(context).toString()
    val loginHandler = if (savedEmail == "DefaultEmail" || savedEmail == "") Screen.LoginScreen.route else Screen.WelcomeScreen.route

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 3f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(5f).getInterpolation(it)
                }))
        // Customize the delay time
        delay(2000L)
        navController.navigate(loginHandler){popUpTo(0)}
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(gradbg))
    {
        // Change the logo
        Image(painter = painterResource(id = R.mipmap.logoapp),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }

}

@Preview
@Composable
fun SplashPreview() {
    Splash(navController = rememberNavController())
}