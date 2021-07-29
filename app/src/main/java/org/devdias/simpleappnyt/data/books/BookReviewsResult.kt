package org.devdias.simpleappnyt.data.books

data class BookReviewsResult (
    val url: String,
    val publication_dt: String,
    val byline: String,
    val book_title: String,
    val book_author: String,
    val summary: String,
    val uuid: String,
    val uri: String,
    val isbn13: List<String>
)