package com.example.tarea2_aplicacionesmoviles.responses

import com.example.tarea2_aplicacionesmoviles.models.SourceModel

class SourcesResponse {
    var status: String = ""
    var code: String? = null
    var message: String? = null
    var sources:ArrayList<SourceModel>? = null
}