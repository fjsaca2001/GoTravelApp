package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_recurso07.*
import kotlinx.android.synthetic.main.activity_add_recurso07.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso07.btnPerfil
import kotlinx.android.synthetic.main.activity_add_recurso07.btnSave


class addRecurso07 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso07)
        val bundle: Bundle? =intent.extras
        val respuestas01: Array<String>? = bundle?.getStringArray("respuestas01")
        val respuestas02: Array<String>? = bundle?.getStringArray("respuestas02")
        val respuestas03: Array<String>? = bundle?.getStringArray("respuestas03")
        val respuestas04: Array<String>? = bundle?.getStringArray("respuestas04")
        val respuestas05: Array<String>? = bundle?.getStringArray("respuestas05")
        val respuestas06: Array<String>? = bundle?.getStringArray("respuestas06")
        val respuestas07: Array<String>? = bundle?.getStringArray("respuestas07")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01?: arrayOf("No data"),
            respuestas02?: arrayOf("No data"),
            respuestas03?: arrayOf("No data"),
            respuestas04?: arrayOf("No data"),
            respuestas05?: arrayOf("No data"),
            respuestas06?: arrayOf("No data"),
            respuestas07?: arrayOf("No data")
        )
        botonera(email ?: "")
    }
    private fun view(email:String,respuestas01:Array<String>,respuestas02:Array<String>, respuestas03: Array<String>, respuestas04: Array<String>, respuestas05: Array<String>, respuestas06: Array<String>, respuestas07: Array<String>){
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

        val listaDemandaFrecuencia = listOf("Demanda según frecuencia de visita","Permanente", "Estacional","Esporádica","Inexistente")


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
        spDemandaFrecuencia.adapter=adapDemandaFrecuencia

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
            val listaDatos = arrayOf(
                promocion,
                txtEspecifiquePromocion.text.toString(),
                incluirPromocion,
                medioPromocional,
                txtNombreMedioPromocional.text.toString(),
                txtPeriodicidadMedioPromocional.text.toString(),
                oferta,
                txtEspecifiqueOfertaAtractivo.text.toString(),
                txtObservacionesOfertaAtractivo.text.toString(),
                registroVisitantes,
                txtRegistroVisitantesAnios.text.toString(),
                estadisticasVisitantes,
                txtEstadisticasVisitantesFrecuencia.text.toString(),
                enTemporabilidad,
                txtEspecifiqueTemporabilidad.text.toString(),
                txtNumeroVisitasTemporabilidad.text.toString(),
                txtObservacionesVisitantes.text.toString(),
                turista,
                txtOrigenTuristas.text.toString(),
                txtLLegadasAnualesTuristas.text.toString(),
                txtTotalAnualTuristas.text.toString(),
                txtObservacionesTuristas.text.toString(),
                txtNombreInformante.text.toString(),
                txtContactoInformante.text.toString(),
                demandaDias,
                demandaFrecuencia,
                txtObservacionesInformante.text.toString(),

            )
            val inicio: Intent = Intent(this,addRecurso08::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas01", respuestas01)
                putExtra("respuestas02", respuestas02)
                putExtra("respuestas03", respuestas03)
                putExtra("respuestas04", respuestas04)
                putExtra("respuestas05", respuestas05)
                putExtra("respuestas06", respuestas06)
                putExtra("respuestas07", respuestas07)
                putExtra("respuestas08", listaDatos)
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