package com.nextint.patani.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nextint.patani.R
import com.nextint.patani.core.local.AlmostPanenProduct
import com.nextint.patani.core.local.KategoriProduct
import com.nextint.patani.core.local.content
import com.nextint.patani.databinding.FragmentHomeBinding
import com.nextint.patani.ui.adapter.KategoriAdapter
import com.nextint.patani.ui.adapter.ProductAdapterBasic


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding
    private var root : View? = null
    private val kategoriAdapter : ArrayList<KategoriProduct> = arrayListOf()
    private val dataAlmostPanen : ArrayList<AlmostPanenProduct> = arrayListOf()
    private lateinit var produkAdapter : ProductAdapterBasic<AlmostPanenProduct>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        root = binding?.root
        kategoriAdapter.addAll(content.kategoriContent)
        dataAlmostPanen.addAll(content.panenSebentarLagi)
        setHasOptionsMenu(true)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rvKategori?.layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.HORIZONTAL, false)
        binding?.rvKategori?.adapter = KategoriAdapter(kategoriAdapter)
        panenSoon(dataAlmostPanen)
        diskonProduct(dataAlmostPanen)
        val navController = requireActivity().findNavController(R.id.fragment)
        binding?.navView?.let { NavigationUI.setupWithNavController(it, navController) }
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
        menu.findItem(R.id.itemShare).setVisible(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun panenSoon(dataProduct : ArrayList<AlmostPanenProduct>){
        produkAdapter = ProductAdapterBasic(dataProduct){
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailProdukFragment(2))
        }
        binding?.rvProduk?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding?.rvProduk?.adapter = produkAdapter
    }

    private fun diskonProduct(dataProduct : ArrayList<AlmostPanenProduct>){
        produkAdapter = ProductAdapterBasic(dataProduct){
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailProdukFragment(1))
        }
        binding?.rvPromo?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding?.rvPromo?.adapter = produkAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }
}