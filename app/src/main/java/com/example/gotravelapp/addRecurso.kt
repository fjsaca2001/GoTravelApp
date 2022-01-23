package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso.*
import kotlinx.android.synthetic.main.activity_add_recurso.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso.btnPerfil

class addRecurso : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso)
        val bundle: Bundle? =intent.extras
        val isEdit: Boolean? = bundle?.getBoolean("isEdit")
        val email:String? = bundle?.getString("email")
        vista(email?:"")
        editar(email?:"", isEdit?:false)
        botonera(email ?: "")
    }

    private fun vista(email: String) {
        btnGuardar01.setOnClickListener(){

            val listaDatos = arrayOf(
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

            val inicio: Intent = Intent(this,addRecurso01::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas",listaDatos)
            }
            startActivity(inicio)

        }

    }

    private fun editar(email: String, isEdit: Boolean){
        if(isEdit){
            db.collection("atractivos").document(email).get().addOnSuccessListener {
                txtNombreLugar.setText(it.get("Nombre del Lugar") as String?)
                txtTipo.setText(it.get("Tipo") as String?)
                txtCategoria.setText(it.get("Categoria") as String?)
                txtSubtipo.setText(it.get("Subtipo") as String?)
                txtProvincia.setText(it.get("Provincia") as String?)
                txtCanton.setText(it.get("Canton") as String?)
                txtParroquia.setText(it.get("Parroquia") as String?)
                txtCalleP.setText(it.get("Calle") as String?)
                txtNumero.setText(it.get("Numero") as String?)
                txtTrans.setText(it.get("Transversal") as String?)
                txtBarrio.setText(it.get("Barrio") as String?)
                txtLong.setText(it.get("Longitud") as String?)
                txtAltura.setText(it.get("Altura") as String?)
                txtTipoAdmin.setText(it.get("Tipo de Adminstrador") as String?)
                txtNombreAdmin.setText(it.get("Nombre Administrador") as String?)
                txtTelefono.setText(it.get("Telefono") as String?)
            }
        }
    }


    private fun botonera(email:String){
        btnHome01.setOnClickListener(){
            val inicio: Intent= Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnPerfil.setOnClickListener(){
            val inicio: Intent= Intent(this,Perfil::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnExit.setOnClickListener{
            val saltar: Intent =Intent(this,MainActivity::class.java)
            startActivity(saltar)
        }
    }

}