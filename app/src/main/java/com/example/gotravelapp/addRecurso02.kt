package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_recurso02.*
import kotlinx.android.synthetic.main.activity_add_recurso02.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso02.btnHome
import kotlinx.android.synthetic.main.activity_add_recurso02.btnPerfil
import kotlinx.android.synthetic.main.activity_add_recurso02.btnSave

class addRecurso02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso02)
        val bundle: Bundle? =intent.extras
        val respuestas01: Array<String>? = bundle?.getStringArray("respuestas01")
        val respuestas02: Array<String>? = bundle?.getStringArray("respuestas02")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01 ?: arrayOf("No data"),
            respuestas02 ?: arrayOf("No data"),
        )
        botonera(email?:"")
    }
    private fun view(email:String,respuestas01:Array<String>,respuestas02:Array<String>){
        val listaLineaAccesoTierra = listOf("Tipo de Via ","Primer Orden", "Segundo Orden", "Tercer Orden")
        val listaAcuatico = listOf("Tipo","Maritimo", "Lacustre", "Rústico Fluvial")
        val listaTipo = listOf("Tipo","Nacional", "Internacional")
        val listaTransporte = listOf("Transporte","Bus", "Buseta", "4x4","Taxi","Moto Taxi","Teleferico"
            ,"Lancha","Bote","Barco","Canoa","Avíon","Avioneta","Helicoptero","Otro")
        val listaFrecuencia = listOf("Frecuencia","Diaria", "Semanal", "Mensual", "Eventual")
        val listaAccesibilidad = listOf("Accesibilidad para personas con discapacidad","General","Física"
            ,"Visual","Auditiva","Intelectual / Psicologica","No es Accesible")
        val listaseñalizacion = listOf("Estado de Señalización","Bueno","Malo","Regular")


        //val spLinea = findViewById<Spinner>(R.id.spLinea)

        val adapListaAcceso = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaLineaAccesoTierra)
        val adapAcuatico= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAcuatico)
        val adapTipo= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTipo)
        val adapTransporte= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTransporte)
        val adapFrecuencia= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaFrecuencia)
        val adapAccesibilidad = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaAccesibilidad)
        val adapSeñalizacion = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaseñalizacion)

        var acceso = ""
        var acuatico = ""
        var tipo = ""
        var transporte = ""
        var frecuencia = ""
        var accesibilidad = ""
        var señalizacion = ""

        spAcceso.adapter = adapListaAcceso
        spAcuatico.adapter = adapAcuatico
        spTipo.adapter = adapTipo
        spTransporte.adapter = adapTransporte
        spFrecuencia.adapter = adapFrecuencia
        spAccesibilidad.adapter= adapAccesibilidad
        spSeñalizaciones.adapter=adapSeñalizacion

        spAcceso.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                acceso = listaLineaAccesoTierra[position]

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAcuatico.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                acuatico = listaAcuatico[position]

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTipo.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tipo = listaTipo[position]

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTransporte.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                transporte = listaTransporte[position]

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spFrecuencia.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                frecuencia = listaFrecuencia[position]

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAccesibilidad.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                accesibilidad = listaAccesibilidad[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spSeñalizaciones.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                señalizacion = listaseñalizacion[position]

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener(){

            val listaDatos = arrayOf(
                txtPoblado.text.toString(),
                txtDistanciaPoblado.text.toString(),
                txtTiempoAuto.text.toString(),
                txtCoordenadas.text.toString(),
                txtObservacionPoblado.text.toString(),
                acceso,
                txtCoordenadasInicio.text.toString(),
                txtCoordenadasFinal.text.toString(),
                txtDistanciaAccesoTerrestre.text.toString(),
                txtAccesoTerrestreMaterial.text.toString(),
                txtAccesoTerrestreEstado.text.toString(),
                txtAccesoTerrestreObservaciones.text.toString(),
                acuatico,
                txtPuertoIncio.text.toString(),
                txtPuertoLlegada.text.toString(),
                txtAccesoAcuaticoObservaciones.text.toString(),
                tipo,
                txtAccesoAereoObservaciones.text.toString(),
                transporte,
                txtTransporteObservaciones.text.toString(),
                txtDetalleTransporte.text.toString(),
                txtEstacionTransporte.text.toString(),
                frecuencia,
                accesibilidad,
                txtDetallesTraslado.text.toString(),
                señalizacion,
                txtAccesibilidadObservaciones.text.toString(),
                txtSeñalizacionObservaciones.text.toString(),
            )


            val inicio: Intent = Intent(this,addRecurso03::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas01", respuestas01)
                putExtra("respuestas02", respuestas02)
                putExtra("respuestas03", listaDatos)

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