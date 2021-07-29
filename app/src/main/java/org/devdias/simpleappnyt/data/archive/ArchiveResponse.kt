package org.devdias.simpleappnyt.data.archive

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArchiveResponse {

    @SerializedName("copyright")
    @Expose
    private var copyright: String? = null

    @SerializedName("response")
    @Expose
    private var response: ArchiveResult? = null

    fun Example(copyright: String?, response: ArchiveResult?) {
        //super()
        this.copyright = copyright
        this.response = response
    }

    fun getCopyright(): String? {
        return copyright
    }

    fun setCopyright(copyright: String?) {
        this.copyright = copyright
    }

    fun getResponse(): ArchiveResult? {
        return response
    }

    fun setResponse(response: ArchiveResult?) {
        this.response = response
    }
}