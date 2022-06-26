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
                        Toast.makeText(current, "Berhasil Login, Mengarahkan ke halaman utama", Toast.LENGTH_SHORT).show()
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
                text = "Menggunakan Google",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(start = 10.dp,bottom = 30.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            GoogleSignInButtonUi(text = "Sign In dengan Google",
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