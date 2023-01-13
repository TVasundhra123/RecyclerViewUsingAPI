package com.example.recyclerviewapi.recyclerView

data class MovieResponse(
    val Search: List<Movies>
)

data class Movies(
    val Title: String = "",
    val Poster: String,
)
