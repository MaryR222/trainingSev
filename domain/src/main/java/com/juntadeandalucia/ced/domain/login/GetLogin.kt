package com.juntadeandalucia.ced.domain.login

import com.juntadeandalucia.ced.commons.data.types.Either
import com.juntadeandalucia.ced.domain.base.BaseUseCase

class GetLogin(private val loginRepository: LoginRepository) : BaseUseCase<CheckLoginFailure, Unit, LoginInput>() {

    override suspend fun run(params: LoginInput): Either<CheckLoginFailure, Unit> {
        return loginRepository.login(params)
    }
}