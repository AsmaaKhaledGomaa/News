package com.asmaa.news.ui.fragments.breakingnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asmaa.news.Constans
import com.asmaa.news.api.ApiManager
import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.models.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreakingNewsViewModel : ViewModel() {

    val topnewsLiveData = MutableLiveData<List<ArticlesItem?>?>()
    val progressbarLiveData = MutableLiveData<Boolean>()
    val messageLiveData = MutableLiveData<String>()


    fun getTopNews() {
     //   adapter.changeData(null)
        progressbarLiveData.value = true

        ApiManager
            .getApis()
            .getTopNews(Constans.API_KEY,"us")
            .enqueue(object : Callback<NewsResponse> {

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    progressbarLiveData.value = false
                    messageLiveData.value = t.localizedMessage


                }

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    progressbarLiveData.value = false
                    topnewsLiveData.value = response.body()?.articles
                    //adapter.changeData(response.body()?.articles)

                }
            })
    }

}