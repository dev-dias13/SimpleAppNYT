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
import org.devdias.simpleappnyt.data.movieReviews.MovieReviewsResult

class MovieReviewsAdapter(val dataSet: List<MovieReviewsResult>):
    RecyclerView.Adapter<MovieReviewsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val display_title: TextView = view.findViewById(R.id.display_title)
        val mpaa_rating: TextView = view.findViewById(R.id.mpaa_rating)
        val byline: TextView = view.findViewById(R.id.byline)
        val headline: TextView = view.findViewById(R.id.headline)
        val summary_short: TextView = view.findViewById(R.id.summary_short)
        init {
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.moviereviews_layout, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.display_title.text = "Title: " + dataSet[position].display_title
        viewHolder.mpaa_rating.text = "MPAA Rating: " + dataSet[position].mpaa_rating
        viewHolder.byline.text = "by: " + dataSet[position].byline
        viewHolder.headline.text = "Headline" + dataSet[position].headline
        viewHolder.summary_short.text = "Summary short: " + dataSet[position].summary_short
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}