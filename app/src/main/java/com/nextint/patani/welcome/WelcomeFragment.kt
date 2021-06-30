package com.nextint.patani.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nextint.patani.R
import com.nextint.patani.ui.adapter.OnBoardingAdapter
import com.nextint.patani.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private var _binding : FragmentWelcomeBinding? = null
    private val binding get() = _binding
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        root = binding?.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentList = arrayListOf(
            OnBoarding1Fragment(),
            OnBoarding2Fragment(),
            OnBoarding3Fragment()
        )
        val onBoardingAdapter = OnBoardingAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
        binding?.viewPager?.adapter = onBoardingAdapter
        binding?.dotsIndicator?.setViewPager(binding?.viewPager)

        binding?.onboardButton?.btnDaftar?.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_daftarFragment)
        }
        binding?.onboardButton?.btnMasuk?.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }
}