package com.aroundstudy.ui.activity.start.onboarding

import android.view.View
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.databinding.ActivityOnBoardingBinding
import com.aroundstudy.ui.activity.start.onboarding.adapter.OnBoardingAdapter
import com.aroundstudy.util.constants.Constants
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : BaseActivity() {
    override val binding by lazy { ActivityOnBoardingBinding.inflate(layoutInflater) }
    override val viewModel: BaseViewModel by viewModels()

    private var titleList: Array<String> = arrayOf()
    private var desList: Array<String> = arrayOf()
    private var btnClose: ImageButton? = null

    private val viewPagerCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.btnNext.text = if (position == 2) {
                getString(R.string.btn_start_study)
            } else {
                getString(R.string.btn_next)
            }
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            btnClose -> {
                finish()
            }
            binding.btnNext -> {
                if (binding.pagerOnBoarding.currentItem == 2) {
                    finish()
                } else {
                    binding.pagerOnBoarding.currentItem = binding.pagerOnBoarding.currentItem.inc()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.pagerOnBoarding.unregisterOnPageChangeCallback(viewPagerCallback)
    }

    override fun initData() {
        btnClose = getTitleView(R.id.btnRight2) as ImageButton
        titleList = resources.getStringArray(R.array.on_boarding_title_array)
        desList = resources.getStringArray(R.array.on_boarding_des_array)
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.BTN_RIGHT2))
        btnClose?.setImageResource(R.drawable.ic_navigation_close)

        binding.pagerOnBoarding.adapter = OnBoardingAdapter(titleList, desList)
        TabLayoutMediator(binding.tabIndicator, binding.pagerOnBoarding, true) { _, _ -> }.attach()
    }

    override fun initListener() {
        btnClose?.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
        binding.pagerOnBoarding.registerOnPageChangeCallback(viewPagerCallback)
    }

    override fun initObserve() {

    }
}