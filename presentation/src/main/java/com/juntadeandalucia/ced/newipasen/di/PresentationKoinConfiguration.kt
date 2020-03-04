package com.juntadeandalucia.ced.newipasen.di

import com.juntadeandalucia.ced.commons.text.FieldValidator
import com.juntadeandalucia.ced.newipasen.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PresentationKoinConfiguration {

    fun getModule() = module{

        viewModel { LoginViewModel(get(), get()) }
//        viewModel { WelcomeViewModel() }
    }
}