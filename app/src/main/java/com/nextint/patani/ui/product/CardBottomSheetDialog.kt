package com.nextint.patani.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nextint.patani.R
import com.nextint.patani.databinding.ToCartBottomSheetBinding
import timber.log.Timber

class CardBottomSheetDialog : BottomSheetDialogFragment(), View.OnClickListener {
    private lateinit var viewModel : DetailProdukViewModel
    private var _bindingView : ToCartBottomSheetBinding? = null
    private val bindingView get() = _bindingView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _bindingView = ToCartBottomSheetBinding.inflate(inflater,container,false)
        Timber.i("onCreated called")
        viewModel = ViewModelProvider(this).get(DetailProdukViewModel::class.java)
        bindingView?.btnBeli?.setOnClickListener(this)
        bindingView?.btnMin?.setOnClickListener(this)
        bindingView?.btnPlus?.setOnClickListener(this)
        val getPrice = arguments?.getInt("prodPrice")
        viewModel.qty.observe(viewLifecycleOwner,{

            qty -> bindingView?.textQty?.text = qty.toString()
            val price =  qty * getPrice!!
            bindingView?.textPrice?.text = price.toString()
        })
        return bindingView?.root
    }

    override fun onStart() {
        Timber.i("onStart called")

        super.onStart()
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_plus -> {
                viewModel.qtyIncrement()
            }
            R.id.btn_min -> {
                viewModel.qtyDecrement()
            }
            R.id.btn_beli -> dismiss()
        }
    }
}

