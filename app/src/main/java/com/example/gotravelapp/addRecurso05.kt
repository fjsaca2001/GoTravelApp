package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso04.*
import kotlinx.android.synthetic.main.activity_add_recurso05.*
import kotlinx.android.synthetic.main.activity_add_recurso05.btnSave

class addRecurso05 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso05)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }
    private fun view(email:String,respuestas:Array<String>){
        val listaServiciosBasicos = listOf("Servicios Básicos ","En el Atractivo", "En la ciudad o poblado cercano")

        val listaServicios = listOf("Servicios","Agua", "Energia Electrica", "Saneamiento","Disposición de desechos")

        val listaAmbiente = listOf("Señalización Atractivo (Ambiente)", "En áreas urbanas", "En áreas naturales","Letreros Informativos","Señalética interna de seguridad")

        val listaTipoAmbiente = listOf("Tipo","Pictograma de atractivos naturales", "Pictograma de atractivos culturales"
            ,"Pictograma de actividades turísticas","Pictograma de servicios de apoyo","Pictogramas de restricción"
            ,"Tótems de atractivos turísticos","Tótems de sitio","Tótems direccionales")

        val listaMaterial = listOf("Materialidad","Madera", "Aluminio","Otros")

        val listaCentroSalud = listOf("Centro de Salud (más cercano) ","En el Atractivo", "En la ciudad o poblado cercano")

        val listaTipoCentroSalud = listOf("Tipo","Hospital Clinica", "Puesto / Centro de Salud"
            ,"Dispensario médico","Botiquín de primero auxilios","Otros")

        val listaSeguridad = listOf("Seguridad","Privada","Policía nacional","Policía metropolitana / Municipal"
            ,"Otra")

        val listaComunicaion = listOf("Servicio de comunicación de uso público","En el Atractivo", "En la ciudad o poblado cercano")

        val listaTelefonia = listOf("Telefonía","Fija", "Móvil","Satelital")

        val listaInternet = listOf("Conexión a internet ","Línea Telefónica", "Fibra óptica","Satélite"
            ,"Redes inalámbricas","Telefonía móvil")

        val listaRadioPortatil = listOf("Radio portátil (U)"
            ,"De uso exclusivo para el visitante","De uso exclusivo para comunicación interna"
            ,"De uso exclusivo en caso de emergencia")

        val listaAmenaza = listOf("Multiamenzazas","Deslaves", "Sismos","Erupciones volcánicas"
            ,"Incendios forestales","Sequía","Inundaciones","Aguajes","Tsunami")


        //val spLinea = findViewById<Spinner>(R.id.spLinea)

        val adapServiciosBasicos = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaServiciosBasicos)
        val adapServicios= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaServicios)
        val adapAmbiente= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAmbiente)
        val adapMaterial= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaMaterial)
        val adapTipoAmbiente= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTipoAmbiente)
        val adapCentroSalud = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCentroSalud)
        val adapTipoCentroSalud = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTipoCentroSalud)
        val adapComunicacion = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaComunicaion)
        val adapTelefonia = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTelefonia)
        val adapInternet = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaInternet)
        val adapSeguridad = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaSeguridad)
        val adapRadioPortatil = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaRadioPortatil)
        val adapAmenazas = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaAmenaza)

        var serviciosBasicos = ""
        var servicios = ""
        var ambiente = ""
        var tipoAmbiente = ""
        var centroSalud = ""
        var tipoCentroSalud = ""
        var comunicacion = ""
        var telefonia = ""
        var internet = ""
        var material = ""
        var seguridad = ""
        var radio = ""
        var amenaza = ""

        spServiciosBasicos.adapter = adapServiciosBasicos
        spServicios.adapter = adapServicios
        spAmbiente.adapter = adapAmbiente
        spTipoAmbiente.adapter = adapTipoAmbiente
        spMaterial.adapter = adapMaterial
        spCentroSalud.adapter = adapCentroSalud
        spTipoCentroSalud.adapter = adapTipoCentroSalud
        spComunicacionPublico.adapter = adapComunicacion
        spTelefonia.adapter = adapTelefonia
        spInternet.adapter = adapInternet
        spSeguridad.adapter= adapSeguridad
        spRadioPortatil.adapter=adapRadioPortatil
        spMultiAmenazas.adapter=adapAmenazas

        spServiciosBasicos.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                serviciosBasicos = listaServiciosBasicos[position]
                println(listaServiciosBasicos[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAmbiente.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                ambiente = listaAmbiente[position]
                println(listaAmbiente[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTipoAmbiente.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tipoAmbiente = listaTipoAmbiente[position]
                println(listaTipoAmbiente[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spServicios.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                servicios = listaServicios[position]
                println(listaServicios[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spMaterial.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                material = listaMaterial[position]
                println(listaMaterial[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spCentroSalud.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                centroSalud = listaCentroSalud[position]
                println(listaCentroSalud[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTipoCentroSalud.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tipoCentroSalud = listaTipoCentroSalud[position]
                println(listaTipoCentroSalud[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spSeguridad.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                seguridad = listaSeguridad[position]
                println(listaSeguridad[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spComunicacionPublico.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                comunicacion = listaComunicaion[position]
                println(listaComunicaion[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTelefonia.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                telefonia = listaTelefonia[position]
                println(listaTelefonia[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spInternet.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                internet = listaInternet[position]
                println(listaInternet[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spRadioPortatil.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                radio = listaRadioPortatil[position]
                println(listaRadioPortatil[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spMultiAmenazas.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                amenaza = listaAmenaza[position]
                println(listaAmenaza[position])
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
                hashMapOf("Servicios Básicos" to serviciosBasicos,
                    "Servicios" to servicios,
                    "Especifique" to txtEspecifiqueServicios.text.toString(),
                    "Observaciones" to txtObservacionesServicios.text.toString(),
                    "Ambiente" to ambiente,
                    "Tipo Ambiente" to tipoAmbiente,
                    "Material" to material,
                    "Estado" to txtAmbienteEstado.text.toString(),
                    "Observaciones" to txtObservacionesAmbiente.text.toString(),
                    "Centro de Salud" to centroSalud,
                    "Tipo" to tipoCentroSalud,
                    "Cantidad" to txtCentroSaludCantidad.text.toString(),
                    "Observaciones" to txtObservacionesCentroSalud.text.toString(),
                    "Seguridad" to seguridad,
                    "Detalle" to txtSeguridadDetalle.text.toString(),
                    "Observaciones" to txtObservacionesSeguridad.text.toString(),
                    "Seguridad" to comunicacion,
                    "Seguridad" to telefonia,
                    "Seguridad" to internet,
                    "Observaciones" to txtObservacionesComunicacion.text.toString(),
                    "Seguridad" to radio,
                    "Observaciones" to txtObservacionesRadioPortatil.text.toString(),
                    "Seguridad" to amenaza,
                    "¿Existe un plan de contingencia en caso de catástrofes?" to txtPlanAmenaza.text.toString(),
                    "Institución que elaboró el documento" to txtInstitucionDocumento.text.toString(),
                    "Nombre del documento:" to txtNombreDocumento.text.toString(),
                    "Año de elaboración:" to txtElaboracionDocumento.text.toString(),
                    "Observaciones" to txtObservacionesAmenazas.text.toString(),

                    )
            )
*/

        }
    }
}