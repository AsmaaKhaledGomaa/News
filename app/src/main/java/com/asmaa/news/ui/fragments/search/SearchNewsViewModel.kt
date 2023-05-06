package com.asmaa.news.ui.fragments.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asmaa.news.models.ArticlesItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor():ViewModel() {

    val searchNewsLiveData = MutableLiveData<List<ArticlesItem?>?>()
    val progressBarLiveData = MutableLiveData<Boolean>()

    fun searchNews() {

        viewModelScope.launch {
            try {
                progressBarLiveData.value = true

               // val result =

                    progressBarLiveData.value = false


            } catch (ex: Exception) {
                progressBarLiveData.value = false

            }

        }

    }

}