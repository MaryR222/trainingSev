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
            is LoginViewTransition.ValidationUserCorrect -> {
                textInputUser?.error = null
            }
            is LoginViewTransition.ValidationPasswordError -> {
                Toast.makeText(context, getString(R.string.validation_error), Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun initListeners() {
        etUsername?.addTextChangedListener { viewModel.validateUser(it.toString()) }
        etPassword?.addTextChangedListener { viewModel.validatePassword(it.toString()) }
    }
}