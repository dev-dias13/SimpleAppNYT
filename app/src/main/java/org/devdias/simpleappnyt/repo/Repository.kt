package org.devdias.simpleappnyt.repo

import org.devdias.simpleappnyt.data.timeswire.TimesWireResponse
import org.devdias.simpleappnyt.api.RetrofitInstance
import org.devdias.simpleappnyt.data.archive.ArchiveResponse
import org.devdias.simpleappnyt.data.archive.ArchiveResult
import org.devdias.simpleappnyt.data.articles.ArticlesResponse
import org.devdias.simpleappnyt.data.books.BookReviewsResponse
import org.devdias.simpleappnyt.data.movieReviews.MovieReviewsResponse
import org.devdias.simpleappnyt.data.searchArticle.SearchResponse
import org.devdias.simpleappnyt.data.topArticles.TopArticlesResponse
import retrofit2.Call

class Repository {
    fun getTimesWire(): Call<TimesWireResponse> {
        return RetrofitInstance.API.getTimesWire()
    }
    fun getArchive(month: String, year: String): Call<ArchiveResponse> {
        return RetrofitInstance.API.getArchiveArticles(year, month)
    }
    fun getPopularArticles(): Call<ArticlesResponse> {
        return RetrofitInstance.API.getArticles()
    }
    fun getBooks(author: String): Call<BookReviewsResponse> {
        return RetrofitInstance.API.getBookReviews(author)
    }
    fun getSearchArticle(q: String): Call<SearchResponse> {
        return RetrofitInstance.API.getSearchArticleKeyword(q)
    }
    fun getSearchMovieReviews(query: String): Call<MovieReviewsResponse> {
        return RetrofitInstance.API.getMovieReviews(query)
    }
    fun getTopStories(query: String): Call<TopArticlesResponse> {
        return RetrofitInstance.API.getTopStories(query)
    }
}