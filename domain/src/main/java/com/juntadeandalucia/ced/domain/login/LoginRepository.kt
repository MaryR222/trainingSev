package com.juntadeandalucia.ced.domain.login

import com.juntadeandalucia.ced.commons.data.types.Either

interface LoginRepository {
    suspend fun login(params: LoginInput): Either<CheckLoginFailure, Unit>
}