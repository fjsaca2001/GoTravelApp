package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_recurso.*

class addRecurso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso)

        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")
        vista(email?:"")
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