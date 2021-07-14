package com.nextint.patani.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.navigation.findNavController
import com.nextint.patani.R
import com.nextint.patani.databinding.FragmentDaftarBinding
import com.nextint.patani.databinding.FragmentLoginBinding

class DaftarFragment : Fragment() {
    private var _binding : FragmentDaftarBinding? = null
    private val binding get() = _binding
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDaftarBinding.inflate(inflater, container, false)
        root = binding?.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val actionBar = (activity as AppCompatActivity).supportActionBar
//        actionBar?.title = R.string.masuk.toString()
//        actionBar?.setDisplayShowHomeEnabled(true)
//        actionBar?.setDisplayShowHomeEnabled(true)
        toolbarSetUp()
    }

    private fun toolbarSetUp() {
        binding?.toolbar?.toolbarLayout?.apply {
            title = R.string.daftar.toString()
            navigationIcon = ContextCompat.getDrawable(requireContext(),R.drawable.ic_customback)
            setNavigationOnClickListener { findNavController().popBackStack() }
            popupTheme = R.style.Theme_MaterialComponents_DayNight_DarkActionBar
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }

}