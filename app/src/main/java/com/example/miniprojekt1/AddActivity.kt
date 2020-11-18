package com.example.miniprojekt1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddActivity : AppCompatActivity() {

    private lateinit var productViewModel2: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }
}