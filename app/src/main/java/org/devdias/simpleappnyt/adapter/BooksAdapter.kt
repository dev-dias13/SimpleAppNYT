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

class BooksAdapter(val dataSet: List<BookReviewsResult>):
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val author: TextView = view.findViewById(R.id.author)
        val byline: TextView = view.findViewById(R.id.byline)
        val summary: TextView = view.findViewById(R.id.summary)
        init {
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.books_layout, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.title.text = "Title :" + dataSet[position].book_title
        viewHolder.author.text = "Book author: " + dataSet[position].book_author
        viewHolder.byline.text = "by: " + dataSet[position].byline
        viewHolder.summary.text = "Summary: " + dataSet[position].summary
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}