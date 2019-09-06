package com.example.tarea2_aplicacionesmoviles.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tarea2_aplicacionesmoviles.R
import com.example.tarea2_aplicacionesmoviles.activities.ArticleActivity
import com.example.tarea2_aplicacionesmoviles.models.ArticleModel
import kotlinx.android.synthetic.main.item_article.view.*

class ArticlesAdapter(var articles: ArrayList<ArticleModel>, val context: Context) :
        RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_article, parent, false))
    }

    override fun getItemCount() : Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val article = articles.get(position)
        holder.updateFrom(article)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pictureImageView = view.pictureImageView
        val titleTextView = view.titleTextView
        val artileLayout = view.articleLayout

        fun updateFrom(article: ArticleModel){
            pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            pictureImageView.setErrorImageResId(R.mipmap.ic_launcher)
            pictureImageView.setImageUrl(article.urlToImage)
            titleTextView.text = article.title
            artileLayout.setOnClickListener { view ->
                val context = view.context
                context.startActivity(
                    Intent(context, ArticleActivity::class.java)
                        .putExtras(article.toBundle()))
            }
        }
    }
}