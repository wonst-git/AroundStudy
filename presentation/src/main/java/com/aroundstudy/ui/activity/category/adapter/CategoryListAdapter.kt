package com.aroundstudy.ui.activity.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.databinding.ViewCategoryListItemBinding

class CategoryListAdapter(private val categoryList: ArrayList<String>, private val onClick: (String) -> Unit) : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewCategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: CategoryListAdapter.ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    inner class ViewHolder(private val binding: ViewCategoryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryTitle: String) {
            binding.txtCategory.text = categoryTitle

            binding.root.setOnClickListener {
                onClick(categoryTitle)
            }
        }
    }
}