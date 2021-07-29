package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class KeywordSearchArticle {


    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("value")
    @Expose
    private var value: String? = null

    @SerializedName("rank")
    @Expose
    private var rank: Int? = null

    @SerializedName("major")
    @Expose
    private var major: String? = null

    fun Keyword(name: String?, value: String?, rank: Int?, major: String?) {
        this.name = name
        this.value = value
        this.rank = rank
        this.major = major
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getValue(): String? {
        return value
    }

    fun setValue(value: String?) {
        this.value = value
    }

    fun getRank(): Int? {
        return rank
    }

    fun setRank(rank: Int?) {
        this.rank = rank
    }

    fun getMajor(): String? {
        return major
    }

    fun setMajor(major: String?) {
        this.major = major
    }
}