package org.devdias.simpleappnyt.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.devdias.simpleappnyt.data.archive.ArchiveResponse
import org.devdias.simpleappnyt.data.archive.ArchiveResult
import org.devdias.simpleappnyt.data.articles.ArticlesResponse
import org.devdias.simpleappnyt.data.movieReviews.MovieReviewsResponse
import org.devdias.simpleappnyt.data.searchArticle.SearchResponse
import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.repo.Repository
import retrofit2.Call

class MovieReviewsViewModel(private val repository: Repository): ViewModel(), Observable {
    var list: MutableLiveData<Call<MovieReviewsResponse>> = MutableLiveData()

    fun getMovieReviews(keyword: String) {
        viewModelScope.launch {
            val response = repository.getSearchMovieReviews(keyword)
            list.value = response
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}