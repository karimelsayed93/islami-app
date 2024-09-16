package com.example.islamiapp.ui.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ActivityChapterDetailsBinding


class ChapterDetailsActivity : AppCompatActivity() {
    var chapterPosition = -1
    lateinit var chapterTitle: String
    lateinit var versesRecycler: RecyclerView
    lateinit var binding: ActivityChapterDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding


        initParams()
        initViews()

        readChapter()


    }

    private fun readChapter() {

        val allFileContent = assets.open("${chapterPosition + 1}.txt")
            .bufferedReader().use { it.readText() }
        val versesList = allFileContent.split("\n")

        bindVersesToRecyclerViewAdapter(versesList)

    }

    private fun bindVersesToRecyclerViewAdapter(versesList: List<String>) {
        val versesAdapter = VersesAdapter(versesList)
        versesRecycler.adapter = versesAdapter
    }


    private fun initViews() {
        //to show back button
        setSupportActionBar(binding.toolBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = null

        binding.chapterTitle.text = chapterTitle

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun initParams() {
        chapterPosition = intent.getIntExtra(CHAPTER_POSITION, -1)
        chapterTitle = intent.getStringExtra(CHAPTER_TITLE) ?: ""
    }

    companion object {
        const val CHAPTER_POSITION = "position"
        const val CHAPTER_TITLE = "title"

    }
}