package org.devdias.simpleappnyt.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.BooksViewModel
import org.devdias.simpleappnyt.viewmodel.SearchArticleViewModel

class SearchArticleViewModelFactory(private  val repository: Repository
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SearchArticleViewModel::class.java)){
            return SearchArticleViewModel(repository) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}