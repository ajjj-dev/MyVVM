package com.aj.myvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Items::class],
    version = 1,
    exportSchema = false
)
abstract class ItemsDatabase : RoomDatabase() {

    abstract fun itemsDao(): ItemsDao

    companion object {

        @Volatile
        private var INSTANCE: ItemsDatabase? = null

        fun getDatabase(context: Context): ItemsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    "itemsDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}