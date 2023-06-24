package com.aroundstudy.ui.fragment.study.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.databinding.ViewStudyDetailMemberListItemBinding

class MembersAdapter : ListAdapter<String, MembersAdapter.ViewHolder>(MemberDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewStudyDetailMemberListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ViewStudyDetailMemberListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(memberDto: String) {
            binding.txtMemberName.text = memberDto
        }
    }

    private class MemberDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
}