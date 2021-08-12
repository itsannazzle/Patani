package com.nextint.patani.ui.product

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.nextint.patani.R
import com.nextint.patani.core.local.AlmostPanenProduct
import com.nextint.patani.core.local.entity.content
import com.nextint.patani.databinding.FragmentDetailProdukBinding
import com.nextint.patani.ui.CardBottomSheetDialog
import com.nextint.patani.ui.product.DetailProdukFragmentArgs
import com.nextint.patani.ui.product.DetailProdukFragmentDirections
import com.nextint.patani.ui.adapter.ProductAdapterBasic
import timber.log.Timber

class DetailProdukFragment : Fragment() {
    private var _binding : FragmentDetailProdukBinding? = null
    private val binding get() = _binding
    private val bottomSheetDialog = CardBottomSheetDialog()
    private var root : View? = null
    private val recomendationProduct : ArrayList<AlmostPanenProduct> = arrayListOf()
    private lateinit var adapter : ProductAdapterBasic<AlmostPanenProduct>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailProdukBinding.inflate(inflater, container, false)
        root = binding?.root
        recomendationProduct.addAll(content.panenSebentarLagi)

        setHasOptionsMenu(true)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val items = listOf(R.array.satuan)
        val adapter = ArrayAdapter(requireContext(),R.layout.menu_dropdown,items)
        (binding?.filledExposedDropdown)?.setAdapter(adapter)*/
//        handleToolbar("Detail Produk")
        recomenProduct(recomendationProduct)
        binding?.btnBeli?.setOnClickListener {
            bottomSheetDialog.show(parentFragmentManager,"bottomSheet")
        }
        Timber.i("detail on view created")
        toolbarSetup()
    }

    override fun onStart() {
        Timber.i("detail onstart")
        super.onStart()
    }

    private fun recomenProduct(dataProduct : ArrayList<AlmostPanenProduct>){
        adapter = ProductAdapterBasic(dataProduct){
            findNavController().navigate(
                DetailProdukFragmentDirections.actionDetailProdukFragmentSelf(
                    2
                )
            )
        }
        binding?.rvRelatedProduct?.adapter = adapter
        binding?.rvRelatedProduct?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)

        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.itemShare)?.setVisible(false)
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun getShareIntent() : Intent {
        val args = arguments?.let { DetailProdukFragmentArgs.fromBundle(it) }
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_succes, args?.idProduct))
        return shareIntent
    }

    private fun shareSucess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.keranjangFragment -> NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
            R.id.itemShare -> shareSucess()
        }
        return  super.onOptionsItemSelected(item)
    }

    private fun toolbarSetup() {
        binding?.toolbar?.toolbarLayout?.apply {
            this.title = "Detail Product"
            navigationIcon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_arrow_back_24)
            setNavigationOnClickListener { findNavController().popBackStack() }
            background = ContextCompat.getDrawable(requireContext(),R.color.primary)
            inflateMenu(R.menu.overflow_menu)
           // popupTheme = R.style.ThemeOverlay_AppCompat_ActionBar
            menu.findItem(R.id.keranjangFragment).setOnMenuItemClickListener {
                    findNavController().navigate(DetailProdukFragmentDirections.actionDetailProdukFragmentToKeranjangFragment())
                    return@setOnMenuItemClickListener true
            }
            menu.findItem(R.id.itemShare).setOnMenuItemClickListener {
                val mimeType = "text/plain"
                ShareCompat.IntentBuilder
                        .from(requireActivity())
                        .setType(mimeType)
                        .setChooserTitle(getString(R.string.share_succes))
                        .setText(getString(R.string.share_succes))
                        .startChooser()
                return@setOnMenuItemClickListener true
            }


        }

        binding?.toolbar?.toolbarLayout?.setOnMenuItemClickListener {
            null == getShareIntent().resolveActivity(requireActivity().packageManager)
        }



//        binding?.toolbar?.toolbarLayout?.setOnMenuItemClickListener {
//            MenuItem.OnMenuItemClickListener { item ->
//                when (item.itemId) {
//                    R.id.keranjangFragment -> NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                    R.id.itemShare -> shareSucess()
//                    else ->
//                }
//
//            }
//        }

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }


}