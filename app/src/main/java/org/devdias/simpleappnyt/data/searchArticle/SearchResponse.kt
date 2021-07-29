package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResponse {

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("copyright")
    @Expose
    private var copyright: String? = null

    @SerializedName("response")
    @Expose
    private var response: SearchArticleResponse? = null


    fun SearchResponse(status: String?, copyright: String?, response: SearchArticleResponse?) {
        this.status = status
        this.copyright = copyright
        this.response = response
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

    fun getResponse(): SearchArticleResponse? {
        return response
    }

    fun setResponse(response: SearchArticleResponse?) {
        this.response = response
    }
}