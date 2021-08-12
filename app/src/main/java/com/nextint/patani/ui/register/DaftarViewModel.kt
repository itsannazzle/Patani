package com.nextint.patani.ui.register

import androidx.lifecycle.ViewModel
import com.nextint.patani.core.PataniRepository
import com.nextint.patani.core.local.entity.UserRegisterEntity

class DaftarViewModel(private val pataniRepository: PataniRepository) : ViewModel() {
    fun postRegister(userRegisterEntity: UserRegisterEntity) = pataniRepository.postRegistration(userRegisterEntity)
}