package com.aj.myvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aj.myvvm.data.ItemsRepository
import com.aj.myvvm.data.db.Items
import com.aj.myvvm.data.db.ItemsDatabase
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ItemsRepository

    val allItems: LiveData<List<Items>>

    init {
        val dao = ItemsDatabase.getDatabase(application).itemsDao()
        repository = ItemsRepository(dao)
        allItems = repository.allItems
    }

    fun insert(item: Items) {
        viewModelScope.launch {
            repository.insertItems(item)
        }
    }
}