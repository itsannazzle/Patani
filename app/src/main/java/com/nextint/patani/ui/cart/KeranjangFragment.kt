package com.nextint.patani.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nextint.patani.R
import com.nextint.patani.core.local.AlmostPanenProduct
import com.nextint.patani.core.local.KategoriProduct
import com.nextint.patani.core.local.Keranjang
import com.nextint.patani.core.local.entity.content
import com.nextint.patani.databinding.FragmentKeranjangBinding
import com.nextint.patani.ui.adapter.KategoriAdapter
import com.nextint.patani.ui.adapter.KeranjangAdapter
import com.nextint.patani.ui.adapter.ProductAdapterBasic


class KeranjangFragment : Fragment() {
    private var _binding : FragmentKeranjangBinding? = null
    private val binding get() = _binding
    private val keranajngAdapter : ArrayList<Keranjang> = arrayListOf()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKeranjangBinding.inflate(inflater, container, false)
        keranajngAdapter.addAll(content.keranjangCart)
        binding?.checkout?.setOnClickListener {
            findNavController().navigate(R.id.action_keranjangFragment_to_paymentFragment)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.rvCart?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        binding?.rvCart?.adapter = KeranjangAdapter(keranajngAdapter)
        super.onViewCreated(view, savedInstanceState)
    }

}