package com.example.gigi_ibuhamil.pages.loginscreen

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gigi_ibuhamil.models.AuthViewModel
import com.example.gigi_ibuhamil.ui.GoogleSignInButtonUi
import com.example.gigi_ibuhamil.ui.*
import com.example.gigi_ibuhamil.util.AuthResultContract
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch


private val TAG = "AuthScreen"
@ExperimentalMaterialApi
@Composable
fun LoginScreen(authViewModel: AuthViewModel, navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var text by remember { mutableStateOf<String?>(null) }
    val user by remember(authViewModel){authViewModel.user}.collectAsState()
    val signInRequestCode = 1
    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResultContract()){
                task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account==null){
                    Toast.makeText(context,"Google sign in failed", Toast.LENGTH_SHORT).show()
                    Log.d(TAG,"Sign to Google Failed,There no account")
                }else{
                    coroutineScope.launch {
                        authViewModel.signIn(email = account.email, displayName = account.displayName)
                    }
                }
            }catch (e: ApiException){
                Toast.makeText(context,"Google sign in failed", Toast.LENGTH_SHORT).show()
                Log.d(TAG,"Sign to Google Failed,API Error")
            }
        }
    AuthView(
        errorText = text,
        onClick = {
            text=null
            authResultLauncher.launch(signInRequestCode)
        }
    )
    user?.let{
        SavedPreference.setDisplayName(LocalContext.current,it.displayName)
        SavedPreference.setEmail(LocalContext.current,it.email)
        if(SavedPreference.getFirst(context).toString()== "true"){
            navController.navigate(Screen.WelcomeScreen.route){popUpTo(0)}
            Toast.makeText(LocalContext.current, "Sucessfull Login, Directing to Home", Toast.LENGTH_SHORT).show()
        }else{
            navController.navigate(Screen.InformationScreen.route){popUpTo(0)}
            Toast.makeText(LocalContext.current, "Sucessfull Login, Directing to Information Data", Toast.LENGTH_SHORT).show()
        }
        Log.d(TAG,"Successfull login,Directing to Welcome Screen")
    }
}

@ExperimentalMaterialApi
@Composable
fun AuthView(errorText:String?,onClick:() -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(gradbg)
    ) {
        Column(
            modifier = Modifier.padding(40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            )
            Text(
                text = "With Google",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(start = 10.dp,bottom = 30.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            GoogleSignInButtonUi(text = "Sign In With Google",
                loadingText = "Signing In....",
                onClicked = {onClick()})
            errorText?.let {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = it)
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}