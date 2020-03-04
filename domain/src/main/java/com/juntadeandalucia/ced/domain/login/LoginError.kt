package com.juntadeandalucia.ced.domain.login

sealed class LoginError {

    object UserIncorrect : LoginError()

    object UserBloqued : LoginError()
}
