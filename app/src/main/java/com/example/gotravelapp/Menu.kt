package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        begin()
        exit()
        perfil()
        clickAddRecurso()
    }

    private fun begin (){
        val objetoIntent: Intent =intent
        var email=objetoIntent.getStringExtra("email")
        txtBienvenido.text=("Bienvenido : $email")
    }
    private fun exit (){
        var salida = findViewById<ImageButton>(R.id.btnExit)
        salida.setOnClickListener{
            val saltar: Intent =Intent(this,MainActivity::class.java)
            startActivity(saltar)
        }
    }

    private fun perfil(){
        val objetoIntent: Intent =intent
        var email=objetoIntent.getStringExtra("email")
        btnPerfil.setOnClickListener(){
            val inicio: Intent= Intent(this,Perfil::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }
    }

    private fun clickAddRecurso(){
        val objetoIntent: Intent =intent
        var email=objetoIntent.getStringExtra("email")
        btnAddRecurso.setOnClickListener(){
            val inicio: Intent= Intent(this, addRecurso::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }
    }
}