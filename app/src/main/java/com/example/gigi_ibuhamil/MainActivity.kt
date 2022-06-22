package com.example.gigi_ibuhamil

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.app.ActivityCompat
import com.example.gigi_ibuhamil.util.Navigations
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.io.File




@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContent{
            Navigations()
        }
    }
    fun getDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
//            it.copyTo(File("/storage/emulated/0/Download"))
        }
        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }
}

