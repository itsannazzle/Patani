package com.nextint.patani.ui.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nextint.patani.R
import com.nextint.patani.databinding.FragmentPaymentBinding
import com.nextint.patani.ui.adapter.KeranjangAdapter
import com.nextint.patani.ui.adapter.PaymentAdapter


class PaymentFragment : Fragment() {
    private var _binding : FragmentPaymentBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        val imgUrl = arrayListOf("https://1000logos.net/wp-content/uploads/2021/03/GoPay-logo.png",
        "https://1.bp.blogspot.com/-Iq0Ztu117_8/XzNYaM4ABdI/AAAAAAAAHA0/MabT7B02ErIzty8g26JvnC6cPeBZtATNgCLcBGAsYHQ/s1000/logo-ovo.png",
        "https://1.bp.blogspot.com/-EmJLucvvYZw/X0Gm1J37spI/AAAAAAAAC0s/Dyq4-ko9Eecvg0ostmowa2RToXZITkbcQCLcBGAsYHQ/w1200-h630-p-k-no-nu/Logo%2BShopeePay.png",
        "https://harianrakyataceh.com/wp-content/uploads/2021/07/beli-saldo-paypal-via-linkaja.png")
        binding?.rvpayment?.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        binding?.rvpayment?.adapter = PaymentAdapter(imgUrl)

        return binding?.root
    }

}