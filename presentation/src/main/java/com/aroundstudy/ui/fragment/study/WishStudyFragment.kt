package com.aroundstudy.ui.fragment.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.aroundstudy.R
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentCommonStudyBinding

class WishStudyFragment : BaseFragment() {
    private lateinit var _binding: FragmentCommonStudyBinding
    override val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCommonStudyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {
        binding.txtStudyNone.text = getString(R.string.main_wish_study_none)
        binding.btnFindStudy.isVisible = false
    }

    override fun initListener() {

    }

    override fun initObserve() {

    }
}