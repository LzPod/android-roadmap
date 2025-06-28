package com.example.roadmapandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roadmapandroid.databinding.ActivityMainBinding
import com.example.roadmapandroid.pages.HomePage

class MainActivity : AppCompatActivity() {

    //ActivityMainBinding esiste perché generata da activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Ora posso usare binding.id dei componenti all'interno di activity_main.xml
        val startButton = binding.startButton

        //L'intent serve per bindare diverse activities, cosìcchè possano comunicare
        // val intent = Intent(this, HomePage::class.java)

        //Ad esempio potrei passare dei parametri alla schermata successiva
        val valueToShare = getString(R.string.choose_a_category)
        val intent = Intent(this, HomePage::class.java).apply { putExtra("valueToShare", valueToShare) }

        //Voglio che lo startbutton cambi pagina quando lo clicco -> setOnClickListener
        startButton.setOnClickListener {
            startActivity(intent)
        }
    }



}