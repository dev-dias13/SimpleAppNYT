package org.devdias.simpleappnyt.data.searchArticle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.devdias.simpleappnyt.data.archive.Headline
import org.devdias.simpleappnyt.data.archive.Keyword
import org.devdias.simpleappnyt.data.articles.Medium

data class DocSearchResult (
    val abstract: String,
    val web_url: String,
    val snippet: String,
    val lead_paragraph: String,
    val print_section: String,
    val print_page: String,
    val source: String,
    val multimedia: List<MultimediumSearchArticle>?,
    val headline: Headline,
    val keywords: List<Keyword>?,
    val pub_date: String,
    val document_type: String,
    val news_desk: String,
    val section_name: String,
    val subsection_name: String,
    val byline: BylineSearchArticle,
    val type_of_material: String,
    val _id: String,
    val word_count: Int,
    val uri: String

)