package com.example.miniprojekt1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {

    @Query("SELECT * FROM product_table")
    fun getProduct(): LiveData<List<Product>>

    @Insert
    fun insert(product: Product)

    @Query("UPDATE product_table SET name = :name, amount = :amount, price = :price WHERE product_table.id = :idd")
    fun update(idd: Long, name: String, price: String, amount: String)

    @Delete
    fun delete(product: Product)

    @Query("DELETE FROM product_table WHERE product_table.id = :idd")
    fun deleteById(idd: Long)

    @Query("DELETE FROM product_table")
    fun deleteAll()

}