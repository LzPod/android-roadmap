package com.example.roadmapandroid.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.roadmapandroid.databinding.CategoryItemBinding
import com.example.roadmapandroid.model.Category
import com.example.roadmapandroid.pages.HomePage

class CategoriesAdapter(private var category: List<Category>) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    inner class CategoriesViewHolder(private val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.categoryName.text = category.title

            val drawable = ContextCompat.getDrawable(binding.root.context, category.image)
            drawable?.setBounds(0, 0, 300, 300)
            binding.categoryName.setCompoundDrawables(null, drawable, null, null)

            binding.categoryCard.setOnClickListener {
                val context = binding.categoryCard.context
                val intent = Intent(context, category.targetActivity)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(category[position])
    }

    override fun getItemCount(): Int {
        return category.size
    }
}