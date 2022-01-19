package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso01.*
import kotlinx.android.synthetic.main.activity_perfil.*

class addRecurso01 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso01)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }

    private fun view(email:String,respuestas:Array<String>){
        val listaLineaProducto = listOf("Linea de producto al que pertenece","Cultura", "Naturaleza", "Aventura")
        val listaEscenario = listOf("Escenario donde se localiza","Prístimo", "Primitivo", "Rústico Natural")
        val listaTipoIn = listOf("Tipo de ingreso","Libre", "Restringido", "Pagado")
        val listaAtencion = listOf("Atención","Todos los dias", "Fines de semana y feriados", "Solo días habiles")
        val listaFormaP = listOf("Forma de pago","Efectivo", "Tarjeta Crédito", "Tarjeta Débito", "Cheque", "Transferencia")


        //val spLinea = findViewById<Spinner>(R.id.spLinea)

        val adapLista = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaLineaProducto)
        val adapEscenario= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaEscenario)
        val adapTipoIn= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTipoIn)
        val adapAtencion= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaAtencion)
        val adapFormaP= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaFormaP)

        var lista = ""
        var escenario = ""
        var tipoIn = ""
        var atencion = ""
        var formaP = ""

        spLinea.adapter = adapLista
        spEscenario.adapter = adapEscenario
        spTipoIn.adapter = adapTipoIn
        spAtencion.adapter = adapAtencion
        spFormaP.adapter = adapFormaP

        spLinea.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                lista = listaLineaProducto[position]
                println(listaLineaProducto[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spEscenario.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                escenario = listaEscenario[position]
                println(listaEscenario[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTipoIn.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tipoIn = listaTipoIn[position]
                println(listaTipoIn[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAtencion.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                atencion = listaAtencion[position]
                println(listaAtencion[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spFormaP.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                formaP = listaFormaP[position]
                println(listaFormaP[position])
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
                hashMapOf("Clima" to txtClima.text.toString(),
                    "Temperatura" to txtTemp.text.toString(),
                    "Precipitacion pluvimetrica" to txtPresi.text.toString(),
                    "Linea de producto" to lista,
                    "Escenario donde se localiza" to escenario,
                    "Tipo de ingreso" to tipoIn,
                    "Hora de Ingreso" to txtHoraIn.text.toString(),
                    "Hora de Salida" to txtHoraIn.text.toString(),
                    "Atencion" to atencion,
                    "Formas de pago" to formaP,
                    "Meses recomendados" to txtMeses.text.toString(),
                    "Observaciones" to txtObserva.text.toString()



                    )
            )
            */

        }
    }
}