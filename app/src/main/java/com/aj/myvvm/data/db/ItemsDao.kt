package com.aj.myvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/*DAO (Data Access Object) interface used to define database operations for Room.*/
@Dao
interface ItemsDao {

    @Insert
    suspend fun insertItems(item: Items)
    @Query("select * from items")
    fun getAllItems(): LiveData<List<Items>>

}