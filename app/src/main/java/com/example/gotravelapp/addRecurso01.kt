package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_recurso01.*

class addRecurso01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso01)
        var bundle: Bundle? =intent.extras
        var respuestas01: Array<String>? = bundle?.getStringArray("respuestas")
        var email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01?: arrayOf("No data")
        )
        botonera(email ?: "")
    }

    private fun view(email:String,respuestas01:Array<String>){
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
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener(){
            val listaDatos = arrayOf(
                txtClima.text.toString(),
                txtTemperatura.text.toString(),
                txtPrecipitacion.text.toString(),
                lista,
                escenario,
                tipoIn,
                txtHoraIn.text.toString(),
                txtHoraSal.text.toString(),
                atencion,
                formaP,
                txtMeses.text.toString(),
                txtObserva.text.toString()
            )
            val inicio: Intent = Intent(this,addRecurso02::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas01", respuestas01)
                putExtra("respuestas02", listaDatos)
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