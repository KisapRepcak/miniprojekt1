package com.example.miniprojekt1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ProductViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: ProductRepository
    val allProduct: LiveData<List<Product>>

    init {
        val productDao = ProductDB.getDatabase(app).productDao()
        repository = ProductRepository(productDao)
        allProduct = repository.allProduct
    }

    fun insert(product: Product) = repository.insert(product)
//    fun update() = repository.update()
    fun delete(product: Product) = repository.delete(product)
    fun deleteAll() = repository.deleteAll()
}