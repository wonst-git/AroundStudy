package com.aroundstudy.ui.activity.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.R
import com.aroundstudy.databinding.ViewSearchCategoryListItemBinding

class SearchCategoryAdapter(private val categoryList: ArrayList<String>, private val selectedCategoryList: LiveData<MutableSet<String>>, private val onClick: (String, Int) -> Unit) : RecyclerView.Adapter<SearchCategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewSearchCategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: SearchCategoryAdapter.ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    inner class ViewHolder(private val binding: ViewSearchCategoryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String) {
            if (selectedCategoryList.value?.contains(category) == true) {
                binding.chkCategory.isChecked = true
                val drawable = ContextCompat.getDrawable(itemView.context, R.drawable.ic_navigation_close_mini)?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.color_8ec96d))
                }
                binding.chkCategory.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
                binding.chkCategory.typeface = ResourcesCompat.getFont(itemView.context, R.font.pretendard_medium)
            } else {
                binding.chkCategory.isChecked = false
                binding.chkCategory.setCompoundDrawables(null, null, null, null)
                binding.chkCategory.typeface = ResourcesCompat.getFont(itemView.context, R.font.pretendard_regular)
            }
            binding.chkCategory.text = category

            itemView.setOnClickListener {
                onClick(category, adapterPosition)
            }
        }
    }
}