package org.devdias.simpleappnyt.data.articles

data class ArticlesResult (
    val uri: String,
    val url: String,
    val id: String,
    val asset_id: Long,
    val source: String,
    val published_date: String,
    val updated: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
    val adx_keywords: String,
    val column: Any,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val des_facet: List<String>,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val geo_facet: List<String>,
    val media: List<Medium>,
    val eta_id: Int
)