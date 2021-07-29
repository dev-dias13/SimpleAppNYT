package org.devdias.simpleappnyt.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.ArchiveViewModel
import org.devdias.simpleappnyt.viewmodel.MainViewModel

class MainViewModelFactory(): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}