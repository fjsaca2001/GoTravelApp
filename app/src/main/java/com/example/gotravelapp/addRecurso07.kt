package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso07.*


class addRecurso07 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso07)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }
    private fun view(email:String,respuestas:Array<String>){
        val listaPromocion = listOf("¿Existe un plan de promoción turística cantonal?",
            "Conservado", "Si","No")

        val listaIncluirPromocion = listOf("¿El Atractivo se encuentra incluido en el plan de promoción turístico cantonal?"
            ,"Si", "No")

        val listaMedioPromocional = listOf("Medio Promocional","Página WEB ", "Red Social ","Revistas Especializadas"
            ,"Material POP","Oficina de Información Turística","Medios de comunicación (radio, tv, prensa)"
            ,"Asistencia a ferias turísticas","Otro")

        val listaOferta = listOf("El atractivo forma parte de una oferta establecida (paquete turístico)",
            "Si", "No")

        val listaRegistroVisitantes = listOf("¿Posee un sistema de registro de visitantes?"
            ,"Si", "No", "Tipo : Digital","Papel")

        val listaEstadisticasVisitantes = listOf("¿Se genera reporte de estadísticas de visita al atractivo?"
            ,"Si", "No")


        val listaTemporabilidad = listOf("Temporalidad de visita al atractivo","Alta (meses)","Baja (meses)")

        val listaTurista = listOf("Turista","Nacional", "Extranjero")

        val listaDemandaDias = listOf("Demanda según  días de visita","Lunes a viernes", "Fines de semana","Días feriados")

        val listaDemandaFrecuencia = listOf("Demanda según frecuencia de visita","Permanente", "Estacional"
            ,"Esporádica","Inexistente")


        //val spLinea = findViewById<Spinner>(R.id.spLinea)

        val adapPromocion = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPromocion)
        val adapIncluirPromocion= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaIncluirPromocion)
        val adapMedioPromocional= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaMedioPromocional)
        val adapOferta= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaOferta)
        val adapRegistroVisitantes= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaRegistroVisitantes)
        val adapEstadisticasVisitantes = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaEstadisticasVisitantes)
        val adapTemporabilidad = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaTemporabilidad)
        val adapTurista = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaTurista)
        val adapDemandaDias = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaDemandaDias)
        val adapDemandaFrecuencia = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaDemandaFrecuencia)

        var promocion = ""
        var incluirPromocion = ""
        var medioPromocional = ""
        var oferta = ""
        var registroVisitantes = ""
        var estadisticasVisitantes = ""
        var enTemporabilidad = ""
        var turista = ""
        var demandaDias = ""
        var demandaFrecuencia = ""

        spPromocion.adapter = adapPromocion
        spIncluirPromocion.adapter = adapIncluirPromocion
        spMedioPromocional.adapter = adapMedioPromocional
        spOfertaAtractivo.adapter = adapOferta
        spRegistroVisitantes.adapter = adapRegistroVisitantes
        spEstadisticaVisitas.adapter= adapEstadisticasVisitantes
        spTemporabilidad.adapter=adapTemporabilidad
        spTurista.adapter=adapTurista
        spDemandaDias.adapter=adapDemandaDias
        spDemandaDias.adapter=adapDemandaFrecuencia

        spPromocion.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                promocion = listaPromocion[position]
                println(listaPromocion[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spMedioPromocional.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                medioPromocional = listaMedioPromocional[position]
                println(listaMedioPromocional[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spOfertaAtractivo.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                oferta = listaOferta[position]
                println(listaOferta[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spIncluirPromocion.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                incluirPromocion = listaIncluirPromocion[position]
                println(listaIncluirPromocion[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spRegistroVisitantes.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                registroVisitantes = listaRegistroVisitantes[position]
                println(listaRegistroVisitantes[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spEstadisticaVisitas.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                estadisticasVisitantes = listaEstadisticasVisitantes[position]
                println(listaEstadisticasVisitantes[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTemporabilidad.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                enTemporabilidad = listaTemporabilidad[position]
                println(listaTemporabilidad[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTurista.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                turista = listaTurista[position]
                println(listaTurista[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spDemandaDias.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                demandaDias = listaDemandaDias[position]
                println(listaDemandaDias[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spDemandaFrecuencia.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                demandaFrecuencia = listaDemandaFrecuencia[position]
                println(listaDemandaFrecuencia[position])
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
                hashMapOf("¿Existe un plan de promoción turística cantonal?" to promocion,
                    "Especifique" to txtEspecifiquePromocion.text.toString(),
                    "¿El Atractivo se encuentra incluido en el plan de promoción turístico cantonal?" to incluirPromocion,
                    "Medio Promocional" to medioPromocional,
                    "Dirreción y nombre de los medios promocionales" to txtNombreMedioPromocional.text.toString(),
                    "Periodicidad de la promoción" to txtPeriodicidadMedioPromocional.text.toString(),
                    "El atractivo forma parte de una oferta establecida (paquete turístico)" to oferta,
                    "Especifique" to txtEspecifiqueOfertaAtractivo.text.toString(),
                    "Observaciones" to txtObservacionesOfertaAtractivo.text.toString(),
                    "¿Posee un sistema de registro de visitantes?" to registroVisitantes,
                    "Años de Registro" to txtRegistroVisitantesAnios.text.toString(),
                    "¿Se genera reporte de estadísticas de visita al atractivo?" to estadisticasVisitantes,
                    "Frecuencia" to txtEstadisticasVisitantesFrecuencia.text.toString(),
                    "Temporalidad de visita al atractivo" to enTemporabilidad,
                    "Especifique" to txtEspecifiqueTemporabilidad.text.toString(),
                    "Número de Visitantes" to txtNumeroVisitasTemporabilidad.text.toString(),
                    "Observaciones" to txtObservacionesVisitantes.text.toString(),
                    "Turista" to turista,
                    "Ciudad / País de Origen" to txtOrigenTuristas.text.toString(),
                    "Llegadas mensuales" to txtLLegadasAnualesTuristas.text.toString(),
                    "Total Anual" to txtTotalAnualTuristas.text.toString(),
                    "Observaciones" to txtObservacionesTuristas.text.toString(),
                    "Nombre del Informante Clave" to txtNombreInformante.text.toString(),
                    "Contacto" to txtContactoInformante.text.toString(),
                    "Demanda según  días de visita" to demandaDias,
                    "Demanda según frecuencia de visita" to demandaFrecuencia,
                    "Observaciones" to txtObservacionesInformante.text.toString(),

                    )
            )
*/

        }
    }
}