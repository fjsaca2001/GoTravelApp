package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_recurso04.*
import kotlinx.android.synthetic.main.activity_add_recurso04.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso04.btnPerfil
import kotlinx.android.synthetic.main.activity_add_recurso04.btnSave


class addRecurso04 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso04)
        val bundle: Bundle? =intent.extras
        val respuestas01: Array<String>? = bundle?.getStringArray("respuestas01")
        val respuestas02: Array<String>? = bundle?.getStringArray("respuestas02")
        val respuestas03: Array<String>? = bundle?.getStringArray("respuestas03")
        val respuestas04: Array<String>? = bundle?.getStringArray("respuestas04")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01 ?: arrayOf("No data"),
            respuestas02 ?: arrayOf("No data"),
            respuestas03?: arrayOf("No data"),
            respuestas04?: arrayOf("No data")
        )
        botonera(email ?: "")
    }
    private fun view(email:String,respuestas01:Array<String>,respuestas02:Array<String>, respuestas03: Array<String>, respuestas04: Array<String>){
        val listaAtractivo = listOf("Atractivo","Conservado", "Alterado","En proceso de Deterioro","Deteriorado")

        val listaAlteracionNaturales = listOf("Factores de alteración y deterioro (Naturales)"
            ,"Erosión", "Humedad", "Desastres Naturales","Flora/Fauna","Clima","Otro")

        val listaAlteracionAntropica = listOf("Factores de alteración y deterioro (Antrópicos)"
            ,"Actividades Agrícolas y ganaderas", "Actividades Forestales", "Actividades Extrativas/Mineria"
            ,"Actividades Industriales","Negligencia/Abandono","Huaquería","Conflicto de Tendencia"
            ,"Condiciones de uso y exposición","Falta de mantenimiento","Contaminación del Ambiente"
            ,"Generación de Residuos","Expansión Urbana","Conflicto Político/Social","Desarrollo Insdustrial/Comercial"
            ,"Vandalismo","Otro")

        val listaEntorno = listOf("Entorno","Conservado", "Alterado","En proceso de deterioro"
            ,"Deteriorado")

        val listaAlteracionNaturalesEntorno = listOf("Factores de alteración y deterioro (Naturales)"
            ,"Erosión", "Humedad", "Desastres Naturales","Flora/Fauna","Clima","Otro")

        val listaAlteracionAntropicaEntorno = listOf("Factores de alteración y deterioro (Antrópicos)"
            ,"Actividades Agrícolas y ganaderas", "Actividades Forestales", "Actividades Extrativas/Mineria"
            ,"Actividades Industriales","Negligencia/Abandono","Huaquería","Conflicto de Tendencia"
            ,"Condiciones de uso y exposición","Falta de mantenimiento","Contaminación del Ambiente"
            ,"Generación de Residuos","Expansión Urbana","Conflicto Político/Social","Desarrollo Insdustrial/Comercial"
            ,"Vandalismo","Otro")

        val listaDeclaratoria = listOf("Declaratoria del espacio turístico asociado al atractivo"
            ,"Declarante","Denominación","Fecha de Declaración","Alcance")


        //val spLinea = findViewById<Spinner>(R.id.spLinea)

        val adaplistaAtractivo = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAtractivo)
        val adapAlteracionesNaturales= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAlteracionNaturales)
        val adapAlteracionesAntropicas= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAlteracionAntropica)
        val adapEntorno= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaEntorno)
        val adapAlteracionesNaturalesEntorno= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAlteracionNaturalesEntorno)
        val adapAlteracionesAntropicasEntorno = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaAlteracionAntropicaEntorno)
        val adapDeclaratoria = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaDeclaratoria)

        var atractivo = ""
        var alteracionNatural = ""
        var alteracionAntropica = ""
        var entorno = ""
        var alteracionNaturalEntorno = ""
        var alteracionAntropicaEntorno = ""
        var declaratoria = ""

        spAtractivo.adapter = adaplistaAtractivo
        spFactoresAlteracionNaturales.adapter = adapAlteracionesNaturales
        spFactoresAlteracionAntropicos.adapter = adapAlteracionesAntropicas
        spEntorno.adapter = adapEntorno
        spFactoresAlteracionNaturalesEntorno.adapter = adapAlteracionesNaturalesEntorno
        spFactoresAlteracionAntropicosEntorno.adapter= adapAlteracionesAntropicasEntorno
        spDeclaratoria.adapter=adapDeclaratoria

        spAtractivo.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                atractivo = listaAtractivo[position]
                println(listaAtractivo[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spFactoresAlteracionAntropicos.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                alteracionAntropica = listaAlteracionAntropica[position]
                println(listaAlteracionAntropica[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spEntorno.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                entorno = listaEntorno[position]
                println(listaEntorno[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spFactoresAlteracionNaturales.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                alteracionNatural = listaAlteracionNaturales[position]
                println(listaAlteracionNaturales[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spFactoresAlteracionNaturalesEntorno.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                alteracionNaturalEntorno = listaAlteracionNaturalesEntorno[position]
                println(listaAlteracionNaturalesEntorno[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spFactoresAlteracionAntropicosEntorno.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                alteracionAntropicaEntorno = listaAlteracionAntropicaEntorno[position]
                println(listaAlteracionAntropicaEntorno[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spDeclaratoria.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                declaratoria = listaDeclaratoria[position]
                println(listaDeclaratoria[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener(){
            val listaDatos = arrayOf(
                atractivo,
                txtObservacionesAtractivos.text.toString(),
                alteracionNatural,
                alteracionAntropica,
                txtObservacionesAlteracion.text.toString(),
                entorno,
                txtObservacionesEntorno.text.toString(),
                alteracionNaturalEntorno,
                alteracionAntropicaEntorno,
                txtObservacionesAlteracion.text.toString(),
                declaratoria,
                txtObservacionesDeclaratoria.text.toString(),
            )

            val inicio: Intent = Intent(this,addRecurso05::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas01", respuestas01)
                putExtra("respuestas02", respuestas02)
                putExtra("respuestas03", respuestas03)
                putExtra("respuestas04", respuestas04)
                putExtra("respuestas05", listaDatos)

            }
            startActivity(inicio)
        }
    }

    private fun botonera(email:String){
        btnHome.setOnClickListener(){
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