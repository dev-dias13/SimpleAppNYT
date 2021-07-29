package org.devdias.simpleappnyt.data.articles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArticlesResponse {

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("copyright")
    @Expose
    private var copyright: String? = null

    @SerializedName("num_results")
    @Expose
    private var numResults: Int? = null

    @SerializedName("results")
    @Expose
    private var results: List<ArticlesResult>? = null

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

    fun getNumResults(): Int? {
        return numResults
    }

    fun setNumResults(numResults: Int?) {
        this.numResults = numResults
    }

    fun getResults(): List<ArticlesResult>? {
        return results
    }

    fun setResults(results: List<ArticlesResult>?) {
        this.results = results
    }
}