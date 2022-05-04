package com.example.ejercicioapinewsproto.repository.recycler

import android.content.Context
import android.content.Intent
import android.text.Html
import android.text.Html.fromHtml
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicioapinewsproto.R
import com.example.ejercicioapinewsproto.repository.retrofit.noticias.Data
import com.example.ejercicioapinewsproto.view.activities.DetalleNoticia
import com.google.gson.Gson


class NoticiasAdaptador(var context: Context,
                        var listDatos: List<Data>) :

    RecyclerView.Adapter<NoticiasAdaptador.NoticiasViewHolder>() {

    class NoticiasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imagen: ImageView
        var titulo: TextView
        var autor: TextView
        /*var descripcion: TextView*/

        //var con: Context

        init {
            imagen = itemView.findViewById(R.id.imageNoticia)
            titulo = itemView.findViewById(R.id.txtTitulo)
            autor  = itemView.findViewById(R.id.txtAutor)
            /*descripcion = itemView.findViewById(R.id.txtDescripcion)*/
            // con = context
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasViewHolder {
        val view =
        LayoutInflater.from(parent.context).inflate(R.layout.items_recycler,null,false)
        return  NoticiasViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiasViewHolder, position: Int) {
        holder.itemView.animation =
            AnimationUtils.loadAnimation(context, R.anim.fade_transition)
        holder.titulo.text = listDatos[position].title
        /*holder.descripcion.text = listDatos[position].description*/
        holder.autor.text = listDatos[position].author

        Glide.with(context)
            .load(listDatos[position].image)
            .override(500,500)
            .error(R.drawable.sinimagen)
            .into(holder.imagen)

        holder.itemView.setOnClickListener {
            var detalle = Gson().toJson(listDatos[holder.layoutPosition])
            var intent = Intent(context, DetalleNoticia::class.java)
                  intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                  intent.putExtra("data", detalle)
                  context.startActivity(intent)
        }
        /*holder.itemView.setOnClickListener {
            var busqueda = Gson().toJson(listDatos[holder.layoutPosition])
            var intentB = Intent(context, BuscarNoticias::class.java)
            intentB.flags= Intent.FLAG_ACTIVITY_NEW_TASK
            intentB.putExtra("data", busqueda)
            context.startActivity(intentB)
        }*/
    }

    override fun getItemCount(): Int {
        return listDatos.size

    }

}
