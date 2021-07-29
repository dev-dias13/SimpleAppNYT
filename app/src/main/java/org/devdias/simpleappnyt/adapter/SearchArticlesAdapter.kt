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
import org.devdias.simpleappnyt.data.articles.ArticlesResult
import org.devdias.simpleappnyt.data.books.BookReviewsResponse
import org.devdias.simpleappnyt.data.books.BookReviewsResult
import org.devdias.simpleappnyt.data.searchArticle.DocSearchResult

class SearchArticlesAdapter(val dataSet: List<DocSearchResult>):
    RecyclerView.Adapter<SearchArticlesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val abstract: TextView = view.findViewById(R.id.txtAbstract)
        val source: TextView = view.findViewById(R.id.source)
        val snippet: TextView = view.findViewById(R.id.snippet)
        val section_name: TextView = view.findViewById(R.id.section)
        val subsection_name: TextView = view.findViewById(R.id.subsection)
        val pub_date: TextView = view.findViewById(R.id.pub_date)
        val word_count: TextView = view.findViewById(R.id.word_count)
        init {
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.search_article_layout, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.abstract.text = dataSet[position].abstract
        viewHolder.source.text = "Source: " + dataSet[position].source
        viewHolder.snippet.text = dataSet[position].snippet
        viewHolder.section_name.text = "Section: " + dataSet[position].section_name
        viewHolder.subsection_name.text = "Subsection: " + dataSet[position].subsection_name
        viewHolder.pub_date.text = "Publication date: " + dataSet[position].pub_date
        viewHolder.word_count.text = "Word count: " + dataSet[position].word_count

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}