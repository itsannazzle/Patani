package com.nextint.patani.ui.home

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
import com.nextint.patani.core.local.entity.content
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

    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
        menu.findItem(R.id.itemShare).setVisible(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun panenSoon(dataProduct : ArrayList<AlmostPanenProduct>){
        val mBundle = Bundle()
        for(data in dataProduct){
            mBundle.putString(EXTRA_TITLE,data.title)
            mBundle.putString(EXTRA_PRICE,data.price)
            mBundle.putString(EXTRA_DESC,data.desc)
            mBundle.putString(EXTRA_LOCATION,data.location)
            mBundle.putString(EXTRA_IMG,data.image)
            mBundle.putString(EXTRA_WAKTUPANEN,data.waktuPanen)
        }

        produkAdapter = ProductAdapterBasic(dataProduct){
//            findNavController().navigate(
//                HomeFragmentDirections.actionHomeFragmentToDetailProdukFragment(mBundle
//                )
//            )
            findNavController().navigate(R.id.action_homeFragment_to_detailProdukFragment,mBundle)
        }
//        produkAdapter = ProductAdapterBasic(dataProduct){
//            val intent = Intent(requireActivity(),DetailProdukFragment::class.java)
//            intent.putExtra(EXTRA_DATA_DETAIL,dataProduct)
//            startActivity(intent)
//        }

        binding?.rvProduk?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding?.rvProduk?.adapter = produkAdapter
    }

    private fun diskonProduct(dataProduct : ArrayList<AlmostPanenProduct>){
        produkAdapter = ProductAdapterBasic(dataProduct){
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailProdukFragment(
                    1
                )
            )
        }
        binding?.rvPromo?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding?.rvPromo?.adapter = produkAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }
    companion object{
        const val EXTRA_DATA_DETAIL = "EXTRA DATA"
        const val EXTRA_ID = "EXTRA ID"
        const val EXTRA_TITLE = "EXTRA TITLE"
        const val EXTRA_DESC = "EXTRA DESC"
        const val EXTRA_PRICE = "EXTRA PRICE"
        const val EXTRA_WAKTUPANEN = "EXTRA WAKTUPANEN"
        const val EXTRA_IMG = "EXTRA IMG"
        const val EXTRA_LOCATION = "EXTRA LOCATION"

    }
}