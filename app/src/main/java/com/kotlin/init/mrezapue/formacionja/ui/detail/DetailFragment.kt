package com.kotlin.init.mrezapue.formacionja.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kotlin.init.mrezapue.formacionja.R
import kotlinx.android.synthetic.main.fragment_detail.*



class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)


        initView(args.name)
    }

    private fun initView(args: String) {
        tvWelcome.text =args
    }
}