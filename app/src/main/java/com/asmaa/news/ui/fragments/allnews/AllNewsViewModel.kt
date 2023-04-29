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
    val progressbarVisible = MutableLiveData<Boolean>()
    val messageLiveData = MutableLiveData<String>()



    fun getSources(category: SourcesItem) {
        ApiManager
            .getApis()
            .getSources(Constans.API_KEY, category.category ?:"")
            .enqueue(object : Callback<SourcesResponse> {
                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
                    // Log.e("error", t.localizedMessage)
                    messageLiveData.value = t.localizedMessage
                    progressbarVisible.value = false
                }

                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    progressbarVisible.value = false

                    sourcesLiveData.value = response.body()?.sources
                }
            })
    }

    fun getNewsBySources(source: SourcesItem) {
        progressbarVisible.value = true

        ApiManager
            .getApis()
            .getNews(Constans.API_KEY, source.id ?: "")
            .enqueue(object : Callback<NewsResponse> {

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    messageLiveData.value = t.localizedMessage

                    progressbarVisible.value = false
                }

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>

                ) {
                    progressbarVisible.value = false

                    newsLiveData.value = response.body()?.articles

                   // adapter.changeData(response.body()?.articles)
                }
            })
    }

}