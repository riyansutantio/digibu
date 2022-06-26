package com.example.gigi_ibuhamil.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
class HistoryItem(

    @PrimaryKey(autoGenerate = true)
    var Id: Int,

    @ColumnInfo(name = "Name")
    var Name: String,

    @ColumnInfo(name = "Email")
    var Email: String,

    @ColumnInfo(name = "Diagnosis")
    var Diagnosis: String,

    @ColumnInfo(name = "Bmi")
    var Bmi: String,

    @ColumnInfo(name = "Perilaku")
    var Perilaku: String,

    @ColumnInfo(name = "Pola")
    var Pola: String,

    @ColumnInfo(name = "Usia")
    var Usia: String,

    @ColumnInfo(name = "Tahun")
    var Tahun: String,
) {


}