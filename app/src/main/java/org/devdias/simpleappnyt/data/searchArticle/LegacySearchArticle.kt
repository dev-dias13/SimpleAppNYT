package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class LegacySearchArticle {

    @SerializedName("xlarge")
    @Expose
    private var xlarge: String? = null

    @SerializedName("xlargewidth")
    @Expose
    private var xlargewidth: Int? = null

    @SerializedName("xlargeheight")
    @Expose
    private var xlargeheight: Int? = null

    @SerializedName("thumbnail")
    @Expose
    private var thumbnail: String? = null

    @SerializedName("thumbnailwidth")
    @Expose
    private var thumbnailwidth: Int? = null

    @SerializedName("thumbnailheight")
    @Expose
    private var thumbnailheight: Int? = null

    @SerializedName("widewidth")
    @Expose
    private var widewidth: Int? = null

    @SerializedName("wideheight")
    @Expose
    private var wideheight: Int? = null

    @SerializedName("wide")
    @Expose
    private var wide: String? = null

    fun Legacy(
        xlarge: String?,
        xlargewidth: Int?,
        xlargeheight: Int?,
        thumbnail: String?,
        thumbnailwidth: Int?,
        thumbnailheight: Int?,
        widewidth: Int?,
        wideheight: Int?,
        wide: String?
    ) {
        this.xlarge = xlarge
        this.xlargewidth = xlargewidth
        this.xlargeheight = xlargeheight
        this.thumbnail = thumbnail
        this.thumbnailwidth = thumbnailwidth
        this.thumbnailheight = thumbnailheight
        this.widewidth = widewidth
        this.wideheight = wideheight
        this.wide = wide
    }

    fun getXlarge(): String? {
        return xlarge
    }

    fun setXlarge(xlarge: String?) {
        this.xlarge = xlarge
    }

    fun getXlargewidth(): Int? {
        return xlargewidth
    }

    fun setXlargewidth(xlargewidth: Int?) {
        this.xlargewidth = xlargewidth
    }

    fun getXlargeheight(): Int? {
        return xlargeheight
    }

    fun setXlargeheight(xlargeheight: Int?) {
        this.xlargeheight = xlargeheight
    }

    fun getThumbnail(): String? {
        return thumbnail
    }

    fun setThumbnail(thumbnail: String?) {
        this.thumbnail = thumbnail
    }

    fun getThumbnailwidth(): Int? {
        return thumbnailwidth
    }

    fun setThumbnailwidth(thumbnailwidth: Int?) {
        this.thumbnailwidth = thumbnailwidth
    }

    fun getThumbnailheight(): Int? {
        return thumbnailheight
    }

    fun setThumbnailheight(thumbnailheight: Int?) {
        this.thumbnailheight = thumbnailheight
    }

    fun getWidewidth(): Int? {
        return widewidth
    }

    fun setWidewidth(widewidth: Int?) {
        this.widewidth = widewidth
    }

    fun getWideheight(): Int? {
        return wideheight
    }

    fun setWideheight(wideheight: Int?) {
        this.wideheight = wideheight
    }

    fun getWide(): String? {
        return wide
    }

    fun setWide(wide: String?) {
        this.wide = wide
    }
}