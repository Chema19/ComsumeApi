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
import com.example.tarea2_aplicacionesmoviles.adapters.SourcesAdapter
import com.example.tarea2_aplicacionesmoviles.models.SourceModel
import com.example.tarea2_aplicacionesmoviles.network.NewsApi
import com.example.tarea2_aplicacionesmoviles.responses.SourcesResponse
import kotlinx.android.synthetic.main.fragment_source.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SourceFragment : Fragment() {

    lateinit var sourcesRecyclerView: RecyclerView
    lateinit var sources: ArrayList<SourceModel>
    lateinit var sourcesAdapter: SourcesAdapter
    lateinit var sourcesLayoutManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_source, container, false)
        sourcesRecyclerView = view.sourcesRecyclerView
        sources = ArrayList()
        sourcesAdapter = SourcesAdapter(sources, view.context)
        sourcesLayoutManager = GridLayoutManager(view.context, 1)
        sourcesRecyclerView.adapter = sourcesAdapter
        sourcesRecyclerView.layoutManager = sourcesLayoutManager
        NewsApi.requestSources(getString(R.string.news_api_key),
            { response -> handleResponse(response)},
            { error -> handleError(error)})
        return view
    }

    private fun handleResponse(response: SourcesResponse?) {
        if ("error".equals(response!!.status, true)) {
            Log.d("Tarea", response.message)
            return
        }
        sources = response.sources!!
        sourcesAdapter.sources = sources
        sourcesAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?) {
        Log.d("Tarea", anError!!.message)
    }


}
