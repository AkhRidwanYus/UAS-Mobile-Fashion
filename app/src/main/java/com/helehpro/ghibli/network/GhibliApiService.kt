package com.helehpro.ghibli.network;

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val url = "https://ghibliapi.herokuapp.com"

val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(url).build()

interface  GhibliApiService {
    @GET("films")
    suspend fun getFilm(): List<Film>

    @GET("locations")
    suspend fun getLocation(): List<Location>

    @GET("species")
    suspend fun getSpecies(): List<Species>
}

object GhibliApi{
    val retrofitService: GhibliApiService by lazy {
        retrofit.create(GhibliApiService::class.java)
    }
}