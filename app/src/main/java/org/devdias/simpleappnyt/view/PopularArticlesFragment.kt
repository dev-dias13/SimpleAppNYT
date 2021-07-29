package org.devdias.simpleappnyt.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.adapter.ArticlesAdapter
import org.devdias.simpleappnyt.adapter.TimesWireAdapter
import org.devdias.simpleappnyt.data.articles.ArticlesResponse
import org.devdias.simpleappnyt.data.articles.ArticlesResult
import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.data.timeswire.TimesWireResult
import org.devdias.simpleappnyt.databinding.FragmentPopularArticlesBinding
import org.devdias.simpleappnyt.databinding.FragmentTimesWireBinding
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.PopularArticlesViewModel
import org.devdias.simpleappnyt.viewmodel.TimesWireViewModel
import org.devdias.simpleappnyt.viewmodel.factory.PopularArticlesViewModelFactory
import org.devdias.simpleappnyt.viewmodel.factory.TimesWireViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularArticlesFragment : Fragment() {
    private lateinit var viewModel: PopularArticlesViewModel
    private lateinit var articlesViewModelBinding: FragmentPopularArticlesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        // Inflate the layout for this fragment
        articlesViewModelBinding = FragmentPopularArticlesBinding.inflate(inflater, container, false)
        val factory = PopularArticlesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(PopularArticlesViewModel::class.java)
        articlesViewModelBinding.popularArticlesViewModel = viewModel
        articlesViewModelBinding.lifecycleOwner = this
        //Progress Bar visibility
        articlesViewModelBinding.progressBar.visibility = View.VISIBLE
        //Back navigation
        articlesViewModelBinding.floatingActionButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_popularArticlesFragment_to_mainFragment)
        })
        //Call getPopularArticles() function from viewmodel
        viewModel.getPopularArticles()
        //list observe
        listObserveFromViewModel()
        return articlesViewModelBinding.root
    }

    //List observe func
    private fun listObserveFromViewModel() {
        viewModel.list.observe(viewLifecycleOwner, Observer { response ->
            response.enqueue(object : Callback<ArticlesResponse> {
                override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>) {
                    when {
                        response.isSuccessful -> {
                            val mainResponse = response.body()?.getResults()
                            response.body()?.let {
                                if (mainResponse != null) {
                                    setupRecyclerView(mainResponse)
                                    val numResults = response.body()?.getNumResults()
                                    articlesViewModelBinding.txtNumResult.text = "All most viewed articles: $numResults"
                                    articlesViewModelBinding.progressBar.visibility = View.GONE
                                } else {
                                    snackBar("Error: null response")
                                    articlesViewModelBinding.progressBar.visibility = View.GONE
                                }
                            }
                        }
                        else -> {
                            snackBar("Error")
                            articlesViewModelBinding.progressBar.visibility = View.GONE
                        }
                    }
                }
                override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                    snackBar("Error: " + t.localizedMessage)
                    Log.d("Error:", t.localizedMessage)
                    articlesViewModelBinding.progressBar.visibility = View.GONE
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
    private fun setupRecyclerView(Response: List<ArticlesResult>) {
        val adapter = ArticlesAdapter(Response)
        articlesViewModelBinding.recyclerViewArticles.layoutManager = LinearLayoutManager(context)
        articlesViewModelBinding.recyclerViewArticles.adapter = adapter
    }
}