package com.example.recyclerviewapi.recyclerView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewapi.R

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.textView)
    val image: ImageView= itemView.findViewById(R.id.imageView)
    fun bind(movies: Movies) {
        title.text = movies.Title
        Glide.with(itemView.context).load(movies.Poster).into(image)
    }
}