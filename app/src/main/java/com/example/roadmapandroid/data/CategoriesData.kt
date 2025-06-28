package com.example.roadmapandroid.data

import com.example.roadmapandroid.R
import com.example.roadmapandroid.model.Category
import com.example.roadmapandroid.pages.EditTextPage
import com.example.roadmapandroid.pages.FragmentPage
import com.example.roadmapandroid.pages.RetrofitPage

val categoriesList = listOf(
    Category("Edit Text", R.drawable.baseline_calculate_24, EditTextPage::class.java),
    Category("Fragments", R.drawable.baseline_outbox_24, FragmentPage::class.java),
    Category("Retrofit", R.drawable.retrofit_icon, RetrofitPage::class.java),
)
