package com.juntadeandalucia.ced.domain.login

import com.juntadeandalucia.ced.domain.RepositoryFailure

sealed class CheckLoginFailure {

    data class Repository(val error: RepositoryFailure) : CheckLoginFailure()

    data class Know(val error: LoginError) : CheckLoginFailure()
}