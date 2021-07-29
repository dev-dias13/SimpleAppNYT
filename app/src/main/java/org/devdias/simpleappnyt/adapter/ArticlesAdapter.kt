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

class ArticlesAdapter(val dataSet: List<ArticlesResult>):
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val author: TextView = view.findViewById(R.id.author)
        val source: TextView = view.findViewById(R.id.source)
        val section: TextView = view.findViewById(R.id.section)
        val txtAbstract: TextView = view.findViewById(R.id.txtAbstract)
        val subsection: TextView = view.findViewById(R.id.subsection)

        init {
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.articles_layout, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.title.text = "Title: " + dataSet[position].title
        viewHolder.author.text = "Author: " + dataSet[position].byline
        viewHolder.source.text = "Source: " + dataSet[position].source
        viewHolder.section.text = "Section: " + dataSet[position].section
        viewHolder.subsection.text = "Subsection: " + dataSet[position].subsection
        viewHolder.txtAbstract.text = "Abstract" + dataSet[position].abstract
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}