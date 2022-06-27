package com.example.gigi_ibuhamil.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.example.gigi_ibuhamil.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun generatePDF(context: Context, directory: File){
    val db = Firebase.firestore
    val pageHeight = 1120
    val pageWidth = 792
    val pdfDocument = PdfDocument()
    val paint = Paint()
    val title = Paint()
    val divider = Paint()
    val myPageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
    val myPage = pdfDocument.startPage(myPageInfo)
    val canvas: Canvas = myPage.canvas
    val bitmap: Bitmap? = drawableToBitmap(context.resources.getDrawable(R.mipmap.logoapp))
    val scaleBitmap: Bitmap? = Bitmap.createScaledBitmap(bitmap!!, 120, 120, false)
    val no = Paint()
    canvas.drawBitmap(scaleBitmap!!, 40f, 40f, paint)
    title.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
    title.textSize = 25f
    title.color = ContextCompat.getColor(context, R.color.purple_200)
    canvas.drawText("Ibu Peri Cerita", 200f, 120f, title)
    canvas.drawText("Hasil kesimpulan user ", 200f, 80f, title)
    title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    title.color = ContextCompat.getColor(context, R.color.purple_200)
    title.textSize = 15f
    title.textAlign = Paint.Align.CENTER
    divider.textSize = 20f
    divider.color = ContextCompat.getColor(context, R.color.black)
    canvas.drawLine(50f,200f,740f,200f,divider)
    no.typeface = Typeface.create(Typeface.DEFAULT,Typeface.NORMAL)
    no.textSize = 20f
    no.color = ContextCompat.getColor(context, R.color.black)
    canvas.drawText("No",50f,250f,no)
    canvas.drawText("Nama",100f,250f,no)
//    canvas.drawText("Email",180f,250f,no)
    canvas.drawText("Tahun",290f,250f,no)
    canvas.drawText("Usia",380f,250f,no)
    canvas.drawText("Diagnosis",440f,250f,no)
    canvas.drawText("BMI",550f,250f,no)
    canvas.drawText("Pola",610f,250f,no)
    canvas.drawText("Perilaku",670f,250f,no)
    canvas.drawLine(50f,280f,740f,280f,divider)


    pdfDocument.finishPage(myPage)
    val file = File(directory, "Hasil_Diagnosis.pdf")

    try {
        pdfDocument.writeTo(FileOutputStream(file))
    } catch(ex : IOException){
        ex.printStackTrace()
    }
    pdfDocument.close()
}

fun drawableToBitmap(drawable: Drawable): Bitmap? {
    if (drawable is BitmapDrawable) {
        return drawable.bitmap
    }
    val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}
