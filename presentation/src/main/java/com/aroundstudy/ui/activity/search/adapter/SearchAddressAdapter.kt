package com.aroundstudy.ui.activity.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.databinding.ViewSearchAddressListItemBinding

class SearchAddressAdapter(private val searchList: LiveData<ArrayList<String>>, private val onClick: (String) -> Unit = {}) : RecyclerView.Adapter<SearchAddressAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAddressAdapter.ViewHolder = ViewHolder(ViewSearchAddressListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: SearchAddressAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = searchList.value?.size ?: 0

    inner class ViewHolder(private val binding: ViewSearchAddressListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.txtAddress.text = searchList.value?.get(adapterPosition) ?: ""
            binding.viewDivider.isVisible = adapterPosition != itemCount - 1

            binding.root.setOnClickListener {
                onClick(searchList.value?.get(adapterPosition) ?: "")
            }
        }
    }
}