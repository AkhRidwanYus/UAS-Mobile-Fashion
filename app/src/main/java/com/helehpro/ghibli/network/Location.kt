package com.helehpro.ghibli.network

data class Location(
    val id: String,
    val name: String,
    val climate: String,
    val terrain: String,
    val surface_water: String,
    val residents: List<String>,
    val films: List<String>,
    val url: String,
)
