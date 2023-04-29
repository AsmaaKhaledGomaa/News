package com.asmaa.news.ui.fragments.allnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asmaa.news.Constans
import com.asmaa.news.api.ApiManager
import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.models.NewsResponse
import com.asmaa.news.models.SourcesItem
import com.asmaa.news.models.SourcesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllNewsViewModel : ViewModel(){


    val sourcesLiveData = MutableLiveData<List<SourcesItem?>?>()
    val newsLiveData = MutableLiveData<List<ArticlesItem?>?>()



    fun getSources(category: SourcesItem) {
        ApiManager
            .getApis()
            .getSources(Constans.API_KEY, category?.category?:"")
            .enqueue(object : Callback<SourcesResponse> {
                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
                    // Log.e("error", t.localizedMessage)
                  //  progressBar.isVisible = false
                }

                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                  //  progressBar.isVisible = false

                    sourcesLiveData.value = response.body()?.sources
                   // addSourcestoTabLayout(response.body()?.sources)

                    // Log.e("data",response.body().toString())
                }
            })
    }

    fun getNewsBySources(source: SourcesItem) {
      //  progressBar.isVisible = true

        ApiManager
            .getApis()
            .getNews(Constans.API_KEY, source.id ?: "")
            .enqueue(object : Callback<NewsResponse> {

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                   // progressBar.isVisible = false
                }

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>

                ) {
                    newsLiveData.value = response.body()?.articles

                   // progressBar.isVisible = false
                   // adapter.changeData(response.body()?.articles)
                }
            })
    }

}