package com.asmaa.news.ui.fragments.artical

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.asmaa.news.R
import com.asmaa.news.databinding.FragmentArticalBinding
import com.asmaa.news.databinding.FragmentSearchNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticalFragment : Fragment() {

    lateinit var viewDataBinding: FragmentArticalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_artical,container,false)
        return viewDataBinding.root    }

}