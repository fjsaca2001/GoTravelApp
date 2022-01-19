package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso.*
import kotlinx.android.synthetic.main.activity_perfil.*

class addRecurso : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso)

        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")
        vista(email?:"")

    }

    private fun vista(email: String) {
        btnGuardar01.setOnClickListener(){
            /*
            var listaDatos = arrayOf(
                txtNombreLugar.text.toString(),
                txtTipo.text.toString(),
                txtCategoria.text.toString(),
                txtSubtipo.text.toString(),
                txtProvincia.text.toString(),
                txtCanton.text.toString(),
                txtParroquia.text.toString(),
                txtCalleP.text.toString(),
                txtNumero.text.toString(),
                txtTrans.text.toString(),
                txtBarrio.text.toString(),
                txtLong.text.toString(),
                txtAltura.text.toString(),
                txtTipoAdmin.text.toString(),
                txtNombreAdmin.text.toString(),
                txtTelefono.text.toString()
            )

             */
            db.collection("atractivos").document(email).set(
                hashMapOf(
                    "Nombre del Lugar" to txtNombreLugar.text.toString(),
                    "Tipo" to txtTipo.text.toString(),
                    "Categoria" to txtCategoria.text.toString(),
                    "Subtipo" to txtSubtipo.text.toString(),
                    "Provincia" to txtProvincia.text.toString(),
                    "Canton" to txtCanton.text.toString(),
                    "Parroquia" to txtParroquia.text.toString(),
                    "Calle" to txtCalleP.text.toString(),
                    "Numero" to txtNumero.text.toString(),
                    "Transversal" to txtTrans.text.toString(),
                    "Barrio" to txtBarrio.text.toString(),
                    "Longitud" to txtLong.text.toString(),
                    "Altura" to txtAltura.text.toString(),
                    "Tipo de Adminstrador" to txtTipoAdmin.text.toString(),
                    "Nombre Administrador" to txtNombreAdmin.text.toString(),
                    "Telefono" to txtTelefono.text.toString()
                )
            )

            val inicio: Intent = Intent(this,addRecurso01::class.java).apply {
                putExtra("email", email)
                //putExtra("listas",listaDatos)
            }
            startActivity(inicio)

        }

    }


}