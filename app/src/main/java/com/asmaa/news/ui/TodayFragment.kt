package com.asmaa.news.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.asmaa.news.Constans
import com.asmaa.news.R
import com.asmaa.news.adapters.SourcesAdapter
import com.asmaa.news.adapters.ViewPaggerAdapter
import com.asmaa.news.api.ApiManager
import com.asmaa.news.models.NewsResponse
import com.asmaa.news.models.SourcesItem
import com.asmaa.news.models.SourcesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TodayFragment : Fragment() {

    lateinit var progressBar: ProgressBar
    lateinit var viewPagger :ViewPager2
    //lateinit var adapter: ViewPaggerAdapter
    var adapter = ViewPaggerAdapter(null)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_today, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = requireView().findViewById(R.id.progress_bar_item)
        viewPagger = requireView().findViewById(R.id.viewPager)
        viewPagger.adapter = adapter

        getTopNews()
    }


    private fun getTopNews() {
        progressBar.isVisible = true

        ApiManager
            .getApis()
            .getTopNews(Constans.API_KEY,"us")
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