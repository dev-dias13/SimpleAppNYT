package org.devdias.simpleappnyt.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.adapter.TimesWireAdapter
import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.data.timeswire.TimesWireResult
import org.devdias.simpleappnyt.databinding.FragmentTimesWireBinding
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.TimesWireViewModel
import org.devdias.simpleappnyt.viewmodel.factory.TimesWireViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimesWireFragment : Fragment() {
    private lateinit var viewModel: TimesWireViewModel
    private lateinit var timesWireDataBinding: FragmentTimesWireBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        // Inflate the layout for this fragment
        timesWireDataBinding = FragmentTimesWireBinding.inflate(inflater, container, false)
        val factory = TimesWireViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(TimesWireViewModel::class.java)
        timesWireDataBinding.timesWireViewModel = viewModel
        timesWireDataBinding.lifecycleOwner = this
        //Progress Bar visibility
        timesWireDataBinding.progressBar.visibility = View.VISIBLE
        //Back navigation
        timesWireDataBinding.floatingActionButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_timesWireFragment_to_mainFragment)
        })
        //Call getTimesWire function from viewmodel
        viewModel.getTimesWire()
        //list observe
        listObserveFromViewModel()
        return timesWireDataBinding.root
    }

    //List observe func
    private fun listObserveFromViewModel() {
        viewModel.list.observe(viewLifecycleOwner, Observer { response ->
            response.enqueue(object : Callback<TimesWireResponse> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<TimesWireResponse>, response: Response<TimesWireResponse>) {
                    when {
                        response.isSuccessful -> {
                            val mainResponse = response.body()?.getResults()
                            response.body()?.let {
                                if (mainResponse != null) {
                                    setupRecyclerView(mainResponse)
                                    val numResults = response.body()?.getNumResults()
                                    timesWireDataBinding.txtNumResult.text = "All articles: $numResults"
                                    timesWireDataBinding.progressBar.visibility = View.GONE
                                } else {
                                    snackBar("Error: null response")
                                    timesWireDataBinding.progressBar.visibility = View.GONE
                                }
                            }
                        }
                        else -> {
                            snackBar("Error")
                            timesWireDataBinding.progressBar.visibility = View.GONE
                        }
                    }
                }
                override fun onFailure(call: Call<TimesWireResponse>, t: Throwable) {
                    snackBar("Error: " + t.localizedMessage)
                    Log.d("Error:", t.localizedMessage)
                    timesWireDataBinding.progressBar.visibility = View.GONE
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
    private fun setupRecyclerView(Response: List<TimesWireResult>) {
        val adapter = TimesWireAdapter(Response)
        timesWireDataBinding.recyclerViewTimesWire.layoutManager = LinearLayoutManager(context)
        timesWireDataBinding.recyclerViewTimesWire.adapter = adapter
    }

}