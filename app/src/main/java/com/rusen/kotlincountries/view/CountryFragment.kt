package com.rusen.kotlincountries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rusen.kotlincountries.R
import com.rusen.kotlincountries.common.viewBinding
import com.rusen.kotlincountries.databinding.FragmentCountryBinding
import com.rusen.kotlincountries.util.downloadFromUrl
import com.rusen.kotlincountries.util.placeholderProgressBar
import com.rusen.kotlincountries.viewmodel.CountryViewModel

class CountryFragment : Fragment(R.layout.fragment_country) {
    private val binding by viewBinding(FragmentCountryBinding::bind)
    private val viewModel: CountryViewModel by viewModels()
    private var countryUuid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
            viewModel.getDataFromRoom(countryUuid)
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.countryLiveData.observe(viewLifecycleOwner) { country ->
            country?.let {
                with(binding) {
                    countryName.text = country.countryName
                    countryCapital.text = country.countryCapital
                    countryRegion.text = country.countryRegion
                    countryCurrency.text = country.countryCurrency
                    countryLangueage.text = country.countryLanguage
                }

                context?.let {
                    binding.countryImage.downloadFromUrl(
                        country.imageUrl,
                        placeholderProgressBar(it)
                    )

                }
            }
        }
    }
}