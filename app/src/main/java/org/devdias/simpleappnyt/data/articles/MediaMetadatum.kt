package org.devdias.simpleappnyt.data.articles

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MediaMetadatum {

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

}