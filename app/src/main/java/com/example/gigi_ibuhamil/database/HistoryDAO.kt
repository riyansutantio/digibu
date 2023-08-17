package com.example.gigi_ibuhamil.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlin.collections.List

@Dao
interface HistoryDatabaseDao{
    @Query("SELECT * FROM history")
    fun getAll(): LiveData<List<HistoryItem>>

    @Query("SELECT * FROM history WHERE Id = :id")
    fun getById(id: Int): HistoryItem?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item:HistoryItem)

    @Update
    fun update(item: HistoryItem)

    @Delete
    fun delete(item: HistoryItem)

    @Query("DELETE FROM history")
    fun deleteAllHistory()
}