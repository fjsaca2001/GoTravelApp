package com.example.gotravelapp

import android.content.ClipData
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter(
    private  val userlist:ArrayList<User>,
    private val itemClickListener: MyAdapter.OnLugarModificarClickListener
    ): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }
    interface  OnLugarModificarClickListener{
        fun onItemClickEditar(email : String?)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val user:User = userlist[position]
        holder.NombredelLugar.text = user.NombredelLugar
        holder.Provincia.text = user.Provincia
        holder.Canton.text = user.Canton
        holder.btnEdit.setOnClickListener {
            itemClickListener.onItemClickEditar(user.email)
        }

    }

    override fun getItemCount(): Int {
        return userlist.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val NombredelLugar: TextView = itemView.findViewById(R.id.obtenerAtractivo)
        val Provincia: TextView = itemView.findViewById(R.id.obtenerProvincia)
        val Canton: TextView = itemView.findViewById(R.id.obtenerCanton)
        val btnEdit : ImageButton = itemView.findViewById(R.id.btnEdit)
        /*
        fun bind(item: User,position: Int){
            itemView.btnEditar.setOnClickListener {
                itemClickListener.onItemClickEditar(item.email)
            }
        }

         */

    }
}