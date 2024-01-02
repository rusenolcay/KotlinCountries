package com.rusen.kotlincountries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rusen.kotlincountries.R
import com.rusen.kotlincountries.common.viewBinding
import com.rusen.kotlincountries.databinding.FragmentFeedBinding

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private val binding by viewBinding(FragmentFeedBinding::bind)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}