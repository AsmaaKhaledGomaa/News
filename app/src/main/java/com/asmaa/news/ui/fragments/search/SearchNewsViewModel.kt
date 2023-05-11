package com.asmaa.news.ui.fragments.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.core.repo.searchnews.SearchNewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor(val searchNewsRepo: SearchNewsRepo):ViewModel() {

    val searchNewsLiveData = MutableLiveData<List<ArticlesItem?>?>()
    val progressBarLiveData = MutableLiveData<Boolean>()

    fun searchNews( search:String) {

        viewModelScope.launch {
            try {
                    progressBarLiveData.value = true

                val result = searchNewsRepo.searchNews(search)

                    progressBarLiveData.value = false

                    searchNewsLiveData.value=result

            } catch (ex: Exception) {
                progressBarLiveData.value = false

            }
        }
    }

}