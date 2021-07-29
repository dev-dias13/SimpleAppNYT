package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class MetaSearchArticle {
    @SerializedName("hits")
    @Expose
    private var hits: Int? = null

    @SerializedName("offset")
    @Expose
    private var offset: Int? = null

    @SerializedName("time")
    @Expose
    private var time: Int? = null


    fun Meta(hits: Int?, offset: Int?, time: Int?) {
        this.hits = hits
        this.offset = offset
        this.time = time
    }

    fun getHits(): Int? {
        return hits
    }

    fun setHits(hits: Int?) {
        this.hits = hits
    }

    fun getOffset(): Int? {
        return offset
    }

    fun setOffset(offset: Int?) {
        this.offset = offset
    }

    fun getTime(): Int? {
        return time
    }

    fun setTime(time: Int?) {
        this.time = time
    }
}