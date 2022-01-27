package com.example.gotravelapp

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_reports.*


public class Reports : AppCompatActivity() {
    private val db1 = FirebaseFirestore.getInstance()
    private lateinit var progresoArrayList: ArrayList<Progreso>
    private lateinit var recyclerViewprogreso: RecyclerView
    private lateinit var myprogreso: ProgressAdapter
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)
        recyclerViewprogreso = findViewById(R.id.recyclerView1)
        recyclerViewprogreso.layoutManager = LinearLayoutManager(this)
        recyclerViewprogreso.setHasFixedSize(true)
        progresoArrayList = arrayListOf()
        myprogreso = ProgressAdapter(progresoArrayList)
        recyclerViewprogreso.adapter = myprogreso
        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")
        EventChangeListener(email?:"")
        //vista(email ?: "")
        botonera(email?:"")

    }
    private fun EventChangeListener(email: String) {
        db = FirebaseFirestore.getInstance()
        db.collection("atractivos").whereEqualTo("email",email)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?,

                    ) {
                    if (error!=null){
                        Log.e("Firrestore error",error.message.toString())
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!){
                        if (dc.type == DocumentChange.Type.ADDED){
                            progresoArrayList.add(dc.document.toObject(Progreso::class.java))
                        }
                    }
                    myprogreso.notifyDataSetChanged()
                }
            })
    }
    /*
    private fun vista(email: String) {
        progressBar.max = 172
        var progreso = ""
        var total = 0

        db.collection("atractivos").document(email).get().addOnSuccessListener {
            val part = obtenerAtractivoNombre.setText(it.get("Nombre del Lugar") as String?)
            progreso = it.get("Total") as String
            obtenerTotalAtractivos.setText(progreso)
            total = (progreso.toInt()*100)/172
            //obtenerPorcentajes.setText(total.toString())
            obtenerPorcentajes.text=("${total.toString()}%")

            ObjectAnimator.ofInt(progressBar,"progress",progreso.toInt())
                .setDuration(2000)
                .start()

        }

        progressBar.getProgressDrawable().setColorFilter(
            Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);
    }

     */

    private fun botonera(email: String){
        btnHome01.setOnClickListener(){
            val inicio: Intent = Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnPerfil.setOnClickListener(){
            val inicio: Intent = Intent(this,Perfil::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnExit.setOnClickListener{
            val saltar: Intent = Intent(this,MainActivity::class.java)
            startActivity(saltar)
        }
    }
}