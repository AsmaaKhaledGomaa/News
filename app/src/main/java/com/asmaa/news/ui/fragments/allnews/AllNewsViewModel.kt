package com.asmaa.news.ui.fragments.allnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.core.models.SourcesItem
import com.asmaa.news.core.repo.allnews.news.NewsRepo
import com.asmaa.news.core.repo.allnews.sources.SourcesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception


@HiltViewModel
class AllNewsViewModel @Inject constructor(val newsRepo: NewsRepo, val sourcesRepo: SourcesRepo) : ViewModel() {


    val sourcesLiveData = MutableLiveData<List<SourcesItem?>?>()
    val newsLiveData = MutableLiveData<List<ArticlesItem?>?>()
    val progressbarVisible = MutableLiveData<Boolean>()
    val messageLiveData = MutableLiveData<String>()


    fun getSources(sources: SourcesItem) {

        viewModelScope.launch {
            try {
                progressbarVisible.value = true

                val result = sourcesRepo.getSourcesR(sources.category ?: "")

                progressbarVisible.value = false

                sourcesLiveData.value = result
//                Timber.tag("error").i(category.category)

            } catch (ex: Exception) {
                progressbarVisible.value = false
            }
        }
    }


    fun getNewsBySources(source: SourcesItem) {

        viewModelScope.launch {
            try {
                progressbarVisible.value = true
                val result = newsRepo.getNewsR(source.id.toString())
                progressbarVisible.value = false
                newsLiveData.value = result
            } catch (ex: Exception) {
                progressbarVisible.value = false
            }
        }

    }
}