package com.sample.sealed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_banner.view.*
import kotlinx.android.synthetic.main.item_body.view.*

/*
* Created by yothinindy on 2019-08-25.
*/

class MultipleTypeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var multipleTypeList: MutableList<MultipleTypeModal>

    override fun getItemViewType(position: Int): Int {
        return multipleTypeList[position].type

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TypeView.HEADER -> {
                HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false))
            }
            TypeView.BODY -> {
                BodyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_body, parent, false))
            }
            TypeView.ADS -> {
                AdsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false))
            }
            else -> throw Exception("ViewType $viewType")
        }
    }


    override fun getItemCount(): Int = multipleTypeList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val multipleType = multipleTypeList[position]
        when (holder) {
            is HeaderViewHolder -> {
                holder.bind(multipleType as Header)
            }
            is BodyViewHolder -> {
                holder.bind(multipleType as Body)
            }
            is AdsViewHolder -> {
                holder.bind()
            }
        }
    }

    fun setData(multipleTypeList: MutableList<MultipleTypeModal>) {
        this.multipleTypeList = multipleTypeList
        notifyDataSetChanged()
    }

}

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(header: Header) = with(itemView) {
        headerTextView.text = header.header
    }
}

class BodyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(body: Body) = with(itemView) {
        startImageView.setImageResource(body.imageStartRes)
        endImageView.setImageResource(body.imageEndRes)
        titleStartTextView.text = body.typeStartMusic
        titleEndTextView.text = body.typeEndMusic
    }
}

class AdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind() {}
}