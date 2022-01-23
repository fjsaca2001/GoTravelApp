package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_list_recurso.*

class ListRecurso : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")
        vista(email?:"")
        setContentView(R.layout.activity_list_recurso)
        botonera(email?:"")
    }

    private fun vista(email: String) {
        db.collection("atractivos").document(email).get().addOnSuccessListener {
            obtenerAtractivo.setText(it.get("Nombre del Lugar") as String?)
            obtenerProvincia.setText(it.get("Provincia") as String?)
            obtenerCanton.setText(it.get("Canton") as String?)
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