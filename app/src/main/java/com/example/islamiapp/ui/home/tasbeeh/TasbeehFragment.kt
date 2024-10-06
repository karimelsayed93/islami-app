package com.example.islamiapp.ui.home.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.FragmentTasbeehBinding



class TasbeehFragment : Fragment() {

    var counter = 0;
    var currentIndex = 0


    lateinit var azkarList: MutableList<String>

    lateinit var binding: FragmentTasbeehBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.zekrTv.text = azkarList[0]


        onSebhaClick()
    }

    private fun onSebhaClick() {
        binding.bodySebha.setOnClickListener {
            binding.bodySebha.rotation = (360 / 33).toFloat()
            if (counter < 33) {
                counter += 1
            } else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0
                binding.zekrTv.text = azkarList[currentIndex]
            }
            binding.counterOfTasbehTv.text = counter.toString()

        }
    }
}