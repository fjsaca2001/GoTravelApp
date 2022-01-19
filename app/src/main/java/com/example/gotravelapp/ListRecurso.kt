package com.example.gotravelapp

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
    }

    private fun vista(email: String) {
        db.collection("atractivos").document(email).get().addOnSuccessListener {
            obtenerAtractivo.setText(it.get("Nombre del Lugar") as String?)
            obtenerProvincia.setText(it.get("Provincia") as String?)
            obtenerCanton.setText(it.get("Canton") as String?)
        }

    }
}