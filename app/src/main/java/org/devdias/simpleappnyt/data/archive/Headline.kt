package org.devdias.simpleappnyt.data.archive

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Headline {

    @SerializedName("main")
    @Expose
    private var main: String? = null

    @SerializedName("kicker")
    @Expose
    private var kicker: String? = null

    @SerializedName("content_kicker")
    @Expose
    private var contentKicker: Any? = null

    @SerializedName("print_headline")
    @Expose
    private var printHeadline: String? = null

    @SerializedName("name")
    @Expose
    private var name: Any? = null

    @SerializedName("seo")
    @Expose
    private var seo: Any? = null

    @SerializedName("sub")
    @Expose
    private var sub: Any? = null

    fun Headline(
        main: String?,
        kicker: String?,
        contentKicker: Any?,
        printHeadline: String?,
        name: Any?,
        seo: Any?,
        sub: Any?
    ) {
        //super()
        this.main = main
        this.kicker = kicker
        this.contentKicker = contentKicker
        this.printHeadline = printHeadline
        this.name = name
        this.seo = seo
        this.sub = sub
    }

    fun getMain(): String? {
        return main
    }

    fun setMain(main: String?) {
        this.main = main
    }

    fun getKicker(): String? {
        return kicker
    }

    fun setKicker(kicker: String?) {
        this.kicker = kicker
    }

    fun getContentKicker(): Any? {
        return contentKicker
    }

    fun setContentKicker(contentKicker: Any?) {
        this.contentKicker = contentKicker
    }

    fun getPrintHeadline(): String? {
        return printHeadline
    }

    fun setPrintHeadline(printHeadline: String?) {
        this.printHeadline = printHeadline
    }

    fun getName(): Any? {
        return name
    }

    fun setName(name: Any?) {
        this.name = name
    }

    fun getSeo(): Any? {
        return seo
    }

    fun setSeo(seo: Any?) {
        this.seo = seo
    }

    fun getSub(): Any? {
        return sub
    }

    fun setSub(sub: Any?) {
        this.sub = sub
    }


}
