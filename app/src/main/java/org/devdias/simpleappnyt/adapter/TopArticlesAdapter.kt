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
import org.devdias.simpleappnyt.data.topArticles.TopArticlesResult

class TopArticlesAdapter(val dataSet: List<TopArticlesResult>):
    RecyclerView.Adapter<TopArticlesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val section: TextView = view.findViewById(R.id.section)
        val subsection: TextView = view.findViewById(R.id.subsection)
        val abstract: TextView = view.findViewById(R.id.txtAbstract)
        val byline: TextView = view.findViewById(R.id.byline)

        init {
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.top_stories_layout, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = "Title: " + dataSet[position].title
        viewHolder.section.text = "Section: " + dataSet[position].section
        viewHolder.subsection.text = "Subsection: " + dataSet[position].subsection
        viewHolder.abstract.text = "Abstract: " + dataSet[position].abstract
        viewHolder.byline.text = "Author: " + dataSet[position].byline
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}