package com.example.gigi_ibuhamil.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gigi_ibuhamil.util.FirebaseCallback
import com.example.gigi_ibuhamil.util.HistoryRepository
import kotlinx.coroutines.Dispatchers

class HistoryViewModel(
    private val repository: HistoryRepository = HistoryRepository()
):ViewModel(){
    fun getHistoryUsingCallback(callback: FirebaseCallback) = repository.getHistoryCallback(callback)

    val historyLiveData = liveData(Dispatchers.IO) {
        emit(repository.getHistoryFromFirestoreUsingCoroutines())
    }
}