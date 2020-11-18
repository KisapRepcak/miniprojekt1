package com.example.miniprojekt1

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_own_settings.*

class OwnSettingsActivity : AppCompatActivity() {

    private lateinit var sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_own_settings)
        sp = getSharedPreferences("prefs_file1", Context.MODE_PRIVATE)

    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
    }

    @SuppressLint("CommitPrefEdits")
    fun click(view: View) {
        val selected_id = rg1.checkedRadioButtonId
        val editor = sp.edit()
        editor.putString("color1", findViewById<RadioButton>(selected_id).text.toString())

    }
}