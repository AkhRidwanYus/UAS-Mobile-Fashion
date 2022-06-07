package com.helehpro.ghibli.network;

data class Film(
    val id: String,
    val title: String,
    val original_title: String,
    val original_title_romanised: String,
    val description: String,
    val image: String,
    val director: String,
    val producer: String,
    val release_date: String,
    val running_time: String,
    val rt_score: String
    )