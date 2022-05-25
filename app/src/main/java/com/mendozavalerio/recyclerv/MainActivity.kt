package com.mendozavalerio.recyclerv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.mendozavalerio.recyclerv.adaptador.AdaptadorPersonaje
import com.mendozavalerio.recyclerv.modelo.Personaje

class MainActivity : AppCompatActivity() {
    lateinit var miRecycler:RecyclerView
    lateinit var adaptador:AdaptadorPersonaje
    lateinit var listaPersonajes:ArrayList<Personaje>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaPersonajes = ArrayList<Personaje>()
        //listaPersonajes.add(Personaje("Blender","https://imagenes.20minutos.es/files/image_656_370/uploads/imagenes/2022/02/13/bender.jpeg"))
        //listaPersonajes.add(Personaje("Homero S.","https://indiehoy.com/wp-content/uploads/2021/03/homero-simpson-1200x900.jpg"))

        miRecycler = findViewById(R.id.recyclerPersonajes)

        adaptador = AdaptadorPersonaje(listaPersonajes)
        miRecycler.adapter = adaptador
        getPersonajes()
        miRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    fun getPersonajes(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://rickandmortyapi.com/api/character"
        val objectRequest = JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener {respuesta ->
                //object si es un array meter directo
                val personajesJson = respuesta.getJSONArray("results")
                for (indice in 0..personajesJson.length()-1){
                    val personajeInJson = personajesJson.getJSONObject(indice)
                    val personaje = Personaje(personajeInJson.getString("name"),personajeInJson.getString("image"))
                    listaPersonajes.add(personaje)
                }
                adaptador.notifyDataSetChanged()
        },
        Response.ErrorListener {
            Log.e("PersonajesApi","Erro")
        })
        queue.add(objectRequest)
    }

}