package com.nextint.patani.ui.login

import androidx.lifecycle.ViewModel
import com.nextint.patani.core.PataniRepository

class LoginViewModel(private val pataniRepository: PataniRepository) : ViewModel() {
    fun loginValidation(email : String, password : String) = pataniRepository.loginValidation(email, password)
}