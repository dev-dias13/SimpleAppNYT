package org.devdias.simpleappnyt.data.movieReviews

data class MovieReviewsResult (
    val display_title: String,
    val mpaa_rating: String,
    val critics_pick: Int,
    val byline: String,
    val headline: String,
    val publication_date: String,
    val opening_date: String,
    val date_updated: String,
    val link: Link,
    val dateUpdated: String,
    val multimedia: Any,
    val summary_short: String
    )