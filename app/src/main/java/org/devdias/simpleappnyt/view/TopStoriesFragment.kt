package org.devdias.simpleappnyt.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.adapter.ArchiveAdapter
import org.devdias.simpleappnyt.adapter.TopArticlesAdapter
import org.devdias.simpleappnyt.data.archive.ArchiveResponse
import org.devdias.simpleappnyt.data.archive.DocResult
import org.devdias.simpleappnyt.data.topArticles.TopArticlesResponse
import org.devdias.simpleappnyt.data.topArticles.TopArticlesResult
import org.devdias.simpleappnyt.databinding.FragmentArchiveBinding
import org.devdias.simpleappnyt.databinding.FragmentTopStoriesBinding
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.ArchiveViewModel
import org.devdias.simpleappnyt.viewmodel.TopStoriesViewModel
import org.devdias.simpleappnyt.viewmodel.factory.ArchiveViewModelFactory
import org.devdias.simpleappnyt.viewmodel.factory.TopStoriesViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopStoriesFragment : Fragment() {
    private lateinit var viewModel: TopStoriesViewModel
    private lateinit var topStoriesViewModelBinding: FragmentTopStoriesBinding
    private lateinit var query: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        topStoriesViewModelBinding = FragmentTopStoriesBinding.inflate(inflater, container, false)
        val factory = TopStoriesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(TopStoriesViewModel::class.java)
        topStoriesViewModelBinding.topStoriesViewModel = viewModel
        topStoriesViewModelBinding.lifecycleOwner = this
        topStoriesViewModelBinding.recyclerViewTopStories.layoutManager = LinearLayoutManager(context)
        // Apply the adapter to the spinner
        val spinnerAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.sections, android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        topStoriesViewModelBinding.spinnerSectionArt.adapter = spinnerAdapter
        topStoriesViewModelBinding.floatingActionButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_topStoriesFragment_to_mainFragment)
        })
        //Search button
        topStoriesViewModelBinding.btnSearchTopStories.setOnClickListener(View.OnClickListener {
            query = topStoriesViewModelBinding.spinnerSectionArt.selectedItem.toString()
            viewModel.getTopArticles(query)
            topStoriesViewModelBinding.progressBar.visibility = View.VISIBLE
        })
        //list observe
        listObserveFromViewModel()
        return topStoriesViewModelBinding.root

    }

    //List observe func
    private fun listObserveFromViewModel() {
        viewModel.list.observe(viewLifecycleOwner, Observer { response ->
            response.clone().enqueue(object : Callback<TopArticlesResponse> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<TopArticlesResponse>, response: Response<TopArticlesResponse>) {
                    when {
                        response.isSuccessful -> {
                            val mainResponse = response.body()?.getResults()
                            if (mainResponse != null) {
                                setupRecyclerView(mainResponse)
                                val numResults = response.body()?.getNumResults()
                                topStoriesViewModelBinding.txtNumResult.text = "All articles: $numResults"
                                topStoriesViewModelBinding.progressBar.visibility = View.GONE
                            } else {
                                snackBar("mainResponse: null")
                                topStoriesViewModelBinding.progressBar.visibility = View.GONE
                            }
                        }
                        else -> {
                            print(response.body().toString())
                            snackBar("error$response")
                            print(response)
                            Log.d("Error:", response.toString())
                        }
                    }
                }
                override fun onFailure(call: Call<TopArticlesResponse>, t: Throwable) {
                    Log.d("Error:", t.localizedMessage)
                    //snackBar("error" + t.localizedMessage)
                    print(t.localizedMessage)
                }
            })
        })
    }
    private fun snackBar(message: String ) {
        view?.let { it ->
            Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                .show()
        }
    }

    private fun setupRecyclerView(Response: List<TopArticlesResult>) {
        val adapter = TopArticlesAdapter(Response)
        topStoriesViewModelBinding.recyclerViewTopStories.adapter = adapter
    }
}