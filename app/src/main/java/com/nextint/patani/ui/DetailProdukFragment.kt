package com.nextint.patani.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
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
        handleToolbar("Detail Produk")
    }

    private fun handleToolbar (title : String) {
        binding?.toolbarT?.toolbarLayout?.apply {
            this.title = title
            navigationIcon = ContextCompat.getDrawable(context,R.drawable.ic_baseline_arrow_back_24)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            menu.findItem(R.id.cart).setOnMenuItemClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                return@setOnMenuItemClickListener true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }

}