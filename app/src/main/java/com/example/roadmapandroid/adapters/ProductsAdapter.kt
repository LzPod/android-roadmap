package com.example.roadmapandroid.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roadmapandroid.databinding.CategoryItemBinding
import com.example.roadmapandroid.databinding.ProductItemBinding
import com.example.roadmapandroid.model.Product
import java.util.Locale

class ProductsAdapter(private var product: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    inner class ProductsViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.name.text = product.title
            binding.price.text = String.format(Locale.ITALY, "%.2f", product.price) + " €"

            Glide.with(binding.root.context)
                .load(product.image)
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(product[position])
    }
}