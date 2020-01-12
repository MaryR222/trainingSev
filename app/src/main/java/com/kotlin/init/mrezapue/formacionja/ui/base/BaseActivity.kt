package com.kotlin.init.mrezapue.formacionja.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    abstract fun getLayout(): Int

    protected open fun initView() {

    }

    protected open fun initListener(){

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

}