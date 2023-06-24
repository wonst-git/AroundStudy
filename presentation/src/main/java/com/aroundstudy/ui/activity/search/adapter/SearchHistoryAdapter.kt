package com.aroundstudy.ui.activity.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.databinding.ViewRecentSearchListItemBinding
import com.aroundstudy.domain.model.database.SearchHistory

class SearchHistoryAdapter(private val searchHistoryList: List<SearchHistory>, private val onClick: (SearchHistory, Boolean) -> Unit) : RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryAdapter.ViewHolder = ViewHolder(ViewRecentSearchListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: SearchHistoryAdapter.ViewHolder, position: Int) {
        holder.bind(searchHistoryList[position])
    }

    override fun getItemCount(): Int = searchHistoryList.size

    inner class ViewHolder(private val binding: ViewRecentSearchListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(searchHistory: SearchHistory) {
            binding.txtSearch.text = searchHistory.searchText

            binding.root.setOnClickListener {
                onClick(searchHistory, false)
            }
            binding.btnDelete.setOnClickListener {
                onClick(searchHistory, true)
            }
        }
    }
}