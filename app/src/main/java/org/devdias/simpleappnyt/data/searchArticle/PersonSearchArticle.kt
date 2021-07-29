package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class PersonSearchArticle {


    @SerializedName("firstname")
    @Expose
    private var firstname: String? = null

    @SerializedName("middlename")
    @Expose
    private var middlename: Any? = null

    @SerializedName("lastname")
    @Expose
    private var lastname: String? = null

    @SerializedName("qualifier")
    @Expose
    private var qualifier: Any? = null

    @SerializedName("title")
    @Expose
    private var title: Any? = null

    @SerializedName("role")
    @Expose
    private var role: String? = null

    @SerializedName("organization")
    @Expose
    private var organization: String? = null

    @SerializedName("rank")
    @Expose
    private var rank: Int? = null

    fun Person(
        firstname: String?,
        middlename: Any?,
        lastname: String?,
        qualifier: Any?,
        title: Any?,
        role: String?,
        organization: String?,
        rank: Int?
    ) {
        this.firstname = firstname
        this.middlename = middlename
        this.lastname = lastname
        this.qualifier = qualifier
        this.title = title
        this.role = role
        this.organization = organization
        this.rank = rank
    }

    fun getFirstname(): String? {
        return firstname
    }

    fun setFirstname(firstname: String?) {
        this.firstname = firstname
    }

    fun getMiddlename(): Any? {
        return middlename
    }

    fun setMiddlename(middlename: Any?) {
        this.middlename = middlename
    }

    fun getLastname(): String? {
        return lastname
    }

    fun setLastname(lastname: String?) {
        this.lastname = lastname
    }

    fun getQualifier(): Any? {
        return qualifier
    }

    fun setQualifier(qualifier: Any?) {
        this.qualifier = qualifier
    }

    fun getTitle(): Any? {
        return title
    }

    fun setTitle(title: Any?) {
        this.title = title
    }

    fun getRole(): String? {
        return role
    }

    fun setRole(role: String?) {
        this.role = role
    }

    fun getOrganization(): String? {
        return organization
    }

    fun setOrganization(organization: String?) {
        this.organization = organization
    }

    fun getRank(): Int? {
        return rank
    }

    fun setRank(rank: Int?) {
        this.rank = rank
    }
}