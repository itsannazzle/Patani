package com.nextint.patani.ui.register

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.nextint.patani.R
import com.nextint.patani.ViewModelFactory
import com.nextint.patani.core.local.entity.UserRegisterEntity
import com.nextint.patani.databinding.FragmentDaftarBinding

class DaftarFragment : Fragment() {
    private var _binding : FragmentDaftarBinding? = null
    private val viewModel : DaftarViewModel by viewModels {
        ViewModelFactory.getInstance(requireActivity())
    }
   private lateinit var userRegisterEntity: UserRegisterEntity
    private val binding get() = _binding
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDaftarBinding.inflate(inflater, container, false)
        root = binding?.root

        binding?.btnDaftar?.setOnClickListener {
            binding?.progressBar2?.visibility = View.VISIBLE
            findNavController().navigate(R.id.action_daftarFragment_to_regisBerhasilFragment)
        }
//        val inputedPassword = binding?.regEdPass?.text.toString()
//        val reinputedPassword = binding?.regEdConfm?.text.toString()
//
//        if (inputedPassword !== reinputedPassword) binding?.inputRepassword?.helperText = "Password yang dimasukan tidak sama"
//
//
//        userRegisterEntity = UserRegisterEntity(binding?.regEdEmail?.text.toString(),binding?.regEdTelp?.text.toString(),inputedPassword)
//        binding?.btnDaftar?.setOnClickListener {
//            viewModel.postRegister(userRegisterEntity).observe(viewLifecycleOwner) { state ->
//                if (state) Toast.makeText(requireContext(), "berhasil daftra", Toast.LENGTH_SHORT)
//                    .show() else Toast.makeText(requireContext(), "gagal", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
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
            title = getString(R.string.daftar)
            navigationIcon = ContextCompat.getDrawable(requireContext(),R.drawable.ic_customback)
            setNavigationOnClickListener { findNavController().popBackStack() }
            popupTheme = R.style.Theme_MaterialComponents_DayNight_DarkActionBar
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        root = null
    }

}