package org.devdias.simpleappnyt.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.devdias.simpleappnyt.data.articles.ArticlesResponse
import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.repo.Repository
import retrofit2.Call

class PopularArticlesViewModel (private val repository: Repository): ViewModel(), Observable {
    var list: MutableLiveData<Call<ArticlesResponse>> = MutableLiveData()

    fun getPopularArticles() {
        viewModelScope.launch {
            val response = repository.getPopularArticles()
            list.value = response
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}