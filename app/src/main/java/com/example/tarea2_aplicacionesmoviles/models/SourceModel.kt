package com.example.tarea2_aplicacionesmoviles.models

import android.os.Bundle
import com.example.tarea2_aplicacionesmoviles.network.LogoApi
import com.orm.SugarRecord

data class SourceModel (val id: String,
                        val name: String,
                        val description: String? = "",
                        val url: String? = "",
                        val category: String? = "",
                        val language: String? = "",
                        val country: String? = ""){
    companion object{
        fun from(bundle: Bundle): SourceModel{
            return SourceModel(
                bundle.getString("id"),
                bundle.getString("name"),
                bundle.getString("description"),
                bundle.getString("url"),
                bundle.getString("category"),
                bundle.getString("language"),
                bundle.getString("country")
            )
        }
    }

    fun urlToLogo() = LogoApi.urlToLogo(url!!)

    fun toBundle() : Bundle{
        val bundle = Bundle()
        bundle.putString("id",id)
        bundle.putString("name",name)
        bundle.putString("description",description)
        bundle.putString("url",url)
        bundle.putString("category",category)
        bundle.putString("language",language)
        bundle.putString("country",country)
        return bundle
    }

    fun isBookmarked() : Boolean{
        return SugarRecord.find(
            BookmarkModel::class.java,
            "source_id = ?",
            id).size > 0
    }

    fun setBookmarked(isBookmarkModel: Boolean){
        if(isBookmarkModel == isBookmarked()){
            return
        }
        if(isBookmarkModel){
            val bookmark = BookmarkModel()
            bookmark.sourceId = id
            bookmark.sourceName = name
            bookmark.save()
        }else{
            val bookmarks = SugarRecord.find(
                BookmarkModel::class.java,
                "source_id = ?", id)
            bookmarks.forEach { it.delete() }
        }
    }
}