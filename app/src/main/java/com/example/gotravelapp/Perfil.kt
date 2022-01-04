package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_perfil.*

class Perfil : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")
        vista(email?:"")
    }

    private fun vista(email:String){
        val objIntent: Intent = intent
        title ="Perfíl"
        var txtMail = findViewById<TextView>(R.id.txtwelcome)
        txtMail.text=("Bienvenido: $email")


        btnGuardar.setOnClickListener(){
            db.collection("users").document(email).set(
                hashMapOf("Nombre" to txtNombre.text.toString(), "Apellido" to txtApe.text.toString(), "Direccion" to txtDir.text.toString())
            )
        }
        btnRecuperar.setOnClickListener(){
            db.collection("users").document(email).get().addOnSuccessListener {
                txtDir.setText(it.get("Direccion") as String?)
                txtApe.setText(it.get("Apellido") as String?)
                txtNombre.setText(it.get("Nombre") as String?)
            }
        }

        btnSalir.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}