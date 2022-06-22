package com.example.gigi_ibuhamil.util

import java.util.*

data class history(
    var history: ArrayList<Map<String, Objects>> = arrayListOf()
)

data class Data(
    var nama: String? = null,
    var email: String? = null,
    var bmi: String? = null,
    var perilaku: String? = null,
    var diagnosis: String? = null,
    var usia: String? = null,
    var tahun: String? = null,
    var pola: String? = null
)


