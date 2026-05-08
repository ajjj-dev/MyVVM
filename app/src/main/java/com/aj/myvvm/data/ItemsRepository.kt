package com.aj.myvvm.data

import com.aj.myvvm.data.api.RetrofitClient
import com.aj.myvvm.data.db.Items
import com.aj.myvvm.data.db.ItemsDao

class ItemsRepository(
    private val dao: ItemsDao
) {
    val allItems = dao.getAllItems()

    suspend fun insertItems(item: Items) {
        dao.insertItems(item)
    }

    suspend fun getUsers() = RetrofitClient.api.getUsers()

}