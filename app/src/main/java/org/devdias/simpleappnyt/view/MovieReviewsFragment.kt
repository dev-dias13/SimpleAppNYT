package org.devdias.simpleappnyt.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.adapter.ArchiveAdapter
import org.devdias.simpleappnyt.adapter.MovieReviewsAdapter
import org.devdias.simpleappnyt.data.archive.DocResult
import org.devdias.simpleappnyt.data.movieReviews.MovieReviewsResponse
import org.devdias.simpleappnyt.data.movieReviews.MovieReviewsResult
import org.devdias.simpleappnyt.data.searchArticle.SearchResponse
import org.devdias.simpleappnyt.databinding.FragmentMovieReviewsBinding
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.MovieReviewsViewModel
import org.devdias.simpleappnyt.viewmodel.factory.MovieReviewsViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieReviewsFragment : Fragment() {
    private lateinit var viewModel: MovieReviewsViewModel
    private lateinit var movieReviewsViewModelBinding: FragmentMovieReviewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val repository = Repository()
        movieReviewsViewModelBinding = FragmentMovieReviewsBinding.inflate(inflater, container, false)
        val factory = MovieReviewsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MovieReviewsViewModel::class.java)
        movieReviewsViewModelBinding.movieReviewsViewModel = viewModel
        movieReviewsViewModelBinding.lifecycleOwner = this
        movieReviewsViewModelBinding.recyclerViewMovieReviews.layoutManager = LinearLayoutManager(context)
        // Back Navigation
        movieReviewsViewModelBinding.floatingActionButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_movieReviewsFragment_to_mainFragment)
        })
        movieReviewsViewModelBinding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getMovieReviews(query)
                movieReviewsViewModelBinding.progressBar.visibility = View.VISIBLE
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                //viewModel.getSearch(newText)
                return false
            }
        })
        viewModel.list.observe(viewLifecycleOwner, Observer { response ->
            response.clone().enqueue(object : Callback<MovieReviewsResponse> {
                override fun onResponse(call: Call<MovieReviewsResponse>, response: Response<MovieReviewsResponse>) {
                    when {
                        response.isSuccessful -> {
                            val mainResponse = response.body()?.getResults()
                            //snackBar("success")
                            Log.d("Success: ", "Success after get main response")

                            if (mainResponse != null) {
                                setupRecyclerView(mainResponse)
                                movieReviewsViewModelBinding.progressBar.visibility = View.GONE
                                Log.d("Success: ", "Success after setup on recycler view")

                            }
                        }
                        else -> {
                            print(response.body().toString())
                            snackBar("error: $response")
                            Log.d("Error: ", response.message())
                        }
                    }
                }
                override fun onFailure(call: Call<MovieReviewsResponse>, t: Throwable) {
                    Log.d("Error:", t.localizedMessage)
                    print(t.localizedMessage)
                }
            })
        })
        return movieReviewsViewModelBinding.root

    }
    private fun snackBar(message: String ) {
        view?.let { it ->
            Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                .show()
        }
    }

    private fun setupRecyclerView(Response: List<MovieReviewsResult>) {
        val adapter = MovieReviewsAdapter(Response)
        movieReviewsViewModelBinding.recyclerViewMovieReviews.adapter = adapter
    }
}