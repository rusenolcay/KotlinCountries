package com.rusen.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rusen.kotlincountries.databinding.ItemCountryBinding
import com.rusen.kotlincountries.model.Country
import com.rusen.kotlincountries.util.downloadFromUrl
import com.rusen.kotlincountries.util.placeholderProgressBar
import com.rusen.kotlincountries.view.FeedFragmentDirections

class CountryAdapter(
    private val countryList: ArrayList<Country>
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(country = countryList[position])
    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    class CountryViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            with(binding){
                tvNameCountry.text = country.countryName
                region.text = country.countryRegion
                imageview.downloadFromUrl(country.imageUrl, placeholderProgressBar(binding.imageview.context))

                root.setOnClickListener {
                    val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(country.uuid)
                    Navigation.findNavController(it).navigate(action)
                }
            }

        }
    }
}
