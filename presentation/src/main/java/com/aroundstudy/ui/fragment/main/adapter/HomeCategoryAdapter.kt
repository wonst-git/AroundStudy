package com.aroundstudy.ui.fragment.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.databinding.ViewHomeCategoryListItemBinding

class HomeCategoryAdapter(private val categoryList: ArrayList<String>, private val onClick: (String) -> Unit) : RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewHomeCategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: HomeCategoryAdapter.ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount() = categoryList.size

    inner class ViewHolder(private val binding: ViewHomeCategoryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String) {
            binding.txtCategory.text = category

            binding.root.setOnClickListener {
                onClick(category)
            }
        }
    }
}