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
import com.asmaa.news.adapters.ViewPaggerAdapter
import com.asmaa.news.databinding.FragmentBreakingNewsBinding
import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.models.SourcesItem
import com.google.android.material.tabs.TabLayout


class BreakingNewsFragment : Fragment() {

    lateinit var viewDataBinding : FragmentBreakingNewsBinding
    lateinit var viewModel: BreakingNewsViewModel

    var adapter = ViewPaggerAdapter(null)



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

//    private fun addNewsByCountry() {
//
//        viewDataBinding.countryTablayout.addOnTabSelectedListener(
//            object : TabLayout.OnTabSelectedListener {
//
//                override fun onTabSelected(tab: TabLayout.Tab?) {
//
//                    when (tab?.position) {
//                        0 -> {
//                            val country = SourcesItem(country = "us")
//                            viewModel.getTopNews(country)
//
//                        }
//                        1 -> {
//                            val country = SourcesItem(country = "ae")
//                            viewModel.getTopNews(country)
//                        }
//                        2 -> {
//                            val country = SourcesItem(country = "ar")
//                            viewModel.getTopNews(country)
//                        }
//                        3 -> {
//                            val country = SourcesItem(country = "bg")
//                            viewModel.getTopNews(country)
//                        }
//                        4 -> {
//                            val country = SourcesItem(country = "br")
//                            viewModel.getTopNews(country)
//                        }
//                        5 -> {
//                            val country = SourcesItem(country = "cn")
//                            viewModel.getTopNews(country)
//                        }
//                        6 -> {
//                            val country = SourcesItem(country = "co")
//                            viewModel.getTopNews(country)
//                        }
//                        7 -> {
//                            val country = SourcesItem(country = "de")
//                            viewModel.getTopNews(country)
//                        }
//                        8 -> {
//                            val country = SourcesItem(country = "fr")
//                            viewModel.getTopNews(country)
//                        }
//                        9 -> {
//                            val country = SourcesItem(country = "gr")
//                            viewModel.getTopNews(country)
//                        }
//                        10 -> {
//                            val country = SourcesItem(country = "id")
//                            viewModel.getTopNews(country)
//                        }
//                        11 -> {
//                            val country = SourcesItem(country = "in")
//                            viewModel.getTopNews(country)
//                        }
//                        12 -> {
//                            val country = SourcesItem(country = "it")
//                            viewModel.getTopNews(country)
//                        }
//                        13 -> {
//                            val country = SourcesItem(country = "jp")
//                            viewModel.getTopNews(country)
//                        }
//                        14 -> {
//                            val country = SourcesItem(country = "kr")
//                            viewModel.getTopNews(country)
//                        }
//                        15 -> {
//                            val country = SourcesItem(country = "ru")
//                            viewModel.getTopNews(country)
//                        }
//                        16 -> {
//                            val country = SourcesItem(country = "Th")
//                            viewModel.getTopNews(country)
//                        }
//                        17 -> {
//                            val country = SourcesItem(country = "tr")
//                            viewModel.getTopNews(country)
//                        }
//                        18 -> {
//                            val country = SourcesItem(country = "za")
//                            viewModel.getTopNews(country)
//                        }
//                    }
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab?) {}
//
//                override fun onTabReselected(tab: TabLayout.Tab?) {
//
//                    when (tab?.position) {
//                        0 -> {
//                            val country = SourcesItem(country = "us")
//                            viewModel.getTopNews(country)
//
//                        }
//                        1 -> {
//                            val country = SourcesItem(country = "ae")
//                            viewModel.getTopNews(country)
//                        }
//                        2 -> {
//                            val country = SourcesItem(country = "ar")
//                            viewModel.getTopNews(country)
//                        }
//                        3 -> {
//                            val country = SourcesItem(country = "bg")
//                            viewModel.getTopNews(country)
//                        }
//                        4 -> {
//                            val country = SourcesItem(country = "br")
//                            viewModel.getTopNews(country)
//                        }
//                        5 -> {
//                            val country = SourcesItem(country = "cn")
//                            viewModel.getTopNews(country)
//                        }
//                        6 -> {
//                            val country = SourcesItem(country = "co")
//                            viewModel.getTopNews(country)
//                        }
//                        7 -> {
//                            val country = SourcesItem(country = "de")
//                            viewModel.getTopNews(country)
//                        }
//                        8 -> {
//                            val country = SourcesItem(country = "fr")
//                            viewModel.getTopNews(country)
//                        }
//                        9 -> {
//                            val country = SourcesItem(country = "gr")
//                            viewModel.getTopNews(country)
//                        }
//                        10 -> {
//                            val country = SourcesItem(country = "id")
//                            viewModel.getTopNews(country)
//                        }
//                        11 -> {
//                            val country = SourcesItem(country = "in")
//                            viewModel.getTopNews(country)
//                        }
//                        12 -> {
//                            val country = SourcesItem(country = "it")
//                            viewModel.getTopNews(country)
//                        }
//                        13 -> {
//                            val country = SourcesItem(country = "jp")
//                            viewModel.getTopNews(country)
//                        }
//                        14 -> {
//                            val country = SourcesItem(country = "kr")
//                            viewModel.getTopNews(country)
//                        }
//                        15 -> {
//                            val country = SourcesItem(country = "ru")
//                            viewModel.getTopNews(country)
//                        }
//                        16 -> {
//                            val country = SourcesItem(country = "Th")
//                            viewModel.getTopNews(country)
//                        }
//                        17 -> {
//                            val country = SourcesItem(country = "tr")
//                            viewModel.getTopNews(country)
//                        }
//                        18 -> {
//                            val country = SourcesItem(country = "za")
//                            viewModel.getTopNews(country)
//                        }
//
//                    }
//                }
//            }
//        )
//         viewDataBinding.countryTablayout.getTabAt(0)?.select()
//   }

}