package com.rusen.kotlincountries.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rusen.kotlincountries.R
import com.rusen.kotlincountries.common.viewBinding
import com.rusen.kotlincountries.databinding.FragmentCountryBinding

class CountryFragment : Fragment(R.layout.fragment_country) {

    private val binding by viewBinding(FragmentCountryBinding::bind)
    private var countryUuid = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }
    }
}