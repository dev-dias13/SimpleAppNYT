package org.devdias.simpleappnyt.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.repo.Repository
import retrofit2.Call

class TimesWireViewModel (private val repository: Repository): ViewModel(), Observable {
    var list: MutableLiveData<Call<TimesWireResponse>> = MutableLiveData()

    fun getTimesWire() {
        viewModelScope.launch {
            val response = repository.getTimesWire()
            list.value = response
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}