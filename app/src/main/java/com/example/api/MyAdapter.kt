package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity, val productArrayList : List<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        //now how to to show image in image view, if the image is in the form of url, so for that we have 3rd party library
         //Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView
        val image : ShapeableImageView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
        }
    }
}