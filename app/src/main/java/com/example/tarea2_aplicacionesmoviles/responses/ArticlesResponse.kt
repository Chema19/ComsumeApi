package com.example.tarea2_aplicacionesmoviles.responses

import com.example.tarea2_aplicacionesmoviles.models.ArticleModel

class ArticlesResponse {
    var status: String = ""
    var code: String? = null
    var message: String? = null
    var totalResult: Int? = null
    var articles: ArrayList<ArticleModel>? = null
}