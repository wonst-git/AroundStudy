package com.aroundstudy.ui.fragment.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aroundstudy.R
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentCommonStudyBinding
import com.aroundstudy.ui.activity.main.MainActivity

class JoinedStudyFragment : BaseFragment(), View.OnClickListener {
    private lateinit var _binding: FragmentCommonStudyBinding
    override val binding get() = _binding

    override fun onClick(v: View?) {
        when (v) {
            binding.btnFindStudy -> {
                (requireActivity() as MainActivity).binding.bottomNav.selectedItemId = R.id.menuHome
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCommonStudyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {

    }

    override fun initListener() {
        binding.btnFindStudy.setOnClickListener(this)
    }

    override fun initObserve() {

    }
}