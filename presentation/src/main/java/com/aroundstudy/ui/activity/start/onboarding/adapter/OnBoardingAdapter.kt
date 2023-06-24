package com.aroundstudy.ui.activity.start.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.databinding.ViewOnBoardingItemBinding

class OnBoardingAdapter(private val titleList: Array<String>, private val desList: Array<String>) : RecyclerView.Adapter<OnBoardingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingAdapter.ViewHolder = ViewHolder(ViewOnBoardingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: OnBoardingAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = titleList.size

    inner class ViewHolder(private val binding: ViewOnBoardingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.txtTitle.text = titleList[adapterPosition]
            binding.txtDes.text = desList[adapterPosition]
        }
    }
}