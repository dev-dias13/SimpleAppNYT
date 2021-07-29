package org.devdias.simpleappnyt.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel (): ViewModel(), Observable {
    private var _navigateTimesWire: MutableLiveData<Boolean> = MutableLiveData()
    val navigateTimesWire: MutableLiveData<Boolean>
        get() = _navigateTimesWire
    private var _navigateArchive: MutableLiveData<Boolean> = MutableLiveData()
    val navigateArchive: MutableLiveData<Boolean>
        get() = _navigateArchive
    private var _navigateArticle: MutableLiveData<Boolean> = MutableLiveData()
    val navigateArticle: MutableLiveData<Boolean>
        get() = _navigateArticle
    private var _navigateBooks: MutableLiveData<Boolean> = MutableLiveData()
    val navigateBooks: MutableLiveData<Boolean>
        get() = _navigateBooks
    private var _navigateSearchArticle: MutableLiveData<Boolean> = MutableLiveData()
    val navigateSearchArticle: MutableLiveData<Boolean>
        get() = _navigateSearchArticle
    private var _navigateMovieReviews: MutableLiveData<Boolean> = MutableLiveData()
    val navigateMovieReviews: MutableLiveData<Boolean>
        get() = _navigateMovieReviews
    private var _navigateTopStories: MutableLiveData<Boolean> = MutableLiveData()
    val navigateTopStories: MutableLiveData<Boolean>
        get() = _navigateTopStories
    init {
        _navigateTimesWire.value = false
        _navigateArchive.value = false
        _navigateArticle.value = false
        _navigateBooks.value = false
        _navigateSearchArticle.value = false
        _navigateMovieReviews.value = false
        _navigateTopStories.value = false
    }

    fun getTimesWire() {
        _navigateTimesWire.value = true
    }
    fun getArchive() {
        _navigateArchive.value = true
    }
    fun getArticle() {
        _navigateArticle.value = true
    }
    fun getBooks() {
        _navigateBooks.value = true
    }
    fun getSearchArticles() {
        _navigateSearchArticle.value = true
    }
    fun getMovieReviews() {
        _navigateMovieReviews.value = true
    }
    fun getTopStories() {
        _navigateTopStories.value = true
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}