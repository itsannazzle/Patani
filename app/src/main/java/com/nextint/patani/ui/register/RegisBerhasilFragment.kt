package com.nextint.patani.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.nextint.patani.R
import com.nextint.patani.databinding.FragmentRegisBerhasilBinding


class RegisBerhasilFragment : Fragment() {
    private var _binding : FragmentRegisBerhasilBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisBerhasilBinding.inflate(inflater, container, false)
        binding?.btnMasuk?.setOnClickListener { findNavController().navigate(R.id.action_regisBerhasilFragment_to_loginFragment) }
        binding?.imageView2.let {
            if (it != null) {
                Glide.with(requireActivity())
                    .load("https://padek.jawapos.com/wp-content/uploads/2020/10/sayur.jpg")
                    .fitCenter()
                    .into(it)
            }
        }
        return binding?.root
    }

}