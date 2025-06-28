package com.example.roadmapandroid.pages

import ApiInterface
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.roadmapandroid.adapters.ProductsAdapter
import com.example.roadmapandroid.databinding.ActivityRetrofitPageBinding
import com.example.roadmapandroid.model.Product
import com.example.roadmapandroid.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitPage : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitPageBinding
    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getApiInterface()
        getProducts(this)

    }

    private fun getApiInterface() {
        apiInterface = RetrofitInstance.getInstance().create(ApiInterface::class.java)
    }

    private fun getProducts(context: Context) {
        val call = apiInterface.getProduct()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful && response.body() != null) {
                    val products = response.body()!!
                    val adapter = ProductsAdapter(products)
                    binding.rvProducts.adapter = adapter
                    binding.rvProducts.layoutManager = GridLayoutManager(context, 2)
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}