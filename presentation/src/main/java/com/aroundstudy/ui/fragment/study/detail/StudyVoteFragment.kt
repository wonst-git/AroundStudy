package com.aroundstudy.ui.fragment.study.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentStudyVoteBinding

class StudyVoteFragment : BaseFragment() {
    private lateinit var _binding: FragmentStudyVoteBinding
    override val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentStudyVoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {

    }

    override fun initListener() {

    }

    override fun initObserve() {

    }
}