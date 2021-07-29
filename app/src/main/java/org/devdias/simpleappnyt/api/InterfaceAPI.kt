package org.devdias.simpleappnyt.api

import org.devdias.simpleappnyt.data.archive.ArchiveResponse
import org.devdias.simpleappnyt.data.archive.ArchiveResult
import org.devdias.simpleappnyt.data.articles.ArticlesResponse
import org.devdias.simpleappnyt.data.books.BookReviewsResponse
import org.devdias.simpleappnyt.data.movieReviews.MovieReviewsResponse
import org.devdias.simpleappnyt.data.searchArticle.SearchResponse
import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.data.topArticles.TopArticlesResponse
import org.devdias.simpleappnyt.utils.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceAPI {
    @GET("svc/news/v3/content/all/all.json")
    fun getTimesWire(
        @Query("api-key", encoded=true) api: String = API_KEY,
    ): Call<TimesWireResponse>

    @GET("svc/mostpopular/v2/viewed/1.json")
    fun getArticles(
        @Query("api-key", encoded=true) api: String = API_KEY,
    ): Call<ArticlesResponse>

    @GET("svc/books/v3/reviews.json")
    fun getBookReviews(
        @Query("author", encoded=true) author: String,
        @Query("api-key", encoded=true) api: String = API_KEY,
    ): Call<BookReviewsResponse>

    @GET("svc/archive/v1/{year}/{month}.json")
    fun getArchiveArticles(
        @Path("year", encoded=true) year: String,
        @Path("month", encoded=true) month: String,
        @Query("api-key", encoded=true) api: String = API_KEY,
    ): Call<ArchiveResponse>

    @GET("svc/search/v2/articlesearch.json")
    fun getSearchArticleKeyword(
        @Query("q", encoded=true) q: String,
        @Query("api-key", encoded=true) api: String = API_KEY,
    ): Call<SearchResponse>

    @GET("svc/movies/v2/reviews/search.json")
    fun getMovieReviews(
        @Query("query", encoded=true) query: String,
        @Query("api-key", encoded=true) api: String = API_KEY,
    ): Call<MovieReviewsResponse>

    @GET("svc/topstories/v2/{section}.json")
    fun getTopStories(
        @Path("section", encoded=true) section: String,
        @Query("api-key", encoded=true) api: String = API_KEY,
    ): Call<TopArticlesResponse>
}