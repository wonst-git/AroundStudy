package com.aroundstudy.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.forEach
import androidx.fragment.app.activityViewModels
import com.aroundstudy.R
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentStudyBinding
import com.aroundstudy.ui.activity.main.viewmodel.MainViewModel
import com.aroundstudy.ui.fragment.main.adapter.StudyFragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyFragment : BaseFragment() {

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var _binding: FragmentStudyBinding
    override val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStudyBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {
        binding.pagerStudy.adapter = StudyFragmentAdapter(requireActivity().supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabStudy, binding.pagerStudy, true, false) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.main_study_tab_joined)
                }
                1 -> {
                    tab.text = getString(R.string.main_study_tab_wish)
                }
            }
        }.attach()

        (binding.tabStudy.getChildAt(0) as ViewGroup).forEach {
            (it as ViewGroup).forEach { child ->
                if (child is TextView) {
                    child.typeface = ResourcesCompat.getFont(requireContext(), R.font.pretendard_medium)
                }
            }
        }
    }

    override fun initListener() {

    }

    override fun initObserve() {

    }
}