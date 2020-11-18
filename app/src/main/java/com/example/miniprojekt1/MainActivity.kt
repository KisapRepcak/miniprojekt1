package com.example.miniprojekt1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.miniprojekt1.databinding.ActivityListBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent1 = Intent(baseContext, ListActivity::class.java)
        bt1.setOnClickListener{
            startActivity(intent1)
        }
        val intent2 = Intent(baseContext, OwnSettingsActivity::class.java)
        fab1.setOnClickListener{
            startActivity(intent2)
        }
    }

    fun click(view: View) {}


}