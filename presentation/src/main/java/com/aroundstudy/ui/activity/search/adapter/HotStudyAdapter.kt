package com.aroundstudy.ui.activity.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.databinding.ViewMiddleStudyListItemBinding

class HotStudyAdapter(private val studyList: ArrayList<StudyDataEntity>, private val onClick: (StudyDataEntity) -> Unit) : RecyclerView.Adapter<HotStudyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotStudyAdapter.ViewHolder = ViewHolder(ViewMiddleStudyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: HotStudyAdapter.ViewHolder, position: Int) {
        holder.bind(studyList[position])
    }

    override fun getItemCount() = studyList.size

    inner class ViewHolder(private val binding: ViewMiddleStudyListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(studyData: StudyDataEntity) {
            binding.txtCategory.text = studyData.category
            binding.txtStudyTitle.text = studyData.title

            binding.chkFavorite.setOnClickListener {

            }

            binding.root.setOnClickListener {
                onClick(studyData)
            }
        }
    }
}