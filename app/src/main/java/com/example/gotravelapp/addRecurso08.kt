package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso08.*
import kotlinx.android.synthetic.main.activity_add_recurso08.btnSave

class addRecurso08 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso08)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }

    private fun view(email:String,respuestas:Array<String>) {

        val listaInstruccion = listOf("Instrucción","Primaria","Secundaria","Tercer Nivel",
            "Cuarto Nivel","Otro")

        val listaTematica = listOf("Temática","Primeros Auxilios","Hospitalidad","Atención al Cliente","Guianza",
            "Sensibilización de discapacidades","Otro")

        val listaIdioma = listOf("Idioma","Inglés","Alemán","Frances",
            "Italiano","Italiano","Otro")

        val adapInstruccion = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaInstruccion)

        val adapTematica = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTematica)

        val adapIdioma = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaIdioma)

        var instruccion = ""

        var tematica = ""

        var idioma = ""

        spInstruccion.adapter = adapInstruccion
        spTematica.adapter = adapTematica
        spIdioma.adapter = adapIdioma

        spInstruccion.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                instruccion = listaInstruccion[position]
                println(listaInstruccion[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTematica.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tematica = listaTematica[position]
                println(listaTematica[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spIdioma.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                idioma = listaIdioma[position]
                println(listaIdioma[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener(){
            for (item: String in respuestas) {
                println(item)
            }
            val inicio: Intent = Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)

/*
            db.collection("atractivos").document(email).set(
                hashMapOf("Número de personas a cargo de la administración" to txtAdiminstracionAtractivo.text.toString(),
                    "Número de personas especializadas en turismo" to txtNumeroPersonasTurismo.text.toString(),
                    "Número de personas con nivel de instrucción" to txtPersonasIntruccio.text.toString(),
                    "Instrucción" to instruccion,
                    "Número de personas capacitadas por temática" to txtPersonasTematica.text.toString(),
                    "Temática" to tematica,
                    "Número de personas que manejan algún de Idiomas" to txtPersonasIdioma.text.toString(),
                    "Idioma" to idioma,
                    "Observaciones" to txtObservacionesRecuroHumano.text.toString(),
                    "Descripcion del Atractico" to txtDescripcionAtractivo.text.toString(),

                    )
            )
*/

        }

    }
}