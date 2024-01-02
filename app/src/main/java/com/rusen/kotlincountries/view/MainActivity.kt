package com.rusen.kotlincountries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rusen.kotlincountries.common.viewBinding
import com.rusen.kotlincountries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}