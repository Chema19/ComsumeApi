package com.example.tarea2_aplicacionesmoviles.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tarea2_aplicacionesmoviles.R
import com.example.tarea2_aplicacionesmoviles.activities.SourceActivity
import com.example.tarea2_aplicacionesmoviles.models.SourceModel
import kotlinx.android.synthetic.main.item_source.view.*

class SourcesAdapter(var sources: ArrayList<SourceModel>, val context: Context) : RecyclerView.Adapter<SourcesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_source, parent, false))
    }

    override fun getItemCount() : Int {
        return sources.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val source = sources.get(position)
        holder.updateFrom(source)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.nameTextView
        val logoImageView = view.logoImageView
        val sourceLayout = view.sourceLayout
        val bookmarkImageView = view.bookmarkImageView

        fun updateFrom(source: SourceModel) {
            nameTextView.text = source.name
            logoImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            logoImageView.setErrorImageResId(R.mipmap.ic_launcher)
            logoImageView.setImageUrl(source.urlToLogo())
            bookmarkImageView.setImageResource(imageResourceFor(source.isBookmarked()))
            sourceLayout.setOnClickListener { view ->
                val context = view.context
                context.startActivity(Intent(context, SourceActivity::class.java)
                    .putExtras(source.toBundle()))
            }
        }

        fun imageResourceFor(isBoomarked: Boolean) : Int {
            return if (isBoomarked) {
                R.drawable.ic_bookmark_black_24dp
            } else {
                R.drawable.ic_bookmark_border_black_24dp
            }
        }


    }
}