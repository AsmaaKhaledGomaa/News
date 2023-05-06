package com.asmaa.news.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.news.R
import com.asmaa.news.databinding.ItemViewpaggerBinding
import com.asmaa.news.models.ArticlesItem
import com.bumptech.glide.Glide



class ViewPaggerAdapter( var items: List<ArticlesItem?>? = null) :RecyclerView.Adapter<ViewPaggerAdapter.ViewHolder>(){

    class ViewHolder (val itemViewBinding:ItemViewpaggerBinding) : RecyclerView.ViewHolder(itemViewBinding.root){

        fun bind(item: ArticlesItem?){
            itemViewBinding.viewpagger=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

      val viewBinding: ItemViewpaggerBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_viewpagger,parent,false)
            return ViewHolder(viewBinding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)
        holder.bind(item)

//        setOnItemClickListener {
//            onItemClickListener?.let {
//                it(item!!)
//            }
//        }
        Glide.with(holder.itemView)
            .load(item?.urlToImage)
            .placeholder(R.drawable.animation_progressbar)
            .error(R.drawable.animation_progressbar)
            .into(holder.itemViewBinding.imagePaggerNews)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    fun changeData(data : List<ArticlesItem?>?) {
        items = data
        notifyDataSetChanged()

    }

    private var onItemClickListener : ((ArticlesItem) -> Unit)?= null

    fun setOnItemClickListener( listener: ((ArticlesItem) -> Unit)){
        onItemClickListener = listener
    }
}