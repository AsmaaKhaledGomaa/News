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


class SourcesAdapter( var items: List<ArticlesItem?>?) : RecyclerView.Adapter<SourcesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val author: TextView = itemView.findViewById(R.id.author)
        val datetime: TextView = itemView.findViewById(R.id.datetime)
        val imageview: ImageView = itemView.findViewById(R.id.imageview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)

        holder.title.setText(item?.title)
        holder.author.setText(item?.author)
        holder.datetime.setText(item?.publishedAt)

        Glide.with(holder.itemView)
            .load(item?.urlToImage)
            .into(holder.imageview)
    }

    fun changeData( data : List<ArticlesItem?>?) {
        items = data
        notifyDataSetChanged()

    }
}