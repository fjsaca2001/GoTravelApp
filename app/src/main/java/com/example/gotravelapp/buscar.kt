package com.example.gotravelapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_buscar.*
import kotlinx.android.synthetic.main.activity_buscar.btnExit
import kotlinx.android.synthetic.main.activity_buscar.btnHome01
import kotlinx.android.synthetic.main.activity_buscar.btnPerfil

class buscar() : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)
        var bundle: Bundle? =intent.extras
        var email:String? = bundle?.getString("email")
        view(email?:"")
        botonera(email?:"")
    }

    private fun view(email: String){
        btnBuscar.setOnClickListener(){
            var textoAbuscar = txtBuscar.text.toString()
            db.collection("atractivos").document(email).get().addOnSuccessListener {
                if (textoAbuscar.equals(it.get("Nombre del Lugar"))) {
                    val inicio: Intent = Intent(this, resultadoBuscar::class.java).apply {
                        putExtra("email", email)
                    }
                    startActivity(inicio)
                } else {
                    txtError.setText("!Error¡ No se encontraron coincidencias...")
                }
            }
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