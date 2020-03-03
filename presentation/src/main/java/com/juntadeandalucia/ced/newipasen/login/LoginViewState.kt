package com.juntadeandalucia.ced.newipasen.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class LoginViewState : Parcelable {
    @Parcelize
    data class Login(var error: String = "",
                     var loginOk: Boolean = true,
                     var loading: Boolean = false,
                     var validationError: Boolean = false) : LoginViewState()
}