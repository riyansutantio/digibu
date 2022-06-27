package com.example.gigi_ibuhamil.database

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<HistoryItem>>
    private val repository: HistoryRepository

    init {
        val historyDao = HistoryDatabase.getInstance(application).historyDatabaseDao()
        repository = HistoryRepository(historyDao)
        readAllData =repository.readAllData
    }
    fun insertProduct(history: HistoryItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertHistory(historyItem = history)
        }
    }
    fun deleteHistory(historyItem: HistoryItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteHistory(historyItem = historyItem)
        }
    }

    fun deleteAllHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllHistory()
        }
    }
}

class HistoryViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
