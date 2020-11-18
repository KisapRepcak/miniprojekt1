package com.example.miniprojekt1

import androidx.lifecycle.LiveData

class ProductRepository(private val productDao: ProductDao){

    val allProduct: LiveData<List<Product>> = productDao.getProduct()

    fun insert(product: Product){
        productDao.insert(product)
    }

    fun delete(product: Product){
        productDao.delete(product)
    }
    fun update(idd: Long, name: String, price: String, amount: String){
        productDao.update(idd, name, price, amount)
    }
    fun deleteAll(){
        productDao.deleteAll()
    }

}