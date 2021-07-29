package org.devdias.simpleappnyt.data.archive

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meta {

    @SerializedName("hits")
    @Expose
    private var hits: Int? = null

    fun Meta(hits: Int?) {
        //super()
        this.hits = hits
    }

    fun getHits(): Int? {
        return hits
    }

    fun setHits(hits: Int?) {
        this.hits = hits
    }

}
