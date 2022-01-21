package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso04.*


class addRecurso04 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso04)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }
    private fun view(email:String,respuestas:Array<String>){
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
            for (item: String in respuestas) {
                println(item)
            }
            val inicio: Intent = Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)


            db.collection("atractivos").document(email).set(
                hashMapOf("Atractivo" to atractivo,
                    "Observaciones" to txtObservacionesAtractivos.text.toString(),
                    "Factores de alteración y deterioro (Naturales)" to alteracionNatural,
                    "Factores de alteración y deterioro (Antrópicos)" to alteracionAntropica,
                    "Observaciones" to txtObservacionesAlteracion.text.toString(),
                    "Entorno" to entorno,
                    "Observaciones" to txtObservacionesEntorno.text.toString(),
                    "Factores de alteración y deterioro (Naturales)" to alteracionNaturalEntorno,
                    "Factores de alteración y deterioro (Antrópicos)" to alteracionAntropicaEntorno,
                    "Observaciones" to txtObservacionesAlteracion.text.toString(),
                    "Declaratoria" to declaratoria,
                    "Declaratoria del espacio turístico asociado al atractivo" to txtObservacionesDeclaratoria.text.toString(),

                    )
            )

        }
    }
}