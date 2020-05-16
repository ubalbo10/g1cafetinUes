package com.example.g1cafetinues

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AdaptadorLocales (items:ArrayList<String>): RecyclerView.Adapter<AdaptadorLocales.ViewHolder>() {


        var ListDatos=ArrayList<String>()

        init {
            this.ListDatos=items
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorLocales.ViewHolder {
            var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_locales
                    ,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return ListDatos.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.asignarDatos(ListDatos[position])
            holder.button.setOnClickListener {
                // abrir el restaurante que se seleciona
                Log.i("selecion","${holder.nombre.text}")
            }

        }

        class ViewHolder(itemView: View /**/) : RecyclerView.ViewHolder(itemView){
            //buscar los widget de la vista

            var button=itemView.findViewById<ImageButton>(R.id.imageButton_locales)
            var nombre=itemView.findViewById<TextView>(R.id.textView_nombre_local)





            fun asignarDatos(datos: String) {
                //asignar datos
                nombre.text=datos.toString()

            }







        }
    }

