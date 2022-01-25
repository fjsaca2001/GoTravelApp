package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_recurso03.*
import kotlinx.android.synthetic.main.activity_add_recurso03.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso03.btnPerfil
import kotlinx.android.synthetic.main.activity_add_recurso03.btnSave
import kotlinx.android.synthetic.main.activity_add_recurso03.spTipoFacilidad
import kotlinx.android.synthetic.main.activity_add_recurso03.spPlantaTuristica
import kotlinx.android.synthetic.main.activity_add_recurso03.spAlimentosyBebidas
import kotlinx.android.synthetic.main.activity_add_recurso03.spCategoria
import kotlinx.android.synthetic.main.activity_add_recurso03.spComplementarios
import kotlinx.android.synthetic.main.activity_add_recurso03.spGuia
import kotlinx.android.synthetic.main.activity_add_recurso03.spAlojamiento

class addRecurso03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso03)
        val bundle: Bundle? =intent.extras
        val respuestas01: Array<String>? = bundle?.getStringArray("respuestas01")
        val respuestas02: Array<String>? = bundle?.getStringArray("respuestas02")
        val respuestas03: Array<String>? = bundle?.getStringArray("respuestas03")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01 ?: arrayOf("No data"),
            respuestas02 ?: arrayOf("No data"),
            respuestas03?: arrayOf("No data")
        )
        botonera(email ?: "")
    }
    private fun view(email:String,respuestas01:Array<String>,respuestas02:Array<String>, respuestas03: Array<String>){
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

            val listaDatos = arrayOf(
                planta,
                alojamiento,
                txtEstlacimientosRegistrados.text.toString(),
                txtNumeroHabitaciones.text.toString(),
                txtNumeroPlazas.text.toString(),
                txtObservacionesEstablecimientos.text.toString(),
                alimentos,
                txtEstablecimientoAlimentos.text.toString(),
                txtNumeroMesasAlimentos.text.toString(),
                txtNumeroPlazas.text.toString(),
                txtObservacionesAlimentos.text.toString(),
                guia,
                txtObservacionesGuia.text.toString(),
                categoria,
                tipoFacilidad,
                txtFacilidadCantidad.text.toString(),
                txtFacilidadCoordenadas.text.toString(),
                txtFacilidadUniversal.text.toString(),
                txtFacilidadEstado.text.toString(),
                txtFacilidadObservaciones.text.toString(),
                complementarios,
                txtComplementariosObservaciones.text.toString()
            )

            val inicio: Intent = Intent(this,addRecurso04::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas01", respuestas01)
                putExtra("respuestas02", respuestas02)
                putExtra("respuestas03", respuestas03)
                putExtra("respuestas04", listaDatos)

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