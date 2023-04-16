package com.asmaa.news.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.Constans
import com.asmaa.news.R
import com.asmaa.news.adapters.SourcesAdapter
import com.asmaa.news.api.ApiManager
import com.asmaa.news.models.NewsResponse
import com.asmaa.news.models.Source
import com.asmaa.news.models.SourcesItem
import com.asmaa.news.models.SourcesResponse
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsFragment : Fragment() {

    lateinit var progressBar: ProgressBar
    lateinit var recyclerView: RecyclerView
    lateinit var tabLayout: TabLayout
    var adapter = SourcesAdapter(null)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = requireView().findViewById(R.id.progress_bar)
        recyclerView = requireView().findViewById(R.id.recycle_view)
        tabLayout = requireView().findViewById(R.id.tab_layout)
        recyclerView.adapter = adapter
        // initViews()
        getNewsSources()

    }

    fun getNewsSources() {
        ApiManager
            .getApis()
            .getSources(Constans.API_KEY)
            .enqueue(object : Callback<SourcesResponse> {
                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
                    Log.e("error", t.localizedMessage)
                    progressBar.isVisible = false
                }

                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    progressBar.isVisible = false
                    addSourcestoTabLayout(response.body()?.sources)
                    // Log.e("data",response.body().toString())
                }
            })
    }

    private fun addSourcestoTabLayout(Sources: List<SourcesItem?>?) {
       Sources?.forEach {
            val tab = tabLayout.newTab()
            tab.setText(it?.name)
            tab.tag = it
            tabLayout.addTab(tab)
        }
        tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    //  val source = listLanguages?.get(tab?.position?:0)
                    val source = tab?.tag as SourcesItem
                    getNewsBySources(source)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }


                override fun onTabReselected(tab: TabLayout.Tab?) {
                    val source = tab?.tag as SourcesItem
                    getNewsBySources(source)
                }
            })

        //tabLayout.getTabAt(0)?.select()

    }

    private fun getNewsBySources(source: SourcesItem) {
        progressBar.isVisible = true

        ApiManager
            .getApis()
            .getNews(Constans.API_KEY,source.id?:"" )
            .enqueue(object :Callback<NewsResponse>{

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