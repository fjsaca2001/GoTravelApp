package com.example.gotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso06.*


class addRecurso06 : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso06)
        val bundle: Bundle? =intent.extras
        val respuesta: Array<String>? = bundle?.getStringArray("lista")
        val email:String? = bundle?.getString("email")
        view(
            email ?: "",
            respuesta ?: arrayOf()
        )
    }
    private fun view(email:String,respuestas:Array<String>){
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
            for (item: String in respuestas) {
                println(item)
            }
            val inicio: Intent = Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)

/*
            db.collection("atractivos").document(email).set(
                hashMapOf("¿El GAD cuenta con el Plan de Desarrollo Turístico Territorial?" to gad,
                    "Año de Elaboración" to txtAnioElaboracion.text.toString(),
                    "¿El atractivo se encuentra dentro de la planificación turística territorial (GAD´S)?" to gads,
                    "Especifique" to txtEspecifiqueGads.text.toString(),
                    "¿Existen normativas que se apliquen para el desarrollo de la actividad turística en el atractivo?" to normativas,
                    "Especifique" to txtEspecifiqueNormativa.text.toString(),
                    "¿Existen ordenanzas que se apliquen para el desarrollo de la actividad turística en el atractivo?" to ordenanza,
                    "Especifique" to txtEspecifiqueOrdenanza.text.toString(),
                    "Observaciones" to txtObservacionesPoliticaRegulacion.text.toString(),
                    "En el Agua" to enAgua,
                    "Observaciones" to txtObservacionesAtractivoAgua.text.toString(),
                    "En el Aire" to enAire,
                    "Observaciones" to txtObservacionesAtractivoAire.text.toString(),
                    "En Superficie Terrestre" to enTierra,
                    "Observaciones" to txtObservacionesAtractivoTerrestre.text.toString(),
                    "Tangibles e intangibles" to cultural,
                    "Observaciones" to txtObservacionesAtractivoCultural.text.toString(),

                    )
            )
*/

        }
    }
}