package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
        var txtMail = findViewById<TextView>(R.id.txtBienvenido)
        txtMail.text=(email)


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

        btnExit.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        btnHome.setOnClickListener(){
            val inicio: Intent= Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }
    }

    private fun error(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("!Error¡")
        builder.setMessage("Error al guardar los datos")
        builder.setPositiveButton("Aceptar", null)
        val dialogo: AlertDialog =builder.create()
        dialogo.show()
    }
}