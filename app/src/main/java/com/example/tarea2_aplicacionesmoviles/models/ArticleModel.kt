package com.example.tarea2_aplicacionesmoviles.models

import android.os.Bundle
import android.text.SpannableStringBuilder
import javax.xml.transform.Source

data class ArticleModel (
            val source: SourceModel,
            val author: String,
            val title: String,
            val description: String,
            val url: String,
            val urlToImage: String,
            val publishedAt: String){

    companion object{
        fun from(bundle: Bundle): ArticleModel{
            return ArticleModel(
                    SourceModel.from(bundle.getBundle("source")!!),
                    bundle.getString("author")!!,
                    bundle.getString("title")!!,
                    bundle.getString("description")!!,
                    bundle.getString("url")!!,
                    bundle.getString("urlToImage")!!,
                    bundle.getString("publishedAt")!!
            )
        }
    }

    fun toBundle() : Bundle{
        var bundle = Bundle()
        bundle.putBundle("source", source.toBundle())
        bundle.putString("author", author)
        bundle.putString("title", title)
        bundle.putString("description", description)
        bundle.putString("url", url)
        bundle.putString("urlToImage", urlToImage)
        bundle.putString("publishedAt", publishedAt)
        return bundle
    }
}