package com.example.gigi_ibuhamil.pages.loginscreen

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.example.gigi_ibuhamil.models.AuthViewModel
import com.example.gigi_ibuhamil.models.User
import com.example.gigi_ibuhamil.ui.GoogleSignInButtonUi
import com.example.gigi_ibuhamil.ui.*
import com.example.gigi_ibuhamil.util.AuthResultContract
import com.example.gigi_ibuhamil.util.SavedPreference
import com.example.gigi_ibuhamil.util.Screen
import com.google.android.gms.common.api.ApiException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


private val TAG = "AuthScreen"
@ExperimentalMaterialApi
@Composable
fun LoginScreen(authViewModel: AuthViewModel, navController: NavController) {
    val db = Firebase.firestore
    val context = LocalContext.current
    val emails = ArrayList<String>()
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
        navController,
        errorText = text,
        onClick = {
            text=null
            authResultLauncher.launch(signInRequestCode)
        }
    )
    user?.let{
        val current = LocalContext.current
        SavedPreference.setDisplayName(LocalContext.current,it.displayName)
        SavedPreference.setEmail(LocalContext.current,it.email)
        db.collection("users")
            .get()
            .addOnSuccessListener {
                    result ->
                for (i in result.documents){
                    val email = i.data?.get("email")?.toString()
                    Log.d("Saved", SavedPreference.getEmail(context).toString())
                    Log.d("Email", email.toString())
                    if(SavedPreference.getEmail(context).toString() != email) {
                        navController.navigate(Screen.InformationScreen.route) { popUpTo(0) }
                    }else{
                        Toast.makeText(current, "Success Login, Mengarahkan ke halaman utama", Toast.LENGTH_SHORT).show()
                        navController.navigate(Screen.WelcomeScreen.route) { popUpTo(0) }
                        break
                    }
                }
            }
        db.collection("users")
            .document(it.email.toString())
            .addSnapshotListener{
                document, e ->
                if(document != null){
                    val userData = document.toObject<User>()
                    SavedPreference.setAlamat(context, userData?.alamat)
                    SavedPreference.setUsia(context, userData?.usia_kelahiran)
                    SavedPreference.setTahun(context, userData?.tahun_kelahiran)
                    SavedPreference.setDesa(context, userData?.desa)
                    SavedPreference.setRole(context, userData?.role)
                }else{
                    Log.d(TAG, "No Such Document")
                }
            }
    }
}

@ExperimentalMaterialApi
@Composable
fun AuthView(navController: NavController,errorText:String?,onClick:() -> Unit) {
    val context = LocalContext.current
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
                text = "Dengan Google",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(start = 10.dp,bottom = 30.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            GoogleSignInButtonUi(text = "SignIn Dengan Google",
                loadingText = "Mencoba Masuk....",

                onClicked = {onClick()})
            errorText?.let {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = it)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Box(
            ){
            Button(
                onClick = {
                    SavedPreference.setDisplayName(context,"Guest")
                    SavedPreference.setEmail(context,"Guest@email.com")
                    SavedPreference.setAlamat(context, "Guest")
                    SavedPreference.setUsia(context, "")
                    SavedPreference.setTahun(context, "")
                    SavedPreference.setDesa(context, "")
                    SavedPreference.setRole(context, "Guest")
                    navController.navigate(Screen.WelcomeScreen.route){popUpTo(0)}
                    Toast.makeText(context, "Success Login, Mengarahkan ke halaman utama", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(ResetButton),
                modifier = Modifier.size(width = 200.dp, height = 40.dp)
            ) {
                Text(
                    text = "Login sebagai tamu",
                    color = Color.White,
                )
            }
            }
        }
    }
}