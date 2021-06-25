package com.nextint.patani

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import com.nextint.patani.adapter.OnBoardingAdapter
import com.nextint.patani.databinding.ActivityMainBinding
import com.nextint.patani.welcome.OnBoarding1Fragment
import com.nextint.patani.welcome.OnBoarding2Fragment
import com.nextint.patani.welcome.OnBoarding3Fragment

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding
    private var root : View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Patani)
        supportActionBar?.hide()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        _binding = ActivityMainBinding.inflate(layoutInflater)
        root = binding?.root
        setContentView(root)
        val fragmentList = arrayListOf(
            OnBoarding1Fragment(),
            OnBoarding2Fragment(),
            OnBoarding3Fragment()
        )
        val onBoardingAdapter = OnBoardingAdapter(fragmentList,supportFragmentManager,lifecycle)
        binding?.viewPager?.adapter = onBoardingAdapter
        binding?.dotsIndicator?.setViewPager(binding?.viewPager)
    }

}