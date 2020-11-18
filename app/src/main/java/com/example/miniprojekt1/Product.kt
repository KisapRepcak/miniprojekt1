package com.example.miniprojekt1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(var name: String, var checked: Boolean, var price: String, var amount: String){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}