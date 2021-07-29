package org.devdias.simpleappnyt.api

import org.devdias.simpleappnyt.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API: InterfaceAPI by lazy {
        retrofit.create(InterfaceAPI::class.java)
    }

}