package com.rusen.kotlincountries.service

import com.rusen.kotlincountries.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryAPIService {

    //https://github.com/atilsamancioglu/IA19-DataSetCountries/blob/master/countrydataset.json
    //BASE_URL -> https://github.com/

    private val BASE_URL = "https://github.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CountryAPI::class.java)

    fun getData() : Single<List<Country>>{
        return api.getCountries()
    }
}