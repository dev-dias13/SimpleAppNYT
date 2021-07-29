package org.devdias.simpleappnyt.data.topArticles

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class TopArticlesResponse {

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("copyright")
    @Expose
    private var copyright: String? = null

    @SerializedName("section")
    @Expose
    private var section: String? = null

    @SerializedName("last_updated")
    @Expose
    private var lastUpdated: String? = null

    @SerializedName("num_results")
    @Expose
    private var numResults: Int? = null

    @SerializedName("results")
    @Expose
    private var results: List<TopArticlesResult>? = null


    fun TopArticles(
        status: String?,
        copyright: String?,
        section: String?,
        lastUpdated: String?,
        numResults: Int?,
        results: List<TopArticlesResult>?
    ) {
        this.status = status
        this.copyright = copyright
        this.section = section
        this.lastUpdated = lastUpdated
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

    fun getSection(): String? {
        return section
    }

    fun setSection(section: String?) {
        this.section = section
    }

    fun getLastUpdated(): String? {
        return lastUpdated
    }

    fun setLastUpdated(lastUpdated: String?) {
        this.lastUpdated = lastUpdated
    }

    fun getNumResults(): Int? {
        return numResults
    }

    fun setNumResults(numResults: Int?) {
        this.numResults = numResults
    }

    fun getResults(): List<TopArticlesResult>? {
        return results
    }

    fun setResults(results: List<TopArticlesResult>?) {
        this.results = results
    }

}