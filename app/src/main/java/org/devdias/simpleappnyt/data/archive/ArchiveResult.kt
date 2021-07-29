package org.devdias.simpleappnyt.data.archive
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArchiveResult {
    @SerializedName("docs")
    @Expose
    private var docs: List<DocResult>? = null

    @SerializedName("meta")
    @Expose
    private var meta: Meta? = null

    fun ArchiveResult(docs: List<DocResult>?, meta: Meta?) {
        //super()
        this.docs = docs
        this.meta = meta
    }

    fun getDocs(): List<DocResult>? {
        return docs
    }

    fun setDocs(docs: List<DocResult>?) {
        this.docs = docs
    }

    fun getMeta(): Meta? {
        return meta
    }

    fun setMeta(meta: Meta?) {
        this.meta = meta
    }

}