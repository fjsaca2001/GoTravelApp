package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        begin()
        exit()
    }

    fun begin (){
        val objetoIntent: Intent =intent
        var Nombre=objetoIntent.getStringExtra("Nombre")
        var txtEdad = findViewById<TextView>(R.id.txtwelcome)
        txtEdad.text=("Bienvenido : $Nombre")
    }
    fun exit (){
        var salida = findViewById<ImageButton>(R.id.exitButtom)
        salida.setOnClickListener{
            val saltar: Intent =Intent(this,MainActivity::class.java)
            startActivity(saltar)
        }
    }
}