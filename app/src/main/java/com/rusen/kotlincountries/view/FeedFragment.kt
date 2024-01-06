package com.rusen.kotlincountries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rusen.kotlincountries.R
import com.rusen.kotlincountries.adapter.CountryAdapter
import com.rusen.kotlincountries.common.viewBinding
import com.rusen.kotlincountries.databinding.FragmentFeedBinding
import com.rusen.kotlincountries.viewmodel.FeedViewModel

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private val binding by viewBinding(FragmentFeedBinding::bind)
    private val viewModel: FeedViewModel by viewModels()
    private val countryAdapter = CountryAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refreshData()

        with(binding) {
            countryList.layoutManager = LinearLayoutManager(context)
            countryList.adapter = countryAdapter

            swipRefreshLayout.setOnRefreshListener {
                countryList.visibility = View.GONE
                countryerror.visibility = View.GONE
                countryLoading.visibility = View.VISIBLE
                viewModel.refreshFromAPI()
                swipRefreshLayout.isRefreshing = false

            }

        }

        observeLiveData()
    }

    fun observeLiveData() {
        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            countries?.let {
                binding.countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        }
        viewModel.countryError.observe(viewLifecycleOwner) { error ->
            error?.let {
                if (it) {
                    binding.countryerror.visibility = View.VISIBLE
                } else {
                    binding.countryerror.visibility = View.GONE
                }
            }
        }
        viewModel.countryLoading.observe(viewLifecycleOwner) { loading ->
            loading?.let {
                if (it) {
                    binding.countryLoading.visibility = View.VISIBLE
                    binding.countryList.visibility = View.GONE
                    binding.countryerror.visibility = View.GONE
                } else {
                    binding.countryLoading.visibility = View.GONE
                }
            }

        }
    }
}