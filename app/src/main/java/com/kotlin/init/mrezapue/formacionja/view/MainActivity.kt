package com.kotlin.init.mrezapue.formacionja.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.init.mrezapue.formacionja.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        rvElements?.adapter = MainAdapter()

        viewModel.stateTitle.observeForever {
            it?.let { title ->
                tvTitle?.text = title
            }
        }

        viewModel.stateList.observe(this, Observer {
            it?.let { pagedList ->
                (rvElements?.adapter as? MainAdapter?)?.submitList(pagedList)
            }
        })
    }
}
