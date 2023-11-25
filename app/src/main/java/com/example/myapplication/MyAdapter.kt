package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.*

class MyAdapter(val list: List<Book>) : RecyclerView.Adapter<MyAdapter.MyView>() {
    class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val bName = view.findViewById<TextView>(R.id.bookName)
        val bYear = view.findViewById<TextView>(R.id.bookYear)
        val bImage = view.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        view.setOnClickListener {

        }
        return MyView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bName.text = list[position].name
        holder.bYear.text = list[position].publish.toString()
        Picasso.get().load(list[position].image).into(holder.bImage);
        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView.findViewById(R.id.layout),"Test N: $position",Snackbar.LENGTH_LONG).show()
        }
    }
}