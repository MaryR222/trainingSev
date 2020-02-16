package com.kotlin.init.mrezapue.formacionja.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.init.mrezapue.formacionja.R
import com.kotlin.init.mrezapue.formacionja.model.MovieRpository
import com.kotlin.init.mrezapue.formacionja.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    private lateinit var  viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this,
            MovieViewModel.MovieListViewModelFactory(MovieRpository(application)))[MovieViewModel::class.java]
        initList()
        initObserver()
    }

    private fun initObserver() {
        viewModel.state.observe(this, Observer  (::updateList) )

    }

    private fun updateList(state: MovieViewModel.ViewState) {
        progress.visibility = if (state is MovieViewModel.ViewState.Loading) View.VISIBLE else View.GONE

        when(state){
            is MovieViewModel.ViewState.ShowList -> {
                adapter.movies = state.movies
                adapter.notifyDataSetChanged()

            }
            is MovieViewModel.ViewState.Navegation ->{
               // startActivity(Intent (this, MoviewDetail::class.java).putExtra(MoviewDetail::class.java.canonicalName, state.movie))
            }
        }
    }


    private fun initList() {

        adapter = MovieAdapter()
        rvMovies.adapter = adapter

    }

}
