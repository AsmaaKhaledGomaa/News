package com.asmaa.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.R
import com.asmaa.news.models.ArticlesItem
import com.bumptech.glide.Glide

class ViewPaggerAdapter( var items: List<ArticlesItem?>?)
    :RecyclerView.Adapter<ViewPaggerAdapter.ViewHolder>(){

    class ViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){

        val titlenews: TextView = itemView.findViewById(R.id.news_title_Text)
        val author: TextView = itemView.findViewById(R.id.author_pagger)
        val datetime: TextView = itemView.findViewById(R.id.time_pagger)
        val imageview: ImageView = itemView.findViewById(R.id.image_pagger_news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpagger, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)
        holder.titlenews.setText(item?.title)
        holder.author.setText(item?.author)
        holder.datetime.setText(item?.publishedAt)

        Glide.with(holder.itemView)
            .load(item?.urlToImage)
            .into(holder.imageview)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    fun changeData( data : List<ArticlesItem?>?) {
        items = data
        notifyDataSetChanged()

    }
}