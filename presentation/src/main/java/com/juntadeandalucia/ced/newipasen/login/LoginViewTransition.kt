package com.juntadeandalucia.ced.newipasen.login

sealed class LoginViewTransition {
    object ValidationUserError: LoginViewTransition()
    object ValidationPasswordError: LoginViewTransition()
    object ValidationUserSuccess: LoginViewTransition()
    object ValidationUPasswordSuccess: LoginViewTransition()
    object ErrorUserBloqued : LoginViewTransition()
    object ErrorUserInvalid : LoginViewTransition()
    object ErrorNoInternet : LoginViewTransition()
    object ErrorServer : LoginViewTransition()
    object ErrorUnauthorized : LoginViewTransition()
    object ErrorUnknown : LoginViewTransition()
    object LoginSuccess : LoginViewTransition()
}