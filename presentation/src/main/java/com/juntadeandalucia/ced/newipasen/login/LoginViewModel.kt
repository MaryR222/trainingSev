package com.juntadeandalucia.ced.newipasen.login

import com.juntadeandalucia.ced.commons.text.FieldValidator
import com.juntadeandalucia.ced.domain.RepositoryFailure
import com.juntadeandalucia.ced.domain.login.CheckLoginFailure
import com.juntadeandalucia.ced.domain.login.GetLogin
import com.juntadeandalucia.ced.domain.login.LoginError
import com.juntadeandalucia.ced.domain.login.LoginInput
import com.juntadeandalucia.ced.newipasen.base.BaseViewModel

class LoginViewModel(
    private val fieldValidator: FieldValidator,
    private val getLogin: GetLogin
) : BaseViewModel<LoginViewState, LoginViewTransition>() {

    private val state by lazy { viewState.value as? LoginViewState.Login ?: LoginViewState.Login() }

    fun validateUser(user: String) {
        if (fieldValidator.validateAliasLogin(user) || user.isEmpty()) {
            viewTransition.value = LoginViewTransition.ValidationUserSuccess
        } else {
            viewTransition.value = LoginViewTransition.ValidationUserError
        }
    }

    fun validatePassword(password: String) {
        if (fieldValidator.validatePasswordLogin(password) || password.isEmpty()) {
            viewTransition.value = LoginViewTransition.ValidationUPasswordSuccess
        } else {
            viewTransition.value = LoginViewTransition.ValidationPasswordError
        }
    }

    fun login(user: String, password: String) {
        if (fieldValidator.validateAliasLogin(user) && fieldValidator.validatePasswordLogin(password)) {
            state.loading = true
            viewState.value = state
            getLogin(LoginInput(user, password, "{\"version\":\"" + "11.8.3.4" + "\"}")) {
                state.loading = false
                viewState.value = state
                it.fold(::handleLoginError, ::handleSucces)
            }
        } else {
            validateUser(user)
            validatePassword(password)
        }
    }

    private fun handleLoginError(checkLoginError: CheckLoginFailure) {

        when (checkLoginError) {
            is CheckLoginFailure.Repository -> handleRepositoryError(checkLoginError.error)
            is CheckLoginFailure.Know -> when (checkLoginError.error) {
                is LoginError.UserBloqued -> {
                    viewTransition.value = LoginViewTransition.ErrorUserBloqued
                }
                is LoginError.UserIncorrect -> viewTransition.value =
                    LoginViewTransition.ErrorUserInvalid
            }
        }
    }

    private fun handleRepositoryError(error: RepositoryFailure) {

        when (error) {
            is RepositoryFailure.NoInternet -> {
                viewTransition.value = LoginViewTransition.ErrorNoInternet
            }
            is RepositoryFailure.ServerError -> {
                viewTransition.value = LoginViewTransition.ErrorServer
            }
            is RepositoryFailure.Unauthorized -> {
                viewTransition.value = LoginViewTransition.ErrorUnauthorized
            }
            is RepositoryFailure.Unknown -> {
                viewTransition.value = LoginViewTransition.ErrorUnknown
            }
        }
    }

    private fun handleSucces(unit: Unit) {
        viewTransition.value = LoginViewTransition.LoginSuccess
    }


}