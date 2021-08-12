package com.nextint.patani.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nextint.patani.R
import com.nextint.patani.ViewModelFactory
import com.nextint.patani.databinding.FragmentLoginBinding
import com.nextint.patani.databinding.FragmentWelcomeBinding
import timber.log.Timber

class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val viewModel : LoginViewModel by viewModels {
        ViewModelFactory.getInstance(requireActivity())
    }
    private val binding get() = _binding
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
//        val email1 = binding?.edtEmail?.text.toString()
//        val password1 = binding?.edtPass?.text.toString()
//        Timber.i(email1)
//        Timber.i(password1)
        Timber.i(" onCreatedView")
        root = binding?.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.i(" onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        binding?.btnDaftar?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_daftarFragment)
        }



        binding?.btnMasuk?.setOnClickListener {
            val email = binding?.edtEmail?.text.toString().trim()
            val password = binding?.edtPass?.text.toString().trim()
            Timber.i(email)
            Timber.i(password)
            viewModel.loginValidation(email,password).observe(viewLifecycleOwner,{
                    login ->


                Timber.i("ini login $login")
                if (login !== null) {
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                } else {
                    Toast.makeText(requireContext(),"Login failed", Toast.LENGTH_SHORT).show()
                }
            })
        }
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = R.string.masuk.toString()
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        root = null
    }

}