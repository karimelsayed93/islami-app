package com.example.islamiapp.ui.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class ChapterRecyclerAdapter(val chapters: List<String>) :
    RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.chapter_title)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = chapters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = chapters[position]
        holder.title.text = chapters[position]
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {

                onItemClickListener?.onItemClick(position, title)

            }
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, title: String)
    }
}