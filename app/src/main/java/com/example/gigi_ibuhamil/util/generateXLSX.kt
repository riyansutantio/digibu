package com.example.gigi_ibuhamil.util

import android.os.Environment
import android.util.Log
import com.example.gigi_ibuhamil.models.Result
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.*
import java.nio.file.Paths


fun CreateCsv() {
    val db = Firebase.firestore
    val datas = mutableMapOf<String,Result>()
    val result = db.collection("result").get()
    val workbook = HSSFWorkbook()
    val xlws = workbook.createSheet()
    val rowNomor = xlws.createRow(0)
    val colNomor = rowNomor.createCell(0)
    colNomor.setCellValue("Nomor")
    val colNama = rowNomor.createCell(1)
    colNama.setCellValue("Nama")
    val colEmail = rowNomor.createCell(2)
    colEmail.setCellValue("Email")
    val colTahun = rowNomor.createCell(3)
    colTahun.setCellValue("Tahun Lahir")
    val colUsia = rowNomor.createCell(4)
    colUsia.setCellValue("Usia Kehamilan")
    val colDiagnosis = rowNomor.createCell(5)
    colDiagnosis.setCellValue("Diagnosis")
    val colBmi = rowNomor.createCell(6)
    colBmi.setCellValue("BMI")
    val colPerilaku = rowNomor.createCell(7)
    colPerilaku.setCellValue("Perilaku Kesgilut")
    val colPola = rowNomor.createCell(8)
    colPola.setCellValue("Pola Makan")

    //data hasil mulai dari sini


    try {
        val file = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            ), "Hasil.xls"
        )
        val outputStream: FileOutputStream = FileOutputStream(
            file
        )
        workbook.write(outputStream)
        workbook.close()
        Log.d("Write xlsx file", "File generated")
        if (file.exists()) {
            Log.d("File Exist", "File exist")
            file.setExecutable(true)
            file.setReadable(true)
            file.setWritable(true)
        } else {
            Log.d("file not exist", "file not exist")
        }
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
        Log.d("FileNotFoundException", "FileNotFoundException")
    } catch (e: IOException) {
        e.printStackTrace()
        Log.d("IOException", "IOException")
    }
}