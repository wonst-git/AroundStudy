package com.aroundstudy.ui.activity.study.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.databinding.ViewMemberListItemBinding

class MemberListAdapter(private val memberList: ArrayList<String>) : RecyclerView.Adapter<MemberListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewMemberListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(memberList[position])
    }

    override fun getItemCount(): Int = memberList.size

    inner class ViewHolder(private val binding: ViewMemberListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(member: String) {
            binding.txtMemberName.text = member
        }
    }
}