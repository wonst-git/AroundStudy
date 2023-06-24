package com.aroundstudy.ui.activity.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.databinding.ViewSmallStudyListItemBinding

class SearchStudyListAdapter(private val studyList: ArrayList<StudyDataEntity>, private val onClick: (StudyDataEntity) -> Unit) : RecyclerView.Adapter<SearchStudyListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewSmallStudyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: SearchStudyListAdapter.ViewHolder, position: Int) {
        holder.bind(studyList[position])
    }

    override fun getItemCount(): Int = studyList.size

    inner class ViewHolder(private val binding: ViewSmallStudyListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(study: StudyDataEntity) {
            binding.txtStudyTitle.text = study.title
            binding.txtCategory.text = study.category
            binding.txtPlace.text = study.place

            binding.chkFavorite.isChecked = study.isWish

            binding.root.setOnClickListener {
                onClick(study)
            }
        }
    }
}