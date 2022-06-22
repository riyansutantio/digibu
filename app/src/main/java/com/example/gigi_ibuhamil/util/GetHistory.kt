package com.example.gigi_ibuhamil.util

import android.util.Log
import com.example.gigi_ibuhamil.models.Result
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

fun getHistory() {
    val db = Firebase.firestore
    val historyRef = db.collection("result")
    val historyList = ArrayList<Data>()
//    Read Data Success. Belum bisa di add
    historyRef.addSnapshotListener {
            snapshot, e ->
        if (snapshot != null) {
            snapshot.documents?.forEach{ document ->
                val doc = document["history"] as ArrayList<Map<String, String>>
                for (elements in doc){
                    println(elements)
                    println(elements["email"])
                }
            }
        }
    }

}

