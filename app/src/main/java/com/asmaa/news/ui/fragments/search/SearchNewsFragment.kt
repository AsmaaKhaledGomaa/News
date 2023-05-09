package com.asmaa.news.ui.fragments.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.Constans
import com.asmaa.news.R
import com.asmaa.news.adapters.SearchAdapter
import com.asmaa.news.databinding.FragmentSearchNewsBinding
import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.models.NewsResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@AndroidEntryPoint
class SearchNewsFragment : Fragment() {

    lateinit var viewDataBinding: FragmentSearchNewsBinding
    lateinit var viewModel: SearchNewsViewModel

    @Inject lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SearchNewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_news,container,false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.SearchRecycleView.adapter = adapter

        var job: Job? = null
        viewDataBinding.SearchView.setOnSearchClickListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(500L)

                editable?.let {
                    editable.toString().isNotEmpty()
                    viewModel.searchNews(editable.toString())
                }
            }
        }

        subscribeToLiveData()

    }

    private fun subscribeToLiveData() {

        viewModel.searchNewsLiveData.observe(viewLifecycleOwner) {
            changeDataNewsAdapter(it)
        }

        viewModel.progressBarLiveData.observe(viewLifecycleOwner){
            viewDataBinding.progressBarSearch.isVisible = isVisible
        }
    }


    private fun changeDataNewsAdapter(articles : List<ArticlesItem?>?){

        adapter.changeData(articles)
    }
}

