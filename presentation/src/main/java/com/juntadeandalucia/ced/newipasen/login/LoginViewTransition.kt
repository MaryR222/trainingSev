package com.juntadeandalucia.ced.newipasen.login

sealed class LoginViewTransition {
    object ValidationUserError: LoginViewTransition()
    object ValidationPasswordError: LoginViewTransition()
    object ValidationUserCorrect: LoginViewTransition()
    object ValidationUPasswordCorrect: LoginViewTransition()
}