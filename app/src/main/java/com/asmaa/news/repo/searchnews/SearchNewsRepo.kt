package com.asmaa.news.repo.searchnews

import com.asmaa.news.models.ArticlesItem

interface SearchNewsRepo {

   suspend fun searchNews( search: String):List<ArticlesItem?>?

}