package org.devdias.simpleappnyt.data.archive

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Byline {

    @SerializedName("original")
    @Expose
    private var original: String? = null

    @SerializedName("person")
    @Expose
    private var person: List<Any>? = null

    @SerializedName("organization")
    @Expose
    private var organization: Any? = null

    fun Byline(original: String?, person: List<Any>?, organization: Any?) {
        //super()
        this.original = original
        this.person = person
        this.organization = organization
    }

    fun getOriginal(): String? {
        return original
    }

    fun setOriginal(original: String?) {
        this.original = original
    }

    fun getPerson(): List<Any>? {
        return person
    }

    fun setPerson(person: List<Any>?) {
        this.person = person
    }

    fun getOrganization(): Any? {
        return organization
    }

    fun setOrganization(organization: Any?) {
        this.organization = organization
    }

}
