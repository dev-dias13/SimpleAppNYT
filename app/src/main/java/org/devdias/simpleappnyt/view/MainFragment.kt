package org.devdias.simpleappnyt.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.databinding.FragmentMainBinding
import org.devdias.simpleappnyt.viewmodel.MainViewModel
import org.devdias.simpleappnyt.viewmodel.factory.MainViewModelFactory

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val application = requireNotNull(this.activity).application
        // Inflate the layout for this fragment
        val maindatabinding = FragmentMainBinding.inflate(inflater, container, false)
        val factory = MainViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        maindatabinding.mainViewModel = viewModel
        maindatabinding.lifecycleOwner = this

        viewModel.navigateTimesWire.observe(viewLifecycleOwner, Observer{ navigateTimesWire->
            if(navigateTimesWire==true){
                findNavController().navigate(R.id.action_mainFragment_to_timesWireFragment)
            }
        })

        viewModel.navigateSearchArticle.observe(viewLifecycleOwner, Observer{ navigateTimesWire->
            if(navigateTimesWire==true){
                findNavController().navigate(R.id.action_mainFragment_to_searchArticleFragment)
            }
        })

        viewModel.navigateArchive.observe(viewLifecycleOwner, Observer{ navigateArchive->
            if(navigateArchive==true){
                findNavController().navigate(R.id.action_mainFragment_to_archiveFragment)
            }
        })

        viewModel.navigateArticle.observe(viewLifecycleOwner, Observer{ navigateArticle->
            if(navigateArticle==true){
                findNavController().navigate(R.id.action_mainFragment_to_popularArticlesFragment)
            }
        })

        viewModel.navigateBooks.observe(viewLifecycleOwner, Observer{ navigateBooks->
            if(navigateBooks==true){
                findNavController().navigate(R.id.action_mainFragment_to_booksFragment)
            }
        })

        viewModel.navigateMovieReviews.observe(viewLifecycleOwner, Observer{ navigateBooks->
            if(navigateBooks==true){
                findNavController().navigate(R.id.action_mainFragment_to_movieReviewsFragment)
            }
        })

        viewModel.navigateTopStories.observe(viewLifecycleOwner, Observer{ navigateBooks->
            if(navigateBooks==true){
                findNavController().navigate(R.id.action_mainFragment_to_topStoriesFragment)
            }
        })

        return maindatabinding.root
    }
}