package com.asmaa.news.ui.fragments.breakingnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.core.repo.home.breakingnews.BreakingNewsRepo
import com.asmaa.news.core.repo.home.discovernews.DiscoverNewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BreakingNewsViewModel @Inject constructor(val breakingNewsRepo: BreakingNewsRepo,val discoverNewsRepo: DiscoverNewsRepo): ViewModel() {

    val topnewsLiveData = MutableLiveData<List<ArticlesItem?>?>()
    val discoverLiveData =MutableLiveData<List<ArticlesItem?>?>()
    val progressbarLiveData = MutableLiveData<Boolean>()
    val messageLiveData = MutableLiveData<String>()


    fun getTopNews() {
        //   adapter.changeData(null)
       viewModelScope.launch{
           try {
               progressbarLiveData.value = true

               val result = breakingNewsRepo.getTopNewsR("us")

               progressbarLiveData.value = false

               topnewsLiveData.value = result

           } catch (ex: Exception) {
               progressbarLiveData.value = false
           }
       }
    }


    fun getDiscoverNews(){

        viewModelScope.launch {
            try {
                progressbarLiveData.value = true

                val result = discoverNewsRepo.getDiscoverNews()

                progressbarLiveData.value = false

                discoverLiveData.value = result

            } catch (ex: Exception) {
                progressbarLiveData.value = false
            }
        }

    }
}