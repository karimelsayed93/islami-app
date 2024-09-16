package com.example.islamiapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.ui.home.hadith.HadithFragment
import com.example.islamiapp.ui.home.hadith.QuranFragment
import com.example.islamiapp.ui.home.hadith.RadioFragment
import com.example.islamiapp.ui.home.hadith.TasbeehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.navigation_home)



        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quran -> {
                    showTab(QuranFragment())

                }

                R.id.navigation_Hadith -> {
                    showTab(HadithFragment())

                }

                R.id.navigation_radio -> {
                    showTab(RadioFragment())

                }

                R.id.navigation_tasbeeh -> {
                    showTab(TasbeehFragment())

                }
            }
            return@setOnItemSelectedListener true
        }

        bottomNav.selectedItemId = R.id.navigation_quran


    }

    fun showTab(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)

            .commit()
    }
}