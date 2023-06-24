package com.aroundstudy.ui.fragment.study.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.databinding.ViewLargeStudyListItemBinding

class SuggestStudyAdapter(private val studyList: ArrayList<StudyDataEntity>, private val onClick: (StudyDataEntity) -> Unit) : RecyclerView.Adapter<SuggestStudyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewLargeStudyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(studyList[position])
    }

    override fun getItemCount() = studyList.size

    inner class ViewHolder(private val binding: ViewLargeStudyListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(studyData: StudyDataEntity) {
            binding.chkFavorite.isChecked = studyData.isWish
            binding.txtStudyTitle.text = studyData.title
            binding.txtHeadcount.text = studyData.members.size.toString()
            binding.txtWay.text = studyData.process
            binding.txtCategory.text = studyData.category

            itemView.setOnClickListener {
                onClick(studyData)
            }
        }
    }
}