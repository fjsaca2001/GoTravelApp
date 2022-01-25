package com.example.gotravelapp

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_reports.*



class Reports : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var contador = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)
        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")
        vista(email ?: "")
        botonera(email?:"")

    }
    private fun vista(email: String) {

        progressBar.max = 172


        var progreso = ""
        var total = 0



        db.collection("atractivos").document(email).get().addOnSuccessListener {
            obtenerAtractivoNombre.setText(it.get("Nombre del Lugar") as String?)
            progreso = it.get("Total") as String
            obtenerTotalAtractivos.setText(progreso)
            total = (progreso.toInt()*100)/172
            //obtenerPorcentajes.setText(total.toString())
            obtenerPorcentajes.text=("${total.toString()}%")
            ObjectAnimator.ofInt(progressBar,"progress",progreso.toInt())
                .setDuration(2000)
                .start()

        }


        progressBar.getProgressDrawable().setColorFilter(
            Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);



        println("Progreso")
        println(progreso)
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