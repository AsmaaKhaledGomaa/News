package com.asmaa.news.core.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.R
import com.asmaa.news.databinding.ItemNewsBinding
import com.asmaa.news.core.models.ArticlesItem
import com.bumptech.glide.Glide


class NewsAdapter(var items: List<ArticlesItem?>?= null): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val itemViewBinding:ItemNewsBinding): RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(item: ArticlesItem?){
            itemViewBinding.news = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewBinding : ItemNewsBinding =
            DataBindingUtil.inflate(LayoutInflater
                .from(parent.context),R.layout.item_news,parent,false)
        return ViewHolder(viewBinding)

    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.bind(item)

        Glide.with(holder.itemView)
            .load(item?.urlToImage)
            .placeholder(R.drawable.animation_progressbar)
            .error(R.drawable.animation_progressbar)
            .into(holder.itemViewBinding.imageview)

    }

    fun changeData( data : List<ArticlesItem?>?) {
        items = data
        notifyDataSetChanged()

    }
}