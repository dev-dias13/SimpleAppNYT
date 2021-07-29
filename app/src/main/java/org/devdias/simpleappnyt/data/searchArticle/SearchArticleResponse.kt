package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchArticleResponse {

    @SerializedName("docs")
    @Expose
    private var docSearchArticles: List<DocSearchResult>? = null

    @SerializedName("meta")
    @Expose
    private var metaSearchArticle: MetaSearchArticle? = null


    fun Response(docSearchArticles: List<DocSearchResult>?, metaSearchArticle: MetaSearchArticle?) {
        this.docSearchArticles = docSearchArticles
        this.metaSearchArticle = metaSearchArticle
    }

    fun getSearchResultDocs(): List<DocSearchResult>? {
        return docSearchArticles
    }

    fun setSearchResultDocs(docSearchArticles: List<DocSearchResult>?) {
        this.docSearchArticles = docSearchArticles
    }

    fun getMeta(): MetaSearchArticle? {
        return metaSearchArticle
    }

    fun setMeta(metaSearchArticle: MetaSearchArticle?) {
        this.metaSearchArticle = metaSearchArticle
    }

}