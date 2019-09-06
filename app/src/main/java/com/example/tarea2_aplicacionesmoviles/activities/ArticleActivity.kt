package com.example.tarea2_aplicacionesmoviles.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tarea2_aplicacionesmoviles.R
import com.example.tarea2_aplicacionesmoviles.models.ArticleModel
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.content_article.*

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = intent ?: return
        val article = ArticleModel.from(intent.extras)
        pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher)
        pictureImageView.setErrorImageResId(R.mipmap.ic_launcher)
        pictureImageView.setImageUrl(article.urlToImage)
        titleTextView.text = article.title
        descriptionTextView.text = article.description
    }
}
