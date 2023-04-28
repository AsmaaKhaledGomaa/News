package com.asmaa.news.ui.fragments

import android.os.Bundle
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
import com.asmaa.news.models.SourcesItem
import com.asmaa.news.models.SourcesResponse
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllNewsFragment : Fragment() {

    lateinit var progressBar: ProgressBar
    lateinit var recyclerView: RecyclerView
    lateinit var tabLayout: TabLayout
    lateinit var tabLayoutCategory: TabLayout

    var adapter = SourcesAdapter(null)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_news, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = requireView().findViewById(R.id.progress_bar)
        recyclerView = requireView().findViewById(R.id.recycle_view)
        tabLayout = requireView().findViewById(R.id.tab_layout)
        tabLayoutCategory = requireView().findViewById(R.id.tab_layout_items)
        recyclerView.adapter = adapter

        addSourcesByCategory()

    }


    fun addSourcesByCategory() {

        tabLayoutCategory.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {

                    var position = tab?.position

                    when (position) {
                        0 -> {
                            val category = SourcesItem(category = "general")
                            getSources(category)

                        }
                        1 -> {
                            val category = SourcesItem(category = "business")
                            getSources(category)
                        }
                        2 -> {
                            val category = SourcesItem(category = "entertainment")
                            getSources(category)
                        }
                        3 -> {
                            val category = SourcesItem(category = "health")
                            getSources(category)
                        }
                        4 -> {
                            val category = SourcesItem(category = "science")
                            getSources(category)
                        }
                        5 -> {
                            val category = SourcesItem(category = "sports")
                            getSources(category)
                        }
                        6 -> {
                            val category = SourcesItem(category = "technology")
                            getSources(category)
                        }

                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {

                    var position = tab?.position

                    when (position) {
                        0 -> {
                            val category = SourcesItem(category = "general")
                            getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        1 -> {
                            val category = SourcesItem(category = "business")
                            tabLayout.getTabAt(0)?.select()
                            getSources(category)
                        }
                        2 -> {
                            val category = SourcesItem(category = "entertainment")
                            getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        3 -> {
                            val category = SourcesItem(category = "health")
                            getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        4 -> {
                            val category = SourcesItem(category = "science")
                            getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        5 -> {
                            val category = SourcesItem(category = "sports")
                            getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        6 -> {
                            val category = SourcesItem(category = "technology")
                            getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                    }
                }
            }
        )
        tabLayoutCategory.getTabAt(0)?.select()

    }


    fun getSources(category: SourcesItem) {
        ApiManager
            .getApis()
            .getSources(Constans.API_KEY, category?.category?:"")
            .enqueue(object : Callback<SourcesResponse> {
                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
                   // Log.e("error", t.localizedMessage)
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

        tabLayout.removeAllTabs()
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
        tabLayout.getTabAt(0)?.select()

    }


    private fun getNewsBySources(source: SourcesItem) {
        adapter.changeData(null)
        progressBar.isVisible = true

        ApiManager
            .getApis()
            .getNews(Constans.API_KEY, source.id ?: "")
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