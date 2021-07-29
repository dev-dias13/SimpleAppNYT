package org.devdias.simpleappnyt.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.devdias.simpleappnyt.data.books.BookReviewsResponse
import org.devdias.simpleappnyt.data.books.BookReviewsResult
import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.view.BooksFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel (private val repository: Repository): ViewModel(), Observable {

    var list: MutableLiveData<Call<BookReviewsResponse>> = MutableLiveData()

    var onSuccess: MutableLiveData<Boolean> = MutableLiveData()
    var response = repository.getBooks("")

    init {
        onSuccess.value = false
    }

    fun getBookReviews(author: String) {
            response = repository.getBooks(author)
            list.value = response

    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}