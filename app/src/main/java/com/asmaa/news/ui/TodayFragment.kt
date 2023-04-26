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
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TodayFragment : Fragment() {

    lateinit var progressBar: ProgressBar
    lateinit var viewPagger :ViewPager2
    lateinit var tabLayoutcountry: TabLayout

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
        tabLayoutcountry = requireView().findViewById(R.id.country_tablayout)
        viewPagger.adapter = adapter

        addNewsByCountry()
    }



    fun addNewsByCountry() {

        tabLayoutcountry.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {

                    var position = tab?.position

                    when (position) {
                        0 -> {
                            val country = SourcesItem(country = "eg")
                            getTopNews(country)

                        }
                        1 -> {
                            val country = SourcesItem(category = "ae")
                            getTopNews(country)
                        }
                        2 -> {
                            val country = SourcesItem(category = "ar")
                            getTopNews(country)
                        }
                        3 -> {
                            val country = SourcesItem(category = "bg")
                            getTopNews(country)
                        }
                        4 -> {
                            val country = SourcesItem(category = "br")
                            getTopNews(country)
                        }
                        5 -> {
                            val country = SourcesItem(category = "cn")
                            getTopNews(country)
                        }
                        6 -> {
                            val country = SourcesItem(category = "co")
                            getTopNews(country)
                        }
                        7 -> {
                            val country = SourcesItem(category = "de")
                            getTopNews(country)
                        }
                        8 -> {
                            val country = SourcesItem(category = "fr")
                            getTopNews(country)
                        }
                        9 -> {
                            val country = SourcesItem(category = "gr")
                            getTopNews(country)
                        }
                        10 -> {
                            val country = SourcesItem(category = "id")
                            getTopNews(country)
                        }
                        11 -> {
                            val country = SourcesItem(category = "in")
                            getTopNews(country)
                        }
                        12 -> {
                            val country = SourcesItem(category = "it")
                            getTopNews(country)
                        }
                        13 -> {
                            val country = SourcesItem(category = "jp")
                            getTopNews(country)
                        }
                        14 -> {
                            val country = SourcesItem(category = "kr")
                            getTopNews(country)
                        }
                        15 -> {
                            val country = SourcesItem(category = "ru")
                            getTopNews(country)
                        }
                        16 -> {
                            val country = SourcesItem(category = "Th")
                            getTopNews(country)
                        }
                        17 -> {
                            val country = SourcesItem(category = "tr")
                            getTopNews(country)
                        }
                        18 -> {
                            val country = SourcesItem(category = "za")
                            getTopNews(country)
                        }

                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {

                    var position = tab?.position

                    when (position) {
                        0 -> {
                            val country = SourcesItem(country = "eg")
                            getTopNews(country)

                        }
                        1 -> {
                            val country = SourcesItem(category = "ae")
                            getTopNews(country)
                        }
                        2 -> {
                            val country = SourcesItem(category = "ar")
                            getTopNews(country)
                        }
                        3 -> {
                            val country = SourcesItem(category = "bg")
                            getTopNews(country)
                        }
                        4 -> {
                            val country = SourcesItem(category = "br")
                            getTopNews(country)
                        }
                        5 -> {
                            val country = SourcesItem(category = "cn")
                            getTopNews(country)
                        }
                        6 -> {
                            val country = SourcesItem(category = "co")
                            getTopNews(country)
                        }
                        7 -> {
                            val country = SourcesItem(category = "de")
                            getTopNews(country)
                        }
                        8 -> {
                            val country = SourcesItem(category = "fr")
                            getTopNews(country)
                        }
                        9 -> {
                            val country = SourcesItem(category = "gr")
                            getTopNews(country)
                        }
                        10 -> {
                            val country = SourcesItem(category = "id")
                            getTopNews(country)
                        }
                        11 -> {
                            val country = SourcesItem(category = "in")
                            getTopNews(country)
                        }
                        12 -> {
                            val country = SourcesItem(category = "it")
                            getTopNews(country)
                        }
                        13 -> {
                            val country = SourcesItem(category = "jp")
                            getTopNews(country)
                        }
                        14 -> {
                            val country = SourcesItem(category = "kr")
                            getTopNews(country)
                        }
                        15 -> {
                            val country = SourcesItem(category = "ru")
                            getTopNews(country)
                        }
                        16 -> {
                            val country = SourcesItem(category = "Th")
                            getTopNews(country)
                        }
                        17 -> {
                            val country = SourcesItem(category = "tr")
                            getTopNews(country)
                        }
                        18 -> {
                            val country = SourcesItem(category = "za")
                            getTopNews(country)
                        }

                    }

                }
            }
        )
           tabLayoutcountry.getTabAt(0)?.select()

    }



    private fun getTopNews(country:SourcesItem) {
        progressBar.isVisible = true

        ApiManager
            .getApis()
            .getTopNews(Constans.API_KEY,country.country?:"")
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