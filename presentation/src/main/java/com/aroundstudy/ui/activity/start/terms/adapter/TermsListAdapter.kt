package com.aroundstudy.ui.activity.start.terms.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.R
import com.aroundstudy.databinding.ViewTermsListItemBinding

class TermsListAdapter(private val termsList: ArrayList<Triple<Int, String, Boolean>>, private val checkedList: MutableSet<Int>, private val listener: (Int, Boolean) -> Unit) : RecyclerView.Adapter<TermsListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermsListAdapter.ViewHolder = ViewHolder(ViewTermsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: TermsListAdapter.ViewHolder, position: Int) {
        holder.bind(termsList[position])
    }

    override fun getItemCount() = termsList.size

    inner class ViewHolder(private val binding: ViewTermsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(term: Triple<Int, String, Boolean>) {
            binding.txtTerm.text = if (term.third) {
                binding.root.context.getString(R.string.terms_require_format, term.second)
            } else {
                binding.root.context.getString(R.string.terms_optional_format, term.second)
            }

            binding.checkBox.isChecked = checkedList.any { it == term.first }

            binding.root.setOnClickListener {
                listener(term.first, !binding.checkBox.isChecked)
            }
        }
    }
}