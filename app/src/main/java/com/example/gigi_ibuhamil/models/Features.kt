package com.example.gigi_ibuhamil.models

import androidx.annotation.DrawableRes

data class featured(
    val id:String,
    val title:String,
    @DrawableRes val iconId: Int,
    val lightColor: androidx.compose.ui.graphics.Color,
    val mediumColor: androidx.compose.ui.graphics.Color,
    val darkColor: androidx.compose.ui.graphics.Color
)
