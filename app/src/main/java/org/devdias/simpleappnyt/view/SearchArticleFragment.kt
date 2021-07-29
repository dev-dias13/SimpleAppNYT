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
import org.devdias.simpleappnyt.adapter.BooksAdapter
import org.devdias.simpleappnyt.adapter.SearchArticlesAdapter
import org.devdias.simpleappnyt.data.books.BookReviewsResponse
import org.devdias.simpleappnyt.data.books.BookReviewsResult
import org.devdias.simpleappnyt.data.searchArticle.DocSearchResult
import org.devdias.simpleappnyt.data.searchArticle.SearchResponse
import org.devdias.simpleappnyt.databinding.FragmentBooksBinding
import org.devdias.simpleappnyt.databinding.FragmentSearchArticleBinding
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.BooksViewModel
import org.devdias.simpleappnyt.viewmodel.SearchArticleViewModel
import org.devdias.simpleappnyt.viewmodel.factory.BooksViewModelFactory
import org.devdias.simpleappnyt.viewmodel.factory.SearchArticleViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchArticleFragment : Fragment() {
    private lateinit var viewModel: SearchArticleViewModel
    private lateinit var searchArticleViewModelBinding: FragmentSearchArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val repository = Repository()
        searchArticleViewModelBinding = FragmentSearchArticleBinding.inflate(inflater, container, false)
        val factory = SearchArticleViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(SearchArticleViewModel::class.java)
        searchArticleViewModelBinding.searchArticleViewModel = viewModel
        searchArticleViewModelBinding.lifecycleOwner = this
        searchArticleViewModelBinding.floatingActionButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_searchArticleFragment_to_mainFragment)
        })
        searchArticleViewModelBinding.recyclerViewSearchArticle.layoutManager = LinearLayoutManager(context)
        searchArticleViewModelBinding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getSearch(query)
                searchArticleViewModelBinding.progressBar.visibility = View.VISIBLE
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        listObserveFromViewModel()
        return searchArticleViewModelBinding.root
    }

    private fun listObserveFromViewModel() {
        viewModel.list.observe(viewLifecycleOwner, Observer { response ->
            response.clone().enqueue(object : Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    when {
                        response.isSuccessful -> {
                            val mainResponse = response.body()?.getResponse()?.getSearchResultDocs()
                            //snackBar("success")
                            Log.d("Success: ", "Success after get main response")
                            if (mainResponse != null) {
                                setupRecyclerView(mainResponse)
                                searchArticleViewModelBinding.progressBar.visibility = View.GONE
                            } else {
                                snackBar("Error: null response")
                                searchArticleViewModelBinding.progressBar.visibility = View.GONE
                            }
                        }
                        else -> {
                            searchArticleViewModelBinding.progressBar.visibility = View.GONE
                            snackBar("error: $response")
                            Log.d("Error: ", response.message())
                        }
                    }
                }
                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.d("Error:", t.localizedMessage)
                    searchArticleViewModelBinding.progressBar.visibility = View.GONE
                    snackBar("Error: " + t.localizedMessage)
                    print(t.localizedMessage)
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
    private fun setupRecyclerView(Response: List<DocSearchResult>) {
        val adapter = SearchArticlesAdapter(Response)
        searchArticleViewModelBinding.recyclerViewSearchArticle.adapter = adapter
    }
}