package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickIniciar()
    }

    fun clickIniciar(){
        var btn = findViewById<Button>(R.id.btnLogin)
        var txt1 = findViewById<EditText>(R.id.txtUser)

        btn.setOnClickListener{
            var txt = txt1.text.toString()
            println(txt)
        }
    }
}