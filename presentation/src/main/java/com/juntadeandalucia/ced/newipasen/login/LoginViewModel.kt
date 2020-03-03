package com.juntadeandalucia.ced.newipasen.login

import com.juntadeandalucia.ced.commons.text.FieldValidator
import com.juntadeandalucia.ced.newipasen.base.BaseViewModel

class LoginViewModel (private val fieldValidator: FieldValidator) : BaseViewModel<LoginViewState, LoginViewTransition>() {

    private val state by lazy { viewState.value as? LoginViewState.Login ?: LoginViewState.Login() }

    fun validateUser(user: String) {
        if (!fieldValidator.validateEmail(user)) {
            viewTransition.value = LoginViewTransition.ValidationUserError
        } else {
            viewTransition.value = LoginViewTransition.ValidationUserCorrect
        }
    }

    fun validatePassword(password: String) {
        if (!fieldValidator.validatePasswordLogin(password)) viewTransition.value = LoginViewTransition.ValidationPasswordError
    }


}