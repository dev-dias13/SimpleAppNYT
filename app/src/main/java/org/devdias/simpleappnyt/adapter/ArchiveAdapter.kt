package org.devdias.simpleappnyt.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.devdias.simpleappnyt.data.timeswire.TimesWireResult
import org.devdias.simpleappnyt.R
import org.devdias.simpleappnyt.data.archive.DocResult
import org.devdias.simpleappnyt.data.articles.ArticlesResult

class ArchiveAdapter(val dataSet: List<DocResult>):
    RecyclerView.Adapter<ArchiveAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val abstract: TextView = view.findViewById(R.id.txtAbstract)
        val source: TextView = view.findViewById(R.id.source)
        val snippet: TextView = view.findViewById(R.id.snippet)

        init {
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.archive_layout, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.abstract.text = "Abstract" + dataSet[position].abstract
        viewHolder.source.text = "Source: " + dataSet[position].source
        viewHolder.snippet.text = "Snippet: " + dataSet[position].snippet
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}