package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso08.*
import kotlinx.android.synthetic.main.activity_add_recurso08.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso08.btnPerfil
import kotlinx.android.synthetic.main.activity_add_recurso08.btnSave

class addRecurso08 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso08)
        val bundle: Bundle? =intent.extras
        val respuestas01: Array<String>? = bundle?.getStringArray("respuestas01")
        val respuestas02: Array<String>? = bundle?.getStringArray("respuestas02")
        val respuestas03: Array<String>? = bundle?.getStringArray("respuestas03")
        val respuestas04: Array<String>? = bundle?.getStringArray("respuestas04")
        val respuestas05: Array<String>? = bundle?.getStringArray("respuestas05")
        val respuestas06: Array<String>? = bundle?.getStringArray("respuestas06")
        val respuestas07: Array<String>? = bundle?.getStringArray("respuestas07")
        val respuestas08: Array<String>? = bundle?.getStringArray("respuestas08")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01 ?: arrayOf("No data"),
            respuestas02 ?: arrayOf("No data"),
            respuestas03?: arrayOf("No data"),
            respuestas04?: arrayOf("No data"),
            respuestas05?: arrayOf("No data"),
            respuestas06?: arrayOf("No data"),
            respuestas07?: arrayOf("No data"),
            respuestas08?: arrayOf("No data")
        )
        botonera(email ?: "")
    }
    private fun view(email:String,respuestas01:Array<String>,respuestas02:Array<String>, respuestas03: Array<String>, respuestas04: Array<String>, respuestas05: Array<String>, respuestas06: Array<String>, respuestas07: Array<String>, respuestas08: Array<String>){


        val conteo = respuestas01?.count{it.isNotEmpty()}.toInt() + respuestas02?.count{it.isNotEmpty()}.toInt()
        +respuestas03?.count{it.isNotEmpty()}.toInt() + respuestas04?.count{it.isNotEmpty()}.toInt()
        + respuestas05?.count{it.isNotEmpty()}.toInt() + respuestas06?.count{it.isNotEmpty()}.toInt()
        +respuestas07?.count{it.isNotEmpty()}.toInt() + respuestas08?.count{it.isNotEmpty()}.toInt()

        var porcentaje =  (conteo*100)/172



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
            val inicio: Intent = Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)


            val rnds = (0..999).random()


            db.collection("atractivos").document(email).set(
                hashMapOf(
                    // Recurso 1
                    "email" to email,
                    "NombredelLugar" to respuestas01.get(0),
                    "Tipo Atractivo" to respuestas01.get(1),
                    "Categoria Atractivo" to respuestas01.get(2),
                    "Subtipo Atractivo" to respuestas01.get(3),
                    "Provincia" to respuestas01.get(4),
                    "Canton" to respuestas01.get(5),
                    "Parroquia" to respuestas01.get(6),
                    "Calle" to respuestas01.get(7),
                    "Numero" to respuestas01.get(8),
                    "Transversal" to respuestas01.get(9),
                    "Barrio" to respuestas01.get(10),
                    "Longitud" to respuestas01.get(11),
                    "Altura" to respuestas01.get(12),
                    "Tipo de Adminstrador" to respuestas01.get(13),
                    "Nombre Administrador" to respuestas01.get(14),
                    "Telefono" to respuestas01.get(15),
                    // Recurso 2
                    "Clima" to respuestas02.get(0),
                    "Temperatura" to respuestas02.get(1),
                    "Precipitacion pluvimetrica" to respuestas02.get(2),
                    "Linea de producto" to respuestas02.get(3),
                    "Escenario donde se localiza" to respuestas02.get(4),
                    "Tipo de ingreso" to respuestas02.get(5),
                    "Hora de Ingreso" to respuestas02.get(6),
                    "Hora de Salida" to respuestas02.get(7),
                    "Atencion" to respuestas02.get(8),
                    "Formas de pago" to respuestas02.get(9),
                    "Meses recomendados" to respuestas02.get(10),
                    "Observaciones" to respuestas02.get(11),
                    // Recurso 3
                    "Ciudad o Poblado más Cercano" to respuestas03.get(0),
                    "Distancia desde la ciudad o poblado más cercano" to respuestas03.get(1),
                    "Tiempo Estimado de dezsplazamiento en auto" to respuestas03.get(2),
                    "Coordenadas (Latitud/Longitud)" to respuestas03.get(3),
                    "Observaciones" to respuestas03.get(4),
                    "Tipo de Via" to respuestas03.get(5),
                    "Coordenadas de Inicio" to respuestas03.get(6),
                    "Coordenadas de Fin" to respuestas03.get(7),
                    "Distancia (Km)" to respuestas03.get(8),
                    "Material" to respuestas03.get(9),
                    "Estado" to respuestas03.get(10),
                    "Observaciones" to respuestas03.get(11),
                    "Tipo" to respuestas03.get(12),
                    "Puerto/Muelle de Salida" to respuestas03.get(13),
                    "Puerto/Muelle de LLegada" to respuestas03.get(14),
                    "Observaciones" to respuestas03.get(15),
                    "Tipo" to respuestas03.get(16),
                    "Observaciones" to respuestas03.get(17),
                    "Transporte" to respuestas03.get(18),
                    "Observaciones" to respuestas03.get(19),
                    "Cooperativa o Asociación que presta el servicio" to respuestas03.get(20),
                    "Estación / Terminal" to respuestas03.get(21),
                    "Frecuencia" to respuestas03.get(22),
                    "Traslado origen / Destino" to respuestas03.get(23),
                    "Accesibilidad para personas con discapacidad" to respuestas03.get(24),
                    "Observaciones" to respuestas03.get(25),
                    "Estado de Señalización" to respuestas03.get(26),
                    "Observaciones" to respuestas03.get(27),
                    // Recurso 4
                    "Planta Turística" to respuestas04.get(0),
                    "Alojamiento" to respuestas04.get(1),
                    "Establecimientos Registrados" to respuestas04.get(2),
                    "Número de Habitaciones" to respuestas04.get(3),
                    "Número de Plazas" to respuestas04.get(4),
                    "Observaciones" to respuestas04.get(5),
                    "Alimentos y Bebidas" to respuestas04.get(6),
                    "Establecimientos Registrados" to respuestas04.get(7),
                    "Número de Mesas" to respuestas04.get(8),
                    "Número de Plazas" to respuestas04.get(9),
                    "Observaciones" to respuestas04.get(10),
                    "Guía" to respuestas04.get(11),
                    "Observaciones" to respuestas04.get(12),
                    "Categoria" to respuestas04.get(13),
                    "Tipo" to respuestas04.get(14),
                    "Cantidad" to respuestas04.get(15),
                    "Coordenadas" to respuestas04.get(16),
                    "Acceso Universal" to respuestas04.get(17),
                    "Estado " to respuestas04.get(18),
                    "Observaciones" to respuestas04.get(19),
                    "Complementarios de la actividad turística" to respuestas04.get(20),
                    "Observaciones" to respuestas04.get(21),
                    // Recurso 5
                    "Atractivo" to respuestas05.get(0),
                    "Observaciones" to respuestas05.get(1),
                    "Factores de alteración y deterioro (Naturales)" to respuestas05.get(2),
                    "Factores de alteración y deterioro (Antrópicos)" to respuestas05.get(3),
                    "Observaciones" to respuestas05.get(4),
                    "Entorno" to respuestas05.get(5),
                    "Observaciones" to respuestas05.get(6),
                    "Factores de alteración y deterioro (Naturales)" to respuestas05.get(7),
                    "Factores de alteración y deterioro (Antrópicos)" to respuestas05.get(8),
                    "Observaciones" to respuestas05.get(9),
                    "Declaratoria" to respuestas05.get(10),
                    "Declaratoria del espacio turístico asociado al atractivo" to respuestas05.get(11),
                    // Recurso 6
                    "Servicios Básicos" to respuestas06.get(0),
                    "Servicios" to respuestas06.get(1),
                    "Especifique" to respuestas06.get(2),
                    "Observaciones" to respuestas06.get(3),
                    "Ambiente" to respuestas06.get(4),
                    "Tipo Ambiente" to respuestas06.get(5),
                    "Material" to respuestas06.get(6),
                    "Estado" to respuestas06.get(7),
                    "Observaciones" to respuestas06.get(8),
                    "Centro de Salud" to respuestas06.get(9),
                    "Tipo" to respuestas06.get(10),
                    "Cantidad" to respuestas06.get(11),
                    "Observaciones" to respuestas06.get(12),
                    "Seguridad" to respuestas06.get(13),
                    "Detalle" to respuestas06.get(14),
                    "Observaciones" to respuestas06.get(15),
                    "Seguridad" to respuestas06.get(16),
                    "Seguridad" to respuestas06.get(17),
                    "Seguridad" to respuestas06.get(18),
                    "Observaciones" to respuestas06.get(19),
                    "Seguridad" to respuestas06.get(20),
                    "Observaciones" to respuestas06.get(21),
                    "Seguridad" to respuestas06.get(22),
                    "¿Existe un plan de contingencia en caso de catástrofes?" to respuestas06.get(23),
                    "Institución que elaboró el documento" to respuestas06.get(24),
                    "Nombre del documento:" to respuestas06.get(25),
                    "Año de elaboración:" to respuestas06.get(26),
                    "Observaciones" to respuestas06.get(27),
                    // Recurso 7
                    "¿El GAD cuenta con el Plan de Desarrollo Turístico Territorial?" to respuestas07.get(0),
                    "Año de Elaboración" to respuestas07.get(1),
                    "¿El atractivo se encuentra dentro de la planificación turística territorial (GAD´S)?" to respuestas07.get(2),
                    "Especifique" to respuestas07.get(3),
                    "¿Existen normativas que se apliquen para el desarrollo de la actividad turística en el atractivo?" to respuestas07.get(4),
                    "Especifique" to respuestas07.get(5),
                    "¿Existen ordenanzas que se apliquen para el desarrollo de la actividad turística en el atractivo?" to respuestas07.get(6),
                    "Especifique" to respuestas07.get(7),
                    "Observaciones" to respuestas07.get(8),
                    "En el Agua" to respuestas07.get(9),
                    "Observaciones" to respuestas07.get(10),
                    "En el Aire" to respuestas07.get(11),
                    "Observaciones" to respuestas07.get(12),
                    "En Superficie Terrestre" to respuestas07.get(13),
                    "Observaciones" to respuestas07.get(14),
                    "Tangibles e intangibles" to respuestas07.get(15),
                    "Observaciones" to respuestas07.get(16),
                    // Recurso 8
                    "¿Existe un plan de promoción turística cantonal?" to respuestas08.get(0),
                    "Especifique" to respuestas08.get(1),
                    "¿El Atractivo se encuentra incluido en el plan de promoción turístico cantonal?" to respuestas08.get(2),
                    "Medio Promocional" to respuestas08.get(3),
                    "Dirreción y nombre de los medios promocionales" to respuestas08.get(4),
                    "Periodicidad de la promoción" to respuestas08.get(5),
                    "El atractivo forma parte de una oferta establecida (paquete turístico)" to respuestas08.get(6),
                    "Especifique" to respuestas08.get(7),
                    "Observaciones" to respuestas08.get(8),
                    "¿Posee un sistema de registro de visitantes?" to respuestas08.get(9),
                    "Años de Registro" to respuestas08.get(10),
                    "¿Se genera reporte de estadísticas de visita al atractivo?" to respuestas08.get(11),
                    "Frecuencia" to respuestas08.get(12),
                    "Temporalidad de visita al atractivo" to respuestas08.get(13),
                    "Especifique" to respuestas08.get(14),
                    "Número de Visitantes" to respuestas08.get(15),
                    "Observaciones" to respuestas08.get(16),
                    "Turista" to respuestas08.get(17),
                    "Ciudad / País de Origen" to respuestas08.get(18),
                    "Llegadas mensuales" to respuestas08.get(19),
                    "Total Anual" to respuestas08.get(20),
                    "Observaciones" to respuestas08.get(21),
                    "Nombre del Informante Clave" to respuestas08.get(22),
                    "Contacto" to respuestas08.get(23),
                    "Demanda según  días de visita" to respuestas08.get(24),
                    "Demanda según frecuencia de visita" to respuestas08.get(25),
                    "Observaciones" to respuestas08.get(26),
                    // Recurso 9
                    "Número de personas a cargo de la administración" to txtAdiminstracionAtractivo.text.toString(),
                    "Número de personas especializadas en turismo" to txtNumeroPersonasTurismo.text.toString(),
                    "Número de personas con nivel de instrucción" to txtPersonasIntruccio.text.toString(),
                    "Instrucción" to instruccion,
                    "Número de personas capacitadas por temática" to txtPersonasTematica.text.toString(),
                    "Temática" to tematica,
                    "Número de personas que manejan algún de Idiomas" to txtPersonasIdioma.text.toString(),
                    "Idioma" to idioma,
                    "Observaciones" to txtObservacionesRecuroHumano.text.toString(),
                    "Descripcion del Atractico" to txtDescripcionAtractivo.text.toString(),
                    "Total" to conteo.toString(),
                    "Porcentaje" to porcentaje.toString(),
                    )
            )
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