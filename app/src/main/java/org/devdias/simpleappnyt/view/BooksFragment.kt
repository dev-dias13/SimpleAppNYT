package org.devdias.simpleappnyt.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.adapter.BooksAdapter
import org.devdias.simpleappnyt.data.books.BookReviewsResponse
import org.devdias.simpleappnyt.data.books.BookReviewsResult
import org.devdias.simpleappnyt.databinding.FragmentBooksBinding
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.BooksViewModel
import org.devdias.simpleappnyt.viewmodel.factory.BooksViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksFragment : Fragment() {
    private lateinit var viewModel: BooksViewModel
    private lateinit var booksViewModelBinding: FragmentBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val repository = Repository()
        booksViewModelBinding = FragmentBooksBinding.inflate(inflater, container, false)
        val factory = BooksViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(BooksViewModel::class.java)
        booksViewModelBinding.booksViewModel = viewModel
        booksViewModelBinding.lifecycleOwner = this
        booksViewModelBinding.recyclerViewBookReviews.layoutManager = LinearLayoutManager(context)
        //Back navigation
        booksViewModelBinding.floatingActionButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_booksFragment_to_mainFragment)
        })

        //Query search text submit
        booksViewModelBinding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                //Progress Bar visibility
                booksViewModelBinding.progressBar.visibility = View.VISIBLE
                if (query.contains(" ")) {
                    query.replace(" ", "+")
                    //Call getTimesWire function from viewModel
                    viewModel.getBookReviews(query)
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        //list observe
        listObserveFromViewModel()
        return booksViewModelBinding.root
    }

    //List observe func
    private fun listObserveFromViewModel() {
        viewModel.list.observe(viewLifecycleOwner, Observer { response ->
            response.clone().enqueue(object : Callback<BookReviewsResponse> {
                override fun onResponse(call: Call<BookReviewsResponse>, response: Response<BookReviewsResponse>) {
                    when {response.isSuccessful -> {
                            val mainResponse = response.body()?.getResults()
                            if (mainResponse != null) {
                                //Call set up recyclerView
                                setupRecyclerView(mainResponse)
                                val numResults = response.body()?.getNumResults()
                                booksViewModelBinding.txtNumResult.text = "All reviews: $numResults"
                                booksViewModelBinding.progressBar.visibility = View.GONE
                            } else {
                                booksViewModelBinding.txtNumResult.text = "All reviews: 0"
                                booksViewModelBinding.progressBar.visibility = View.GONE
                            }
                        }
                        else -> {
                            snackBar("Error: " + response.body().toString())
                        }
                    }
                }
                override fun onFailure(call: Call<BookReviewsResponse>, t: Throwable) {
                    Log.d("Error:", t.localizedMessage)
                    print(t.localizedMessage)
                    snackBar("Error:" + t.localizedMessage)
                }
            })
        })
    }

    //Call Snack Bar
    private fun snackBar(message: String ) {
        view?.let { it ->
            Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                .show()
        }
    }
    //Setting up RecyclerView with response
    private fun setupRecyclerView(Response: List<BookReviewsResult>) {
        val adapter = BooksAdapter(Response)
        booksViewModelBinding.recyclerViewBookReviews.adapter = adapter
    }
}