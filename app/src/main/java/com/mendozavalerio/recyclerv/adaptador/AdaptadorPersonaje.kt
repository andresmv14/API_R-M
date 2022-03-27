package com.mendozavalerio.recyclerv.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mendozavalerio.recyclerv.R
import com.mendozavalerio.recyclerv.modelo.Personaje
import com.squareup.picasso.Picasso


class AdaptadorPersonaje(val listaPersonajes: ArrayList<Personaje>):RecyclerView.Adapter<AdaptadorPersonaje.ViewHolder>(){
    //var listaPersonajes =  ArrayList<Personaje>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vistainidividual,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = listaPersonajes[position].nombre
        Picasso.get().load(listaPersonajes[position].foto).into(holder.ivFoto)
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){

        val tvNombre: TextView
        val ivFoto:ImageView

        init{
            tvNombre = vista.findViewById(R.id.tvNombre)
            ivFoto = vista.findViewById(R.id.ivPerfil)
        }

    }

}