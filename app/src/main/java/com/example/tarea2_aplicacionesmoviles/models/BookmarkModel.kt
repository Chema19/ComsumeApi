package com.example.tarea2_aplicacionesmoviles.models

import com.orm.SugarRecord

public class BookmarkModel : SugarRecord() {
    var sourceId: String = ""
    var sourceName: String = ""
    companion object{
        fun sourceIdsAsString(): String{
            val bookmarks = SugarRecord.listAll(BookmarkModel::class.java)
            return bookmarks.joinToString{ bookmark -> bookmark.sourceId}
        }
        fun sourceNamesAsString(): String{
            val bookmarks = SugarRecord.listAll(BookmarkModel::class.java)
            return bookmarks.joinToString{ bookmark -> bookmark.sourceName}
        }
    }
}