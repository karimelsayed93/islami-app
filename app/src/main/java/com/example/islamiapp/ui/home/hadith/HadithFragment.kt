package com.example.islamiapp.ui.home.hadith

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentHadithBinding
import com.example.islamiapp.ui.hadethDetails.HadethDetailsActivity
import com.example.islamiapp.ui.hadethDetails.HadethDetailsActivity.Companion.EXTRA_HADETH


class HadithFragment : Fragment() {
    lateinit var binding: FragmentHadithBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadithBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
    }

    private fun readHadethFile() {
        val allHadethList: MutableList<Hadeth> = mutableListOf()

        val allFileContent =
            requireContext().assets.open("ahadeth.txt")
                .bufferedReader().use { it.readText() }
        val seperatedAhadethContent = allFileContent.split("#")

        seperatedAhadethContent.forEach { hadeth ->
            val hadethLines = hadeth.trim().split("\n").toMutableList()
            val title = hadethLines[0]
            hadethLines.removeAt(0)

            val h = Hadeth(
                title = title,
                content = hadethLines.joinToString("\n")
            )

            allHadethList.add(h)

        }

        bindHadethList(allHadethList)


    }

    private fun bindHadethList(allHadethList: MutableList<Hadeth>) {

        val adapter = HadethListAdapter(allHadethList)
        adapter.onItemClickListener = HadethListAdapter.OnItemClickListener { position, hadeth ->
            startHadethDetailsActivity(hadeth)
        }
        binding.chaptersRecycler.adapter = adapter


    }

    private fun startHadethDetailsActivity(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(EXTRA_HADETH, hadeth)
        startActivity(intent)

    }
}