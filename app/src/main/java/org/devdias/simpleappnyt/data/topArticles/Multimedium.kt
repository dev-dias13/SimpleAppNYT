package org.devdias.simpleappnyt.data.topArticles

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Multimedium {


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

}
