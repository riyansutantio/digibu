package com.example.gigi_ibuhamil.models

import androidx.annotation.DrawableRes

data class listpenyakit(
    val id:String,
    val namaPenyakit:String,
    val deskripsi:String,
    val gejala:String,
    val penyebab:String,
    val penanganan:String,
    val pencegahan:String,
    val perawatan:String,
    @DrawableRes val gambar1: Int,
)