package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_recurso06.*
import kotlinx.android.synthetic.main.activity_add_recurso06.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso06.btnPerfil
import kotlinx.android.synthetic.main.activity_add_recurso06.btnSave


class addRecurso06 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso06)
        val bundle: Bundle? =intent.extras
        val respuestas01: Array<String>? = bundle?.getStringArray("respuestas01")
        val respuestas02: Array<String>? = bundle?.getStringArray("respuestas02")
        val respuestas03: Array<String>? = bundle?.getStringArray("respuestas03")
        val respuestas04: Array<String>? = bundle?.getStringArray("respuestas04")
        val respuestas05: Array<String>? = bundle?.getStringArray("respuestas05")
        val respuestas06: Array<String>? = bundle?.getStringArray("respuestas06")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuestas01 ?: arrayOf("No data"),
            respuestas02 ?: arrayOf("No data"),
            respuestas03?: arrayOf("No data"),
            respuestas04?: arrayOf("No data"),
            respuestas05?: arrayOf("No data"),
            respuestas06?: arrayOf("No data")
        )
        botonera(email ?: "")
    }
    private fun view(email:String,respuestas01:Array<String>,respuestas02:Array<String>, respuestas03: Array<String>, respuestas04: Array<String>, respuestas05: Array<String>, respuestas06: Array<String>){
        val listaPLanGad = listOf("¿El GAD cuenta con el Plan de Desarrollo Turístico Territorial?",
            "Conservado", "Si","No")

        val listaGads = listOf("¿El atractivo se encuentra dentro de la planificación turística territorial (GAD´S)?"
            ,"Si", "No")

        val listaNormativa = listOf("¿Existen normativas que se apliquen para el desarrollo de la actividad turística en el atractivo?"
            ,"Si", "No")

        val listaOrdenanza = listOf("¿Existen ordenanzas que se apliquen para el desarrollo de la actividad turística en el atractivo?",
            "Si", "No")

        val listaEnAgua = listOf("En el Agua"
            ,"Buceo", "Kayak de mar", "Kayak lacustre","Kayak de Rio","Surf","kite Surf","Rafting"
            ,"Snorkel","Tubing","Regata","Paseo en panga","Paseo en bote","Paseo en lancha","Pase en moto acuática"
            ,"Parasailing","Esquí acuatico","Banana flotante","Boya","Pesca deportiva","Otro")

        val listaEnAire = listOf("En el Aire","Alas Delta", "Canopy","Parapente","Otro")

        val listaEnTierra = listOf("En Superficie Terrestre","Montañismo","Escalada","Senderismo"
            ,"Cicloturismo","Canyoning","Exploración de cuevas","Actividades Recreativas","Cabalgata"
            ,"Caminata","Camping","Picnic","Observación de flora y fauna","Observación de astros","Otro")

        val listaCultural = listOf("Tangibles e intangibles","Recorridos guiados", "Recorrido autoguiados"
            , "Visita a talleres artísticos","Participación en talleres artísticos","Visita a talleres artesanales"
            ,"Participación en talleres artesanales","Exposiciones temáticas permanentes, temporales y eventuales"
            ,"Exhibición de piezas, muestras, obras, etc., originales","Actividades vivenciales y/o lúdicas"
            ,"Presentaciones o representaciones en vivo","Muestras audiovisuales","Fotografía","Degustación de platos tradicionales"
            ,"Participación de la celebración","Compra de artesanías","Convivencia","Medicina ancestral","Otro")


        //val spLinea = findViewById<Spinner>(R.id.spLinea)

        val adaplistaGad = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPLanGad)
        val adapGads= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaGads)
        val adapNormativas= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaNormativa)
        val adapOrdenanza= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaOrdenanza)
        val adapEnAgua= ArrayAdapter(this, android.R.layout.simple_spinner_item, listaEnAgua)
        val adapEnAire = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaEnAire)
        val adapEnTerrestre = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaEnTierra)
        val adapCultural = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaCultural)

        var gad = ""
        var gads = ""
        var normativas = ""
        var ordenanza = ""
        var enAgua = ""
        var enAire = ""
        var enTierra = ""
        var cultural = ""

        spPlanGAD.adapter = adaplistaGad
        spGads.adapter = adapGads
        spNormativa.adapter = adapNormativas
        spOrdenanza.adapter = adapOrdenanza
        spAtractivoAgua.adapter = adapEnAgua
        spAtractivoAire.adapter= adapEnAire
        spAtractivoTerrestre.adapter=adapEnTerrestre
        spAtractivoCultural.adapter=adapCultural

        spPlanGAD.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gad = listaPLanGad[position]
                println(listaPLanGad[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spNormativa.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                normativas = listaNormativa[position]
                println(listaNormativa[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spOrdenanza.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                ordenanza = listaOrdenanza[position]
                println(listaOrdenanza[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spGads.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gads = listaGads[position]
                println(listaGads[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAtractivoAgua.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                enAgua = listaEnAgua[position]
                println(listaEnAgua[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAtractivoAire.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                enAire = listaEnAire[position]
                println(listaEnAire[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAtractivoTerrestre.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                enTierra = listaEnTierra[position]
                println(listaEnTierra[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spAtractivoCultural.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                cultural = listaCultural[position]
                println(listaCultural[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener(){
            val listaDatos = arrayOf(
                gad,
                txtAnioElaboracion.text.toString(),
                gads,
                txtEspecifiqueGads.text.toString(),
                normativas,
                txtEspecifiqueNormativa.text.toString(),
                ordenanza,
                txtEspecifiqueOrdenanza.text.toString(),
                txtObservacionesPoliticaRegulacion.text.toString(),
                enAgua,
                txtObservacionesAtractivoAgua.text.toString(),
                enAire,
                txtObservacionesAtractivoAire.text.toString(),
                enTierra,
                txtObservacionesAtractivoTerrestre.text.toString(),
                cultural,
                txtObservacionesAtractivoCultural.text.toString(),
            )
            val inicio: Intent = Intent(this,addRecurso07::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas01", respuestas01)
                putExtra("respuestas02", respuestas02)
                putExtra("respuestas03", respuestas03)
                putExtra("respuestas04", respuestas04)
                putExtra("respuestas05", respuestas05)
                putExtra("respuestas06", respuestas06)
                putExtra("respuestas07", listaDatos)
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