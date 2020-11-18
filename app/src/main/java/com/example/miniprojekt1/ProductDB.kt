package com.example.miniprojekt1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 3)
abstract class ProductDB : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object{
        private var instance: ProductDB? = null

        fun getDatabase(context: Context): ProductDB{
            val tmpInst = instance
            if(tmpInst != null){
                return tmpInst
            }
            val inst = Room.databaseBuilder(context.applicationContext,ProductDB::class.java,"productDB").fallbackToDestructiveMigration().allowMainThreadQueries().build() //MainThread nierekomendowany
            instance = inst
            return inst
        }
    }
}