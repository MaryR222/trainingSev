package com.kotlin.init.mrezapue.formacionja.ui.movie

import androidx.lifecycle.*
import com.kotlin.init.mrezapue.formacionja.common.SingleLiveEvent
import com.kotlin.init.mrezapue.formacionja.model.Movie
import com.kotlin.init.mrezapue.formacionja.model.MovieRpository
import kotlinx.coroutines.launch

class MovieViewModel (private val movieRepository: MovieRpository): ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val movies: List<Movie>): ViewState()
    }

    private val _navigateToMovie = SingleLiveEvent<Int>()
    val navigateToMovie: LiveData<Int> get() = _navigateToMovie

    private  val _state = MutableLiveData<ViewState>()


    val state : LiveData<ViewState>
        get(){
            if( _state.value == null) refresh()
            return _state
        }

    private fun refresh() {
        viewModelScope.launch {
            _state.value = ViewState.Loading
            val movieResponse = movieRepository.getListMoview()
            val movieList = movieResponse.body()?.results
            _state.value = ViewState.ShowList(movieList?: emptyList())
        }
    }



    class MovieListViewModelFactory(private val repository: MovieRpository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T
                = MovieViewModel(repository) as T
    }


    fun onMovieClicked(movie: Movie) {
        _navigateToMovie.value = movie.id
    }
}