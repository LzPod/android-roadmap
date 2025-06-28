package com.example.roadmapandroid.pages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roadmapandroid.databinding.ActivityEditTextPageBinding
import java.util.Locale

class EditTextPage : AppCompatActivity() {

    private lateinit var binding: ActivityEditTextPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calculateButton.setOnClickListener {
            if(binding.et.text.isEmpty()) {
                binding.etResult.text = "Brutta testa di cazzo scrivi qualcosa"
                return@setOnClickListener
            }
            var value = binding.et.text.toString().toDouble()
            value /= 1.609
            binding.etResult.text = String.format(Locale.ITALY,"%.2f", value)
        }

    }
}