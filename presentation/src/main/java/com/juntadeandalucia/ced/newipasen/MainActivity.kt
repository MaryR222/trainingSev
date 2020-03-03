package com.juntadeandalucia.ced.newipasen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.juntadeandalucia.ced.newipasen.base.BackPressedListener
import com.juntadeandalucia.ced.newipasen.base.BaseActivity
import com.juntadeandalucia.ced.newipasen.login.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction().add(R.id.main_content, LoginFragment()).commit()
    }

}