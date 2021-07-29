package org.devdias.simpleappnyt.data.timeswire

data class TimesWireResult (
    val slugName: String,
    val section: String,
    val subsection: String,
    val title: String,
    val _abstract: String,
    val url: String,
    val byline: String,
    val thumbnail_standard: String,
    val itemType: String,
    val source: String,
    val updatedDate: String,
    val createdDate: String,
    val publishedDate: String,
    val firstPublishedDate: String,
    val materialTypeFacet: String,
    val kicker: String,
    val subheadline: String,
    val relatedUrls: String,
    val multimedia: List<MultimediumTimesWire>,
)