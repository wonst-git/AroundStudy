package com.aroundstudy.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.aroundstudy.R

abstract class BaseFragment : Fragment() {
    abstract val binding: ViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initLayout()
        initListener()
        initObserve()
    }

    abstract fun initData()
    abstract fun initLayout()
    abstract fun initListener()
    abstract fun initObserve()

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
    }
}