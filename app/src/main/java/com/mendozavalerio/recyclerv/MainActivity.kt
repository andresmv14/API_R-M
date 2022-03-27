package com.mendozavalerio.recyclerv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mendozavalerio.recyclerv.adaptador.AdaptadorPersonaje
import com.mendozavalerio.recyclerv.modelo.Personaje

class MainActivity : AppCompatActivity() {
    lateinit var miRecycler:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaPersonajes = ArrayList<Personaje>()
        listaPersonajes.add(Personaje("Blender","https://imagenes.20minutos.es/files/image_656_370/uploads/imagenes/2022/02/13/bender.jpeg"))
        listaPersonajes.add(Personaje("Homero S.","https://indiehoy.com/wp-content/uploads/2021/03/homero-simpson-1200x900.jpg"))

        miRecycler = findViewById(R.id.recyclerPersonajes)

        miRecycler.adapter = AdaptadorPersonaje(listaPersonajes)

        miRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
}