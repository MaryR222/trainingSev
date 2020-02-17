package com.kotlin.init.mrezapue.formacionja.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.kotlin.init.mrezapue.formacionja.R

import com.kotlin.init.mrezapue.formacionja.model.MovieRpository
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : Fragment() {


    private lateinit var  viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter


    fun getLayout(): Int = R.layout.activity_main

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(getLayout(), container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this,
            MovieViewModel.MovieListViewModelFactory(MovieRpository(context)))[MovieViewModel::class.java]


        initList()
        initObserver()

    }


    private fun initObserver() {
        viewModel.state.observe(this, Observer  (::updateList) )
        viewModel.navigateToMovie.observe(this, Observer { navigate(it) })

    }

    private fun navigate(it: Int?) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment("PELICULA",""))
    }

    private fun updateList(state: MovieViewModel.ViewState) {
        progress.visibility = if (state is MovieViewModel.ViewState.Loading) View.VISIBLE else View.GONE

        when(state){
            is MovieViewModel.ViewState.ShowList -> {

                adapter.movies = state.movies
                adapter.notifyDataSetChanged()

            }
           
        }
    }


    private fun initList() {

        adapter = MovieAdapter(viewModel::onMovieClicked)
        rvMovies.adapter = adapter

    }



}
