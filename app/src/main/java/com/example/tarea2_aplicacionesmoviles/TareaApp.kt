package com.example.tarea2_aplicacionesmoviles

import com.androidnetworking.AndroidNetworking
import com.orm.SugarApp


class TareaApp : SugarApp() {
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(getApplicationContext())
    }
}