package com.asmaa.news.core.repo.searchnews

import com.asmaa.news.core.models.ArticlesItem

interface SearchNewsRepo {

   suspend fun searchNews( search: String):List<ArticlesItem?>?

}