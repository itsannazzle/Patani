package com.nextint.patani.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.nextint.patani.R
import com.nextint.patani.databinding.FragmentDetailProdukBinding

class DetailProdukFragment : Fragment() {
    private var _binding : FragmentDetailProdukBinding? = null
    private val binding get() = _binding
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailProdukBinding.inflate(inflater, container, false)
        root = binding?.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = listOf(R.array.satuan)
        val adapter = ArrayAdapter(requireContext(),R.layout.menu_dropdown,items)
        (binding?.filledExposedDropdown)?.setAdapter(adapter)
        val actionBar=  (activity as AppCompatActivity).supportActionBar
        actionBar?.title = R.string.deskripsi_produk.toString()
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }

}