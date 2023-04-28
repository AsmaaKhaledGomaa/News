package com.asmaa.news.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.Constans
import com.asmaa.news.R
import com.asmaa.news.adapters.SearchAdapter
import com.asmaa.news.api.ApiManager
import com.asmaa.news.models.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchNewsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
   // lateinit var searchView: SearchView
    lateinit var progressBar: ProgressBar

    var adapter = SearchAdapter(null)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search_news, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.Search_recycleView)
        progressBar = requireView().findViewById(R.id.progress_bar_search)

        recyclerView.adapter = adapter

      //  searchView = requireView().findViewById(R.id.SearchView)
     //   searchView.clearFocus()

//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchView.clearFocus()
//
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//
//                return false
//            }
//        })

        getallNews()

    }

    private fun getallNews() {
        progressBar.isVisible = true

        ApiManager
            .getApis()
            .getallNews(Constans.API_KEY,"bitcoin")
            .enqueue(object : Callback<NewsResponse> {

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    progressBar.isVisible = false
                }

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    progressBar.isVisible = false
                    adapter.changeData(response.body()?.articles)

                }
            })
        }
}