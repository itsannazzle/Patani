package com.nextint.patani

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nextint.patani.core.PataniRepository
import com.nextint.patani.ui.login.LoginViewModel
import com.nextint.patani.ui.register.DaftarViewModel
import com.nextint.patani.utils.Injection

class ViewModelFactory private constructor(private val pataniRepository: PataniRepository) : ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null
        fun getInstance(context: Context) : ViewModelFactory =
            instance?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> return LoginViewModel(pataniRepository) as T
            modelClass.isAssignableFrom(DaftarViewModel::class.java) -> return DaftarViewModel(pataniRepository) as T
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}