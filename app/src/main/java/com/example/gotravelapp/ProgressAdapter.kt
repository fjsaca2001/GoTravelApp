package com.example.gotravelapp

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_progress.view.*

class ProgressAdapter (
    private  val progresolist:ArrayList<Progreso>
    ):RecyclerView.Adapter<ProgressAdapter.myViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ProgressAdapter.myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_progress,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProgressAdapter.myViewHolder, position: Int) {
        val progreso:Progreso = progresolist[position]
        holder.NombredelLugar.text = progreso.NombredelLugar
        holder.Total.text = progreso.Total
        holder.Porcentaje.text = ("${progreso.Porcentaje}%")
        holder.progressBar.max =172
        ObjectAnimator.ofInt(holder.progressBar,"progress", progreso.Total?.toInt()!!
        ).setDuration(2000).start()
    }

    override fun getItemCount(): Int {
        return progresolist.size
    }

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val NombredelLugar: TextView = itemView.findViewById(R.id.obtenerAtractivoNombre)
        val Total: TextView = itemView.findViewById(R.id.obtenerTotalAtractivos)
        val Porcentaje: TextView = itemView.findViewById(R.id.obtenerPorcentajes)
        val progressBar : ProgressBar = itemView.findViewById(R.id.progressBar)

    }
}