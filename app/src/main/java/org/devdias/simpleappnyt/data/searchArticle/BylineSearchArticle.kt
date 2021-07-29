package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class BylineSearchArticle {

    @SerializedName("original")
    @Expose
    private var original: String? = null

    @SerializedName("person")
    @Expose
    private var personSearchArticles: List<PersonSearchArticle>? = null

    @SerializedName("organization")
    @Expose
    private var organization: Any? = null

    fun Byline(original: String?, personSearchArticles: List<PersonSearchArticle>?, organization: Any?) {
        this.original = original
        this.personSearchArticles = personSearchArticles
        this.organization = organization
    }

    fun getOriginal(): String? {
        return original
    }

    fun setOriginal(original: String?) {
        this.original = original
    }

    fun getPerson(): List<PersonSearchArticle>? {
        return personSearchArticles
    }

    fun setPerson(personSearchArticles: List<PersonSearchArticle>?) {
        this.personSearchArticles = personSearchArticles
    }

    fun getOrganization(): Any? {
        return organization
    }

    fun setOrganization(organization: Any?) {
        this.organization = organization
    }
}