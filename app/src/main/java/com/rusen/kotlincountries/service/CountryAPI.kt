package com.rusen.kotlincountries.service

import com.rusen.kotlincountries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //https://github.com/atilsamancioglu/IA19-DataSetCountries/blob/master/countrydataset.json
    //BASE_URL -> https://github.com/
    //EXT -> atilsamancioglu/IA19-DataSetCountries/blob/master/countrydataset.json

    @GET("atilsamancioglu/IA19-DataSetCountries/blob/master/countrydataset.json")
    fun getCountries(): Single<List<Country>>

}