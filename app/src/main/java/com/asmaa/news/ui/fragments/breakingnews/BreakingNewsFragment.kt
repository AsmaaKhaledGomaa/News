package com.asmaa.news.ui.fragments.breakingnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.asmaa.news.R
import com.asmaa.news.core.adapters.ViewPaggerAdapter
import com.asmaa.news.databinding.FragmentBreakingNewsBinding
import com.asmaa.news.core.models.ArticlesItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BreakingNewsFragment : Fragment() {

    lateinit var viewDataBinding : FragmentBreakingNewsBinding
    lateinit var viewModel: BreakingNewsViewModel

    @Inject lateinit var adapter : ViewPaggerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[BreakingNewsViewModel::class.java]
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_breaking_news,container,false)
        return viewDataBinding.root
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewDataBinding.viewPager.adapter = adapter
        viewDataBinding.dotsIndicator.attachTo(viewDataBinding.viewPager)

        subscribeToLiveData()

        //addNewsByCountry()
        viewModel.getTopNews()
    }

    fun subscribeToLiveData(){

        viewModel.topnewsLiveData.observe(viewLifecycleOwner){
            changeDataNewsAdapter(it)
        }

        viewModel.progressbarLiveData.observe(viewLifecycleOwner){
            viewDataBinding.progressBarItem.isVisible = isVisible
        }

        viewModel.messageLiveData.observe(viewLifecycleOwner){ message ->

            Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
        }
    }


    private fun changeDataNewsAdapter(articles : List<ArticlesItem?>?){

        adapter.changeData(articles)
    }

}