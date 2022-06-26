package com.example.gigi_ibuhamil.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class HistoryRepository(private val historyDatabaseDao: HistoryDatabaseDao) {
    val searchResults = MutableLiveData<List<HistoryItem>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val readAllData: LiveData<List<HistoryItem>> = historyDatabaseDao.getAll()

    fun insertHistory(historyItem: HistoryItem){
        historyDatabaseDao.insert(historyItem)
    }

    suspend fun deleteHistory(historyItem: HistoryItem) {
        historyDatabaseDao.delete(historyItem)
    }

    suspend fun deleteAllHistory() {
        historyDatabaseDao.deleteAllHistory()
    }
}