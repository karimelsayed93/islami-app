package com.example.islamiapp.ui.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivityHadethDetailsBinding
import com.example.islamiapp.ui.home.hadith.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsBinding


    var hadeth: Hadeth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readExtras()
        initViews()

    }

    private fun initViews() {
        title = null
        setSupportActionBar(binding.contentHadeth)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.chapterTitle.text = hadeth?.title
        binding.content.content.text = hadeth?.content

    }

    private fun readExtras() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(EXTRA_HADETH, Hadeth::class.java)
        } else
            hadeth = intent.getParcelableExtra(EXTRA_HADETH) as Hadeth?
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_HADETH = "hadeth"
    }
}