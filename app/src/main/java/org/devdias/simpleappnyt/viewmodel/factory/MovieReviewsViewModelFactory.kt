package org.devdias.simpleappnyt.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.ArchiveViewModel
import org.devdias.simpleappnyt.viewmodel.MovieReviewsViewModel

class MovieReviewsViewModelFactory(private  val repository: Repository
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MovieReviewsViewModel::class.java)){
            return MovieReviewsViewModel(repository) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}