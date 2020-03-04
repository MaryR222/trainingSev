package com.juntadeandalucia.ced.data.login

import com.juntadeandalucia.ced.data.remote.NoContentResponse
import com.juntadeandalucia.ced.data.remote.ParsedResponse
import com.juntadeandalucia.ced.data.remote.ResponseParse
import com.juntadeandalucia.ced.data.remote.ResponseParse.Companion.REQUEST_OP_USER_BLOQUED
import com.juntadeandalucia.ced.data.remote.ResponseParse.Companion.REQUEST_OP_USER_ERROR
import com.juntadeandalucia.ced.domain.login.LoginError
import okhttp3.ResponseBody
import retrofit2.Response
import kotlin.reflect.KClass

class LoginRemoteDataSource(
    private val loginService: LoginService,
    private val responseParser: ResponseParse
) {

    suspend fun checkLogin(loginRequest: LoginRequest): ParsedResponse<LoginError, NoContentResponse> {
        val response: Response<ResponseBody> = loginService.checkLogin(
            loginRequest.user,
            loginRequest.password,
            loginRequest.version
        ).await()

        return responseParser.parseNoContentResponse(response,getKnownErrorClassesByErrorCodes())
    }


    private fun getKnownErrorClassesByErrorCodes(): Map<String, KClass<out LoginError>> = mapOf(
        REQUEST_OP_USER_ERROR to LoginError.UserIncorrect::class,
        REQUEST_OP_USER_BLOQUED to LoginError.UserBloqued::class
    )

}