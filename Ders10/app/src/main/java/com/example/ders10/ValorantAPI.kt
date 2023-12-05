package com.example.ders10


import io.reactivex.Observable
import retrofit2.http.GET

interface ValorantAPI {

    //https://raw.githubusercontent.com/gultendogan0/simple-valorant-api/main/simple-valorant-api.json

    @GET("gultendogan0/simple-valorant-api/main/simple-valorant-api.json")
    fun getData(): Observable<List<ValorantModel>>
}


