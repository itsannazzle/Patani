package com.nextint.patani.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nextint.patani.R
import com.nextint.patani.databinding.ToCartBottomSheetBinding

class CardBottomSheetDialog : BottomSheetDialogFragment(), View.OnClickListener {
    private var _bindingView : ToCartBottomSheetBinding? = null
    private val bindingView get() = _bindingView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _bindingView = ToCartBottomSheetBinding.inflate(inflater,container,false)
        bindingView?.btnBeli?.setOnClickListener(this)
        bindingView?.btnMin?.setOnClickListener(this)
        bindingView?.btnPlus?.setOnClickListener(this)
        return bindingView?.root
    }


    override fun onClick(v: View?) {
        val totalQty = bindingView?.textQty
        var sumOfQty = 0
        when(v?.id){
            R.id.btn_plus -> {
                sumOfQty++
                totalQty?.text = sumOfQty.toString()
            }
            R.id.btn_min -> {
                if (sumOfQty != 0) {
                    sumOfQty--
                    totalQty?.text = sumOfQty.toString()
                } else totalQty?.text = sumOfQty.toString()
            }
            R.id.btn_beli -> dismiss()

        }
    }
}

