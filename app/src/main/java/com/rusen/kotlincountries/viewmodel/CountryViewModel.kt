package com.rusen.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rusen.kotlincountries.model.Country

class CountryViewModel : ViewModel() {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("Turkey","Ankara","Asia","TRY","Turkish","www.ss.com")
        countryLiveData.value = country
    }
}