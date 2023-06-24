package com.aroundstudy.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentMoreBinding
import com.aroundstudy.ui.activity.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFragment : BaseFragment() {

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var _binding: FragmentMoreBinding
    override val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)

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