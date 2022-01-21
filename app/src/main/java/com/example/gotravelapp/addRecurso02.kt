package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso02.*


class addRecurso02 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso02)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }
    private fun view(email:String,respuestas:Array<String>){
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
                println(listaLineaAccesoTierra[position])
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
                println(listaAcuatico[position])
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
                println(listaTipo[position])
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
                println(listaTransporte[position])
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
                println(listaFrecuencia[position])
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
                println(listaAccesibilidad[position])
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
                println(listaseñalizacion[position])
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
                hashMapOf("Ciudad o Poblado más Cercano" to txtPoblado.text.toString(),
                    "Distancia desde la ciudad o poblado más cercano" to txtDistanciaPoblado.text.toString(),
                    "Tiempo Estimado de dezsplazamiento en auto" to txtTiempoAuto.text.toString(),
                    "Coordenadas (Latitud/Longitud)" to txtCoordenadas.text.toString(),
                    "Observaciones" to txtObservacionPoblado.text.toString(),
                    "Tipo de Via" to acceso,
                    "Coordenadas de Inicio" to txtCoordenadasInicio.text.toString(),
                    "Coordenadas de Fin" to txtCoordenadasFinal.text.toString(),
                    "Distancia (Km)" to txtDistanciaAccesoTerrestre.text.toString(),
                    "Material" to txtAccesoTerrestreMaterial.text.toString(),
                    "Estado" to txtAccesoTerrestreEstado.text.toString(),
                    "Observaciones" to txtAccesoTerrestreObservaciones.text.toString(),
                    "Tipo" to acuatico,
                    "Puerto/Muelle de Salida" to txtPuertoIncio.text.toString(),
                    "Puerto/Muelle de LLegada" to txtPuertoLlegada.text.toString(),
                    "Observaciones" to txtAccesoAcuaticoObservaciones.text.toString(),
                    "Tipo" to tipo,
                    "Observaciones" to txtAccesoAereoObservaciones.text.toString(),
                    "Transporte" to transporte,
                    "Observaciones" to txtTransporteObservaciones.text.toString(),
                    "Cooperativa o Asociación que presta el servicio" to txtDetalleTransporte.text.toString(),
                    "Estación / Terminal" to txtEstacionTransporte.text.toString(),
                    "Frecuencia" to frecuencia,
                    "Traslado origen / Destino" to txtDetallesTraslado.text.toString(),
                    "Accesibilidad para personas con discapacidad" to accesibilidad,
                    "Observaciones" to txtAccesibilidadObservaciones.text.toString(),
                    "Estado de Señalización" to señalizacion,
                    "Observaciones" to txtSeñalizacionObservaciones.text.toString(),

                    )
            )
*/

        }
    }
}