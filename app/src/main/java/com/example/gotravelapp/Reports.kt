package com.example.gotravelapp

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_reports.*

class Reports : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")
        vista(email?:"")
        setContentView(R.layout.activity_reports)
        botonera(email?:"")

        progressBar.max = 10

        val currentProgress = 6

        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .start()
    }
    private fun vista(email: String) {
        db.collection("atractivos").document(email).get().addOnSuccessListener {
            obtenerAtractivoNombre.setText(it.get("Nombre del Lugar") as String?)
        }
    }

    private fun botonera(email: String){
        btnHome01.setOnClickListener(){
            val inicio: Intent = Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnPerfil.setOnClickListener(){
            val inicio: Intent = Intent(this,Perfil::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnExit.setOnClickListener{
            val saltar: Intent = Intent(this,MainActivity::class.java)
            startActivity(saltar)
        }
    }
}