package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.DocumentsContract
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.toObject
import kotlinx.android.synthetic.main.activity_list_recurso.*
import kotlinx.android.synthetic.main.list_item.*


class ListRecurso : AppCompatActivity(),MyAdapter.OnLugarModificarClickListener {
    private var isEdit = false
    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>
    private lateinit var  adapterEditarLugar : MyAdapter
    private lateinit var myAdapter: MyAdapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_recurso)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        userArrayList = arrayListOf()
        myAdapter = MyAdapter(userArrayList,this)
        recyclerView.adapter = myAdapter
        val bundle: Bundle? =intent.extras
        val email:String? = bundle?.getString("email")

        EventChangeListener(email?:"")
        //edit(email?:"")
        botonera(email?:"")
    }
    private fun EventChangeListener(email: String) {
        db = FirebaseFirestore.getInstance()
        db.collection("atractivos").whereEqualTo("email",email)
            .addSnapshotListener(object :EventListener<QuerySnapshot>{
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
                        userArrayList.add(dc.document.toObject(User::class.java))
                    }
                }
                myAdapter.notifyDataSetChanged()
            }
        })
    }
/*
    private fun edit(email: String){
        btnEditar.setOnClickListener(){
            isEdit = true
            val inicio: Intent = Intent(this, addRecurso::class.java).apply {
                putExtra("email", email)
                putExtra("isEdit", isEdit)
            }
            startActivity(inicio)
        }
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

    override fun onItemClickEditar(email: String?) {
        isEdit = true
            val inicio: Intent = Intent(this, addRecurso::class.java).apply {
                putExtra("email", email)
                putExtra("isEdit", isEdit)
            }
            startActivity(inicio)

    }
}