package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickIniciar()
        registrar()
        title = "Inicio de sesión"

    }

    private fun clickIniciar(){
        btnLogin.setOnClickListener{
            if (txtUser.text.isNotEmpty() && txtPass.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(txtUser.text.toString(),
                    txtPass.text.toString()).addOnCompleteListener(){
                    if(it.isSuccessful){
                        inicio(it.result?.user?.email?:"")
                    }else{
                        noUser()
                    }
                }
            }
        }
    }

    private fun registrar(){

        txtRegistrar.setOnClickListener(){
            if(txtUser.text.isNotEmpty() && txtPass.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(txtUser.text.toString(),
                        txtPass.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            inicio(it.result?.user?.email?:"")
                        }else{
                            error()
                        }
                    }
            }
        }
    }




    private fun inicio(email: String){
        val inicio: Intent= Intent(this,Menu::class.java).apply {
            putExtra("email", email)
        }
        startActivity(inicio)
    }

    private fun noUser(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("!Error¡ Verifique la contraseña o correo")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
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