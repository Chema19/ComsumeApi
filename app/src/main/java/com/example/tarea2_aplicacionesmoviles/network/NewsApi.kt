package com.example.tarea2_aplicacionesmoviles.network


import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.tarea2_aplicacionesmoviles.responses.ArticlesResponse
import com.example.tarea2_aplicacionesmoviles.responses.SourcesResponse

class NewsApi {
    companion object{
        val baseUrl = "https://newsapi.org"
        val sourceUrl = "$baseUrl/v2/sources"
        val topHeadlinesUrl = "$baseUrl/v2/top-headlines"

        fun requestHeadlines (key: String,
                          responseHandler: (ArticlesResponse?) -> Unit,
                          errorHandler: (ANError?) -> Unit) {
            AndroidNetworking.get(NewsApi.topHeadlinesUrl)
                .addQueryParameter("apiKey", key)
                .addQueryParameter("language", "en")
                .setPriority(Priority.LOW)
                .setTag("Tarea2_AplicacionesMoviles")
                .build()
                .getAsObject(ArticlesResponse::class.java,
                    object : ParsedRequestListener<ArticlesResponse> {
                    override fun onResponse(response: ArticlesResponse?) {
                        responseHandler(response)
                    }
                    override fun onError(anError: ANError?){
                        errorHandler(anError)
                    }
                })
        }

        fun requestSources (key: String,
                              responseHandler: (SourcesResponse?) -> Unit,
                              errorHandler: (ANError?) -> Unit) {
            AndroidNetworking.get(NewsApi.sourceUrl)
                .addQueryParameter("apiKey", key)
                .addQueryParameter("language", "en")
                .setPriority(Priority.LOW)
                .setTag("Tarea2_AplicacionesMoviles")
                .build()
                .getAsObject(SourcesResponse::class.java,
                    object : ParsedRequestListener<SourcesResponse> {
                        override fun onResponse(response: SourcesResponse?) {
                            responseHandler(response)
                        }
                        override fun onError(anError: ANError?){
                            errorHandler(anError)
                        }
                    })
        }
    }
}