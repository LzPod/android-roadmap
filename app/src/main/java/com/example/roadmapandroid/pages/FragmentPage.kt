package com.example.roadmapandroid.pages

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.roadmapandroid.R
import com.example.roadmapandroid.databinding.ActivityFragmentPageBinding
import com.example.roadmapandroid.pages.fragments.BlankFragment
import com.example.roadmapandroid.pages.fragments.PrettyFragment

class FragmentPage : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val fragmentA = BlankFragment()
        val fragmentB = PrettyFragment()
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragmentA)
            .commit()

        binding.changeButton.setOnClickListener {
            val fragment: Fragment = if (fragmentA == supportFragmentManager.fragments.first()) {
                fragmentB
            } else {
                fragmentA
            }
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, fragment)
                .commit()

        }

    }
}