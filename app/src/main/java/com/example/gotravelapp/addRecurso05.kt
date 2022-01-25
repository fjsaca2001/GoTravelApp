package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_recurso05.*
import kotlinx.android.synthetic.main.activity_add_recurso05.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso05.btnPerfil
import kotlinx.android.synthetic.main.activity_add_recurso05.btnSave

class addRecurso05 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso05)
        val bundle: Bundle? =intent.extras
        val respuestas01: Array<String>? = bundle?.getStringArray("respuestas01")
        val respuestas02: Array<String>? = bundle?.getStringArray("respuestas02")
        val respuestas03: Array<String>? = bundle?.getStringArray("respuestas03")
        val respuestas04: Array<String>? = bundle?.getStringArray("respuestas04")
        val respuestas05: Array<String>? = bundle?.getStringArray("respuestas05")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01 ?: arrayOf("No data"),
            respuestas02 ?: arrayOf("No data"),
            respuestas03?: arrayOf("No data"),
            respuestas04?: arrayOf("No data"),
            respuestas05?: arrayOf("No data")
        )
        botonera(email ?: "")
    }
    private fun view(email:String,respuestas01:Array<String>,respuestas02:Array<String>, respuestas03: Array<String>, respuestas04: Array<String>, respuestas05: Array<String>){
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
            val listaDatos = arrayOf(
                serviciosBasicos,
                servicios,
                txtEspecifiqueServicios.text.toString(),
                txtObservacionesServicios.text.toString(),
                ambiente,
                tipoAmbiente,
                material,
                txtAmbienteEstado.text.toString(),
                txtObservacionesAmbiente.text.toString(),
                centroSalud,
                tipoCentroSalud,
                txtCentroSaludCantidad.text.toString(),
                txtObservacionesCentroSalud.text.toString(),
                seguridad,
                txtSeguridadDetalle.text.toString(),
                txtObservacionesSeguridad.text.toString(),
                comunicacion,
                telefonia,
                internet,
                txtObservacionesComunicacion.text.toString(),
                radio,
                txtObservacionesRadioPortatil.text.toString(),
                amenaza,
                txtPlanAmenaza.text.toString(),
                txtInstitucionDocumento.text.toString(),
                txtNombreDocumento.text.toString(),
                txtElaboracionDocumento.text.toString(),
                txtObservacionesAmenazas.text.toString()
            )

            val inicio: Intent = Intent(this,addRecurso06::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas01", respuestas01)
                putExtra("respuestas02", respuestas02)
                putExtra("respuestas03", respuestas03)
                putExtra("respuestas04", respuestas04)
                putExtra("respuestas05", respuestas05)
                putExtra("respuestas06", listaDatos)
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