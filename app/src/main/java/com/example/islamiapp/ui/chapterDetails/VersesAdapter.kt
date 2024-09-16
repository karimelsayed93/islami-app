package com.example.islamiapp.ui.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemVerseBinding

class VersesAdapter(private val versesList: List<String>) :
    RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemVerseBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

//        val view=LayoutInflater.from(parent.context).inflate(
//            R.layout.item_verse,parent,false
//        )
        val binding = ItemVerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return versesList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = versesList[position]
        holder.binding.content.text = "$content(${position + 1})"
    }
}