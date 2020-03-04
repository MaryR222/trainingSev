package com.juntadeandalucia.ced.newipasen.login

import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.juntadeandalucia.ced.newipasen.R
import com.juntadeandalucia.ced.newipasen.base.BaseFragment
import kotlinx.android.synthetic.main.login_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginViewState, LoginViewTransition>() {


    override val viewModel by viewModel<LoginViewModel>()

    override fun getLayout(): Int {
        return R.layout.login_fragment
    }

    override fun initViews() {

    }

    override fun manageState(state: LoginViewState) {

    }

    override fun manageTransition(transition: LoginViewTransition) {
        when(transition) {
            is LoginViewTransition.ValidationUserError -> {
                textInputUser?.error = getString(R.string.validation_error)
            }
            is LoginViewTransition.ValidationUserSuccess -> {
                textInputUser?.error = null
            }
            is LoginViewTransition.ValidationPasswordError -> {
                textInputPassword?.error = getString(R.string.validation_error)
            }
            is LoginViewTransition.ValidationUPasswordSuccess -> {
                textInputPassword.error = null
            }
            is LoginViewTransition.ErrorNoInternet -> {
                showToast(getString(R.string.error_no_internet))
            }
            is LoginViewTransition.ErrorServer -> {
                showToast(getString(R.string.error_server))
            }
            is LoginViewTransition.ErrorUnauthorized -> {
                showToast(getString(R.string.error_unauthorized))
            }
            is LoginViewTransition.ErrorUnknown -> {
                showToast(getString(R.string.error_unknown))
            }
            is LoginViewTransition.ErrorUserBloqued -> {
                showToast(getString(R.string.error_user_blocked))
            }
            is LoginViewTransition.ErrorUserInvalid -> {
                showToast(getString(R.string.error_invalid_user))
            }
            is LoginViewTransition.LoginSuccess -> {
                showToast(getString(R.string.success_login))
            }
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun initListeners() {
        etUsername?.addTextChangedListener { viewModel.validateUser(it.toString()) }
        etPassword?.addTextChangedListener { viewModel.validatePassword(it.toString()) }
        btnLogin?.setOnClickListener { viewModel.login(etUsername.text.toString(), etPassword.text.toString()) }
    }
}