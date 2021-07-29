package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MultimediumSearchArticle {


    @SerializedName("rank")
    @Expose
    private var rank: Int? = null

    @SerializedName("subtype")
    @Expose
    private var subtype: String? = null

    @SerializedName("caption")
    @Expose
    private var caption: Any? = null

    @SerializedName("credit")
    @Expose
    private var credit: Any? = null

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("height")
    @Expose
    private var height: Int? = null

    @SerializedName("width")
    @Expose
    private var width: Int? = null

    @SerializedName("legacy")
    @Expose
    private var legacySearchArticle: LegacySearchArticle? = null

    @SerializedName("subType")
    @Expose
    private var subType: String? = null

    @SerializedName("crop_name")
    @Expose
    private var cropName: String? = null


    fun Multimedium(
        rank: Int?,
        subtype: String?,
        caption: Any?,
        credit: Any?,
        type: String?,
        url: String?,
        height: Int?,
        width: Int?,
        legacySearchArticle: LegacySearchArticle?,
        subType: String?,
        cropName: String?
    ) {
        this.rank = rank
        this.subtype = subtype
        this.caption = caption
        this.credit = credit
        this.type = type
        this.url = url
        this.height = height
        this.width = width
        this.legacySearchArticle = legacySearchArticle
        this.subType = subType
        this.cropName = cropName
    }

    fun getRank(): Int? {
        return rank
    }

    fun setRank(rank: Int?) {
        this.rank = rank
    }

    fun getSubtype(): String? {
        return subtype
    }

    fun setSubtype(subtype: String?) {
        this.subtype = subtype
    }

    fun getCaption(): Any? {
        return caption
    }

    fun setCaption(caption: Any?) {
        this.caption = caption
    }

    fun getCredit(): Any? {
        return credit
    }

    fun setCredit(credit: Any?) {
        this.credit = credit
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

    fun getHeight(): Int? {
        return height
    }

    fun setHeight(height: Int?) {
        this.height = height
    }

    fun getWidth(): Int? {
        return width
    }

    fun setWidth(width: Int?) {
        this.width = width
    }

    fun getLegacy(): LegacySearchArticle? {
        return legacySearchArticle
    }

    fun setLegacy(legacySearchArticle: LegacySearchArticle?) {
        this.legacySearchArticle = legacySearchArticle
    }

    fun getSubType(): String? {
        return subType
    }

    fun setSubType(subType: String?) {
        this.subType = subType
    }

    fun getCropName(): String? {
        return cropName
    }

    fun setCropName(cropName: String?) {
        this.cropName = cropName
    }
}