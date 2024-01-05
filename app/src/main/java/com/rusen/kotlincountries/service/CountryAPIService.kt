package com.rusen.kotlincountries.service

import com.google.gson.GsonBuilder
import com.rusen.kotlincountries.model.Country
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class CountryAPIService {

    //https://github.com/atilsamancioglu/IA19-DataSetCountries/blob/master/countrydataset.json
    //BASE_URL -> https://github.com/

    private val BASE_URL = "https://raw.githubusercontent.com/"

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    var client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()
        .create(CountryAPI::class.java)

    fun getData(): Single<List<Country>> {
        return api.getCountries()
    }
}