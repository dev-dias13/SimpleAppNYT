package org.devdias.simpleappnyt.view

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.adapter.ArchiveAdapter
import org.devdias.simpleappnyt.data.archive.ArchiveResponse
import org.devdias.simpleappnyt.data.archive.ArchiveResult
import org.devdias.simpleappnyt.data.archive.DocResult
import org.devdias.simpleappnyt.data.books.BookReviewsResponse
import org.devdias.simpleappnyt.databinding.FragmentArchiveBinding
import org.devdias.simpleappnyt.repo.Repository
import org.devdias.simpleappnyt.viewmodel.ArchiveViewModel
import org.devdias.simpleappnyt.viewmodel.factory.ArchiveViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class ArchiveFragment : Fragment() {
    private lateinit var viewModel: ArchiveViewModel
    private lateinit var archiveViewModelBinding: FragmentArchiveBinding
    private lateinit var month: String
    private lateinit var year: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val repository = Repository()
        archiveViewModelBinding = FragmentArchiveBinding.inflate(inflater, container, false)
        val factory = ArchiveViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(ArchiveViewModel::class.java)
        archiveViewModelBinding.archiveViewModel = viewModel
        archiveViewModelBinding.lifecycleOwner = this
        archiveViewModelBinding.recyclerViewArchiveArticles.layoutManager = LinearLayoutManager(context)
        // Apply the adapter to the spinner
        val spinnerAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.month, android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        archiveViewModelBinding.spinner.adapter = spinnerAdapter
        // Back Navigation
        archiveViewModelBinding.floatingActionButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_archiveFragment_to_mainFragment)
        })
        //Button search
        archiveViewModelBinding.btnSearch.setOnClickListener(View.OnClickListener{
            month = archiveViewModelBinding.spinner.selectedItem.toString()
            year = archiveViewModelBinding.year.text.toString()
            viewModel.getArchive(year, month)
            archiveViewModelBinding.progressBar.visibility = View.VISIBLE
        })
        //list observe
        listObserveFromViewModel()

        return archiveViewModelBinding.root

    }
    //List observe func
    private fun listObserveFromViewModel() {
        viewModel.list.observe(viewLifecycleOwner, Observer { response ->
            response.clone().enqueue(object : Callback<ArchiveResponse> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<ArchiveResponse>, response: Response<ArchiveResponse>) {
                    when {
                        response.isSuccessful -> {
                            val mainResponse = response.body()?.getResponse()?.getDocs()
                            val mess = response.body()?.getResponse()?.getDocs()?.get(0)?.abstract.toString()
                            snackBar(mess)
                            if (mainResponse != null) {
                                setupRecyclerView(mainResponse)
                                archiveViewModelBinding.txtResult.text = "All articles $month/$year"
                                archiveViewModelBinding.progressBar.visibility = View.GONE

                            } else {
                                snackBar("mainResponse: null")
                                archiveViewModelBinding.progressBar.visibility = View.GONE
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
                override fun onFailure(call: Call<ArchiveResponse>, t: Throwable) {
                    Log.d("Error:", t.localizedMessage)
                    //snackBar("error" + t.localizedMessage)
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
    private fun setupRecyclerView(Response: List<DocResult>) {
        val adapter = ArchiveAdapter(Response)
        archiveViewModelBinding.recyclerViewArchiveArticles.adapter = adapter
    }
}