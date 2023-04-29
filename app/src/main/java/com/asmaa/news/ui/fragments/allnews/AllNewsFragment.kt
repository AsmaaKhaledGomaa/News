package com.asmaa.news.ui.fragments.allnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.R
import com.asmaa.news.adapters.SourcesAdapter
import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.models.SourcesItem
import com.google.android.material.tabs.TabLayout


class AllNewsFragment : Fragment() {

    lateinit var viewModel: AllNewsViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    lateinit var tabLayout: TabLayout
    private lateinit var tabLayoutCategory: TabLayout
    var adapter = SourcesAdapter(null)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AllNewsViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_news, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = requireView().findViewById(R.id.progress_bar)
        this.recyclerView = requireView().findViewById(R.id.recycle_view)
        tabLayout = requireView().findViewById(R.id.tab_layout)
        this.tabLayoutCategory = requireView().findViewById(R.id.tab_layout_items)
        recyclerView.adapter = adapter

        subscribeToLiveData()
        addSourcesByCategory()

    }

    private fun subscribeToLiveData() {

        viewModel.sourcesLiveData.observe(viewLifecycleOwner) {
            addSourcestoTabLayout(it)
        }

        viewModel.newsLiveData.observe(viewLifecycleOwner) {
            changeDataNewsAdapter(it)
        }

    }

    private fun changeDataNewsAdapter(articles : List<ArticlesItem?>?){

        adapter.changeData(articles)
    }


    private fun addSourcesByCategory() {

        tabLayoutCategory.addOnTabSelectedListener(
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
                            tabLayout.getTabAt(0)?.select()
                        }
                        1 -> {
                            val category = SourcesItem(category = "business")
                            tabLayout.getTabAt(0)?.select()
                            viewModel.getSources(category)
                        }
                        2 -> {
                            val category = SourcesItem(category = "entertainment")
                            viewModel.getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        3 -> {
                            val category = SourcesItem(category = "health")
                            viewModel.getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        4 -> {
                            val category = SourcesItem(category = "science")
                            viewModel.getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        5 -> {
                            val category = SourcesItem(category = "sports")
                            viewModel.getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                        6 -> {
                            val category = SourcesItem(category = "technology")
                            viewModel.getSources(category)
                            tabLayout.getTabAt(0)?.select()
                        }
                    }
                }
            }
        )
        tabLayoutCategory.getTabAt(0)?.select()

    }

    private fun addSourcestoTabLayout(Sources: List<SourcesItem?>?) {

        tabLayout.removeAllTabs()
        Sources?.forEach {
            val tab = tabLayout.newTab()
            tab.text = it?.name
            tab.tag = it
            tabLayout.addTab(tab)
        }
        tabLayout.addOnTabSelectedListener(
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
        tabLayout.getTabAt(0)?.select()

    }

}