package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso03.*
import kotlinx.android.synthetic.main.activity_add_recurso03.btnSave
import kotlinx.android.synthetic.main.activity_add_recurso03.spTipoFacilidad
import kotlinx.android.synthetic.main.activity_add_recurso03.spPlantaTuristica
import kotlinx.android.synthetic.main.activity_add_recurso03.spAlimentosyBebidas
import kotlinx.android.synthetic.main.activity_add_recurso03.spCategoria
import kotlinx.android.synthetic.main.activity_add_recurso03.spComplementarios
import kotlinx.android.synthetic.main.activity_add_recurso03.spGuia
import kotlinx.android.synthetic.main.activity_add_recurso03.spAlojamiento

class addRecurso03 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso03)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }
    private fun view(email:String,respuestas:Array<String>){
        val listaPlantaTuristica = listOf("Planta Turística ","En el Atractivo", "En la ciudad o poblado cercano")
        val listaAlojamiento = listOf("Alojamiento","Hotel", "Hostal", "Hostería","Hacienda Turística","Lodge","Resort"
            ,"Refugio","Campamento Turístico","Casa de Huespedes")
        val listaAlimentos = listOf("Alimentos y Bebidas","Restaurantes", "Cafeterías", "Bares","Fuentes de Soda")
        val listaGuia = listOf("Guía","Local", "Nacional","Nacional Especializado","Cultura","Aventura")
        val listaCategoria = listOf("Categoria","De Apoyo a la gestión turística", "De observación y vigilancia",
            "De Recorrido y Descanso", "De Servicio","Otros")
        val listaTipoFacilidad = listOf("Tipo (M)","Punto de Información","I-Tur"
            ,"Centro de interpretación","Centro de facilidad turística","Centro de recepción de visitantes")
        val listaComplementarios = listOf("Complementarios de la actividad turística"
            ,"Alquiler y venta de equipos especializados","Venta de artesanías y merchandaising","Casa de cambio"
            ,"Cajero automático","Otro")


        //val spLinea = findViewById<Spinner>(R.id.spLinea)

        val adaplistaPlantaTuristica = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPlantaTuristica)
        val adapAlojamiento= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAlojamiento)
        val adapAlimentos= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAlimentos)
        val adapGuia= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaGuia)
        val adapCategoria= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCategoria)
        val adapTipoFacilidad = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaTipoFacilidad)
        val adapComplementario = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaComplementarios)

        var planta = ""
        var alojamiento = ""
        var alimentos = ""
        var guia = ""
        var categoria = ""
        var tipoFacilidad = ""
        var complementarios = ""

        spPlantaTuristica.adapter = adaplistaPlantaTuristica
        spAlojamiento.adapter = adapAlojamiento
        spAlimentosyBebidas.adapter = adapAlimentos
        spGuia.adapter = adapGuia
        spCategoria.adapter = adapCategoria
        spTipoFacilidad.adapter= adapTipoFacilidad
        spComplementarios.adapter=adapComplementario

        spPlantaTuristica.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                planta = listaPlantaTuristica[position]
                println(listaPlantaTuristica[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAlimentosyBebidas.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                alimentos = listaAlimentos[position]
                println(listaAlimentos[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spGuia.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                guia = listaGuia[position]
                println(listaGuia[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAlojamiento.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                alojamiento = listaAlojamiento[position]
                println(listaAlojamiento[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spCategoria.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                categoria = listaCategoria[position]
                println(listaCategoria[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTipoFacilidad.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tipoFacilidad = listaTipoFacilidad[position]
                println(listaTipoFacilidad[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spComplementarios.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                complementarios = listaComplementarios[position]
                println(listaComplementarios[position])
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
                hashMapOf("Planta Turística" to planta,
                    "Alojamiento" to alojamiento,
                    "Establecimientos Registrados" to txtEstlacimientosRegistrados.text.toString(),
                    "Número de Habitaciones" to txtNumeroHabitaciones.text.toString(),
                    "Número de Plazas" to txtNumeroPlazas.text.toString(),
                    "Observaciones" to txtObservacionesEstablecimientos.text.toString(),
                    "Alimentos y Bebidas" to alimentos,
                    "Establecimientos Registrados" to txtEstablecimientoAlimentos.text.toString(),
                    "Número de Mesas" to txtNumeroMesasAlimentos.text.toString(),
                    "Número de Plazas" to txtNumeroPlazas.text.toString(),
                    "Observaciones" to txtObservacionesAlimentos.text.toString(),
                    "Guía" to guia,
                    "Observaciones" to txtObservacionesGuia.text.toString(),
                    "Categoria" to categoria,
                    "Tipo" to tipoFacilidad,
                    "Cantidad" to txtFacilidadCantidad.text.toString(),
                    "Coordenadas" to txtFacilidadCoordenadas.text.toString(),
                    "Acceso Universal" to txtFacilidadUniversal.text.toString(),
                    "Estado " to txtFacilidadEstado.text.toString(),
                    "Observaciones" to txtFacilidadObservaciones.text.toString(),
                    "Complementarios de la actividad turística" to complementarios,
                    "Observaciones" to txtComplementariosObservaciones.text.toString(),

                    )
            )


        }
    }
}