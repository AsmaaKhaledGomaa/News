package com.asmaa.news.core.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.R
import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.databinding.ItemDiscoverBinding
import com.bumptech.glide.Glide


class DiscoverAdapter(var items: List<ArticlesItem?>?= null): RecyclerView.Adapter<DiscoverAdapter.ViewHolder>() {

    class ViewHolder(val itemViewBinding: ItemDiscoverBinding): RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(item: ArticlesItem?){
            itemViewBinding.discover=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewBinding : ItemDiscoverBinding =
            DataBindingUtil.inflate( LayoutInflater.from(parent.context), R.layout.item_discover,parent,false)
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
            .into(holder.itemViewBinding.imageviewDiscover)

    }

    fun changeData( data : List<ArticlesItem?>?) {
        items = data
        notifyDataSetChanged()

    }
}