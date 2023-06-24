package com.aroundstudy.ui.fragment.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.databinding.FragmentHomeBinding
import com.aroundstudy.ui.activity.category.CategoryStudyActivity
import com.aroundstudy.ui.activity.main.viewmodel.MainViewModel
import com.aroundstudy.ui.activity.study.StudyDetailActivity
import com.aroundstudy.ui.fragment.main.adapter.HomeCategoryAdapter
import com.aroundstudy.ui.fragment.main.adapter.HomeStudyAdapter
import com.aroundstudy.util.constants.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel by activityViewModels<MainViewModel>()

    private lateinit var _binding: FragmentHomeBinding
    override val binding get() = _binding

    private val onCategoryClick: (String) -> Unit = {
        startCategoryStudyActivity(it)
    }

    private val onStudyClick: (StudyDataEntity) -> Unit = {
        startStudyDetailActivity(it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {

    }

    override fun initListener() {
        binding.btnNewStudy.setOnClickListener {  }
    }

    override fun initObserve() {
        viewModel.categoryList.observe(this) {
            binding.categoryList.adapter = HomeCategoryAdapter(it, onCategoryClick)
        }
        viewModel.studyList.observe(this) {
            binding.homeStudyList.adapter = HomeStudyAdapter(it, onStudyClick)
        }
    }

    private fun startCategoryStudyActivity(category: String) {
        val categoryStudyActivityIntent = Intent(requireContext(), CategoryStudyActivity::class.java)
            .putExtra(Constants.ActivityExtra.STUDY_CATEGORY_EXTRA, category)
        startActivity(categoryStudyActivityIntent)
    }

    private fun startStudyDetailActivity(study: StudyDataEntity) {
        val studyDetailIntent = Intent(requireContext(), StudyDetailActivity::class.java)
            .putExtra(Constants.ActivityExtra.STUDY_DATA_EXTRA, study)
        startActivity(studyDetailIntent)
    }
}