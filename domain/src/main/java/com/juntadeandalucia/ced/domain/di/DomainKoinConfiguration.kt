package com.juntadeandalucia.ced.domain.di

import com.juntadeandalucia.ced.domain.login.GetLogin
import org.koin.dsl.module

class DomainKoinConfiguration {

    fun getModule() = module{
        //User case
        factory { GetLogin(get()) }
    }
}