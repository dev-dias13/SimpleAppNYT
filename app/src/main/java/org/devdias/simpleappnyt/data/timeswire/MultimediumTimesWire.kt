package org.devdias.simpleappnyt.data.timeswire

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MultimediumTimesWire {

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("format")
    @Expose
    private var format: String? = null

    @SerializedName("height")
    @Expose
    private var height: Int? = null

    @SerializedName("width")
    @Expose
    private var width: Int? = null

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("subtype")
    @Expose
    private var subtype: String? = null

    @SerializedName("caption")
    @Expose
    private var caption: String? = null

    @SerializedName("copyright")
    @Expose
    private var copyright: String? = null

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getFormat(): String? {
        return format
    }

    fun setFormat(format: String?) {
        this.format = format
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

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getSubtype(): String? {
        return subtype
    }

    fun setSubtype(subtype: String?) {
        this.subtype = subtype
    }

    fun getCaption(): String? {
        return caption
    }

    fun setCaption(caption: String?) {
        this.caption = caption
    }

    fun getCopyright(): String? {
        return copyright
    }

    fun setCopyright(copyright: String?) {
        this.copyright = copyright
    }
}