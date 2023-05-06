package com.asmaa.news.ui.fragments.allnews

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
import com.asmaa.news.adapters.NewsAdapter
import com.asmaa.news.databinding.FragmentAllNewsBinding
import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.models.SourcesItem
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AllNewsFragment : Fragment() {

    lateinit var viewDataBindingall: FragmentAllNewsBinding

    lateinit var viewModel: AllNewsViewModel

    @Inject lateinit var adapter : NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AllNewsViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewDataBindingall = DataBindingUtil.inflate(inflater,R.layout.fragment_all_news,container,false)
        return viewDataBindingall.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       viewDataBindingall.recycleView.adapter = adapter

        getSourcesByCategory()

        subscribeToLiveData()

    }

    private fun subscribeToLiveData() {

        viewModel.sourcesLiveData.observe(viewLifecycleOwner) {
            addSourcestoTabLayout(it)
        }

        viewModel.newsLiveData.observe(viewLifecycleOwner) {
            changeDataNewsAdapter(it)
        }

        viewModel.progressbarVisible.observe(viewLifecycleOwner){ isVisible ->

            viewDataBindingall.progressBar.isVisible = isVisible
        }

        viewModel.messageLiveData.observe(viewLifecycleOwner){ message ->

            Toast.makeText(activity,message,Toast.LENGTH_LONG).show()

        }

    }

    private fun changeDataNewsAdapter(articles : List<ArticlesItem?>?){

        adapter.changeData(articles)
    }


    private fun getSourcesByCategory() {

        viewDataBindingall.tabLayoutCategory.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {

                    when (tab?.position) {
                        0 -> {
                            val category = SourcesItem(category = "general")
                            viewModel.getSources(category)

                        }
                        1 -> {
                            val category = SourcesItem(category = "business")
                            viewModel.getSources(category)
                        }
                        2 -> {
                            val category = SourcesItem(category = "entertainment")
                            viewModel.getSources(category)
                        }
                        3 -> {
                            val category = SourcesItem(category = "health")
                            viewModel.getSources(category)
                        }
                        4 -> {
                            val category = SourcesItem(category = "science")
                            viewModel.getSources(category)
                        }
                        5 -> {
                            val category = SourcesItem(category = "sports")
                            viewModel.getSources(category)
                        }
                        6 -> {
                            val category = SourcesItem(category = "technology")
                            viewModel.getSources(category)
                        }

                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {

                    when (tab?.position) {
                        0 -> {
                            val category = SourcesItem(category = "general")
                            viewModel.getSources(category)
                            viewDataBindingall.tabLayout.getTabAt(0)?.select()
                        }
                        1 -> {
                            val category = SourcesItem(category = "business")
                            viewDataBindingall.tabLayout.getTabAt(0)?.select()
                            viewModel.getSources(category)
                        }
                        2 -> {
                            val category = SourcesItem(category = "entertainment")
                            viewModel.getSources(category)
                            viewDataBindingall.tabLayout.getTabAt(0)?.select()
                        }
                        3 -> {
                            val category = SourcesItem(category = "health")
                            viewModel.getSources(category)
                            viewDataBindingall.tabLayout.getTabAt(0)?.select()
                        }
                        4 -> {
                            val category = SourcesItem(category = "science")
                            viewModel.getSources(category)
                            viewDataBindingall.tabLayout.getTabAt(0)?.select()
                        }
                        5 -> {
                            val category = SourcesItem(category = "sports")
                            viewModel.getSources(category)
                            viewDataBindingall.tabLayout.getTabAt(0)?.select()
                        }
                        6 -> {
                            val category = SourcesItem(category = "technology")
                            viewModel.getSources(category)
                            viewDataBindingall.tabLayout.getTabAt(0)?.select()
                        }
                    }
                }
            }
        )
        viewDataBindingall.tabLayoutCategory.getTabAt(0)?.select()

    }

     fun addSourcestoTabLayout(Sources: List<SourcesItem?>?) {

       // viewDataBindingall.tabLayout.removeAllTabs()
        Sources?.forEach {
            val tab = viewDataBindingall.tabLayout.newTab()
            tab.text = it?.name
            tab.tag = it
            viewDataBindingall.tabLayout.addTab(tab)
        }
        viewDataBindingall.tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    //  val source = listLanguages?.get(tab?.position?:0)
                    val source = tab?.tag as SourcesItem
                  viewModel.getNewsBySources(source)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    val source = tab?.tag as SourcesItem

                    adapter.changeData(null)

                    viewModel.getNewsBySources(source)
                }
            })
        viewDataBindingall.tabLayout.getTabAt(0)?.select()

    }

}