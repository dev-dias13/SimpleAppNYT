package org.devdias.simpleappnyt.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.PopularArticlesViewModel

class PopularArticlesViewModelFactory(private  val repository: Repository
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PopularArticlesViewModel::class.java)){
            return PopularArticlesViewModel(repository) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}