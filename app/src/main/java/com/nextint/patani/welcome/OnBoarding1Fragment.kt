package com.nextint.patani.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.nextint.patani.R
import com.nextint.patani.databinding.FragmentOnBoarding1Binding

class OnBoarding1Fragment : Fragment() {
    private var _binding : FragmentOnBoarding1Binding? = null
    private val binding get() = _binding
    private var root : View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnBoarding1Binding.inflate(inflater, container, false)
        root = binding?.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            binding?.ob1Img?.let { it1 ->
                Glide.with(it)
                        .load("https://as2.ftcdn.net/v2/jpg/01/80/60/59/1000_F_180605981_LloxG8M7yKF8vnmuDBgwAc4vMgUMli0x.jpg")
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
                        .into(it1)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }

}