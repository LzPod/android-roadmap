package com.example.roadmapandroid.pages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.roadmapandroid.adapters.CategoriesAdapter
import com.example.roadmapandroid.databinding.ActivityHomePageBinding
import com.example.roadmapandroid.data.categoriesList
import com.example.roadmapandroid.model.Category

class HomePage : AppCompatActivity() {
    private var title: String? = null

    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Ripesco il valore extra della schermata precedente
        title = intent.getStringExtra("valueToShare")

        //E lo assegno al TextView
        binding.title.text = title

        //RecycleView
        val categoriesList: List<Category> = categoriesList

        val adapter = CategoriesAdapter(categoriesList)
        binding.rvCategories.adapter = adapter
        binding.rvCategories.layoutManager = GridLayoutManager(this, 2)
    }
}
