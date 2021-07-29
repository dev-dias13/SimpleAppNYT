package org.devdias.simpleappnyt.data.movieReviews

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieReviewsResponse {


    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("copyright")
    @Expose
    private var copyright: String? = null

    @SerializedName("has_more")
    @Expose
    private var hasMore: Boolean? = null

    @SerializedName("num_results")
    @Expose
    private var numResults: Int? = null

    @SerializedName("results")
    @Expose
    private var results: List<MovieReviewsResult>? = null

    fun MovieReviews(
        status: String?,
        copyright: String?,
        hasMore: Boolean?,
        numResults: Int?,
        results: List<MovieReviewsResult>?
    ) {
        this.status = status
        this.copyright = copyright
        this.hasMore = hasMore
        this.numResults = numResults
        this.results = results
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getCopyright(): String? {
        return copyright
    }

    fun setCopyright(copyright: String?) {
        this.copyright = copyright
    }

    fun getHasMore(): Boolean? {
        return hasMore
    }

    fun setHasMore(hasMore: Boolean?) {
        this.hasMore = hasMore
    }

    fun getNumResults(): Int? {
        return numResults
    }

    fun setNumResults(numResults: Int?) {
        this.numResults = numResults
    }

    fun getResults(): List<MovieReviewsResult>? {
        return results
    }

    fun setResults(results: List<MovieReviewsResult>?) {
        this.results = results
    }
}