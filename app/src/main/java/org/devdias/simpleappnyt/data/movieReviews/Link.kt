package org.devdias.simpleappnyt.data.movieReviews

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Link {

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("suggested_link_text")
    @Expose
    private var suggestedLinkText: String? = null

    fun Link() {}

    fun Link(type: String?, url: String?, suggestedLinkText: String?) {
        this.type = type
        this.url = url
        this.suggestedLinkText = suggestedLinkText
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getSuggestedLinkText(): String? {
        return suggestedLinkText
    }

    fun setSuggestedLinkText(suggestedLinkText: String?) {
        this.suggestedLinkText = suggestedLinkText
    }
}