package com.example.tarea2_aplicacionesmoviles.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError

import com.example.tarea2_aplicacionesmoviles.R
import com.example.tarea2_aplicacionesmoviles.adapters.ArticlesAdapter
import com.example.tarea2_aplicacionesmoviles.models.ArticleModel
import com.example.tarea2_aplicacionesmoviles.network.NewsApi
import com.example.tarea2_aplicacionesmoviles.responses.ArticlesResponse
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    var articles = ArrayList<ArticleModel>()
    lateinit var articlesRecyclerView: RecyclerView
    lateinit var articlesAdapter: ArticlesAdapter
    lateinit var articlesLayoutManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        articlesRecyclerView = view.articlesRecyclerView
        articlesAdapter = ArticlesAdapter(articles, view.context)
        articlesLayoutManager = GridLayoutManager(view.context, 1)
        articlesRecyclerView.adapter = articlesAdapter
        articlesRecyclerView.layoutManager = articlesLayoutManager

        NewsApi.requestHeadlines(getString(R.string.news_api_key),
            { response -> handleResponse(response)},
            { error -> handleError(error)})

        return view
    }

    private fun handleResponse(response: ArticlesResponse?) {
        val status = response!!.status
        if (status.equals("error", true)) {
            Log.d("Tarea", response.message)
            return
        }

        articles = response.articles!!
        Log.d("Tarea", "Found ${articles.size} articles")
        articlesAdapter.articles = articles
        articlesAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?) {
        Log.d("Tarea", anError!!.message)
    }

}


