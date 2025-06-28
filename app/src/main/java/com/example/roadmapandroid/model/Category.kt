package com.example.roadmapandroid.model

data class Category(
    val title: String,
    val image: Int,
    val targetActivity: Class<*>
)