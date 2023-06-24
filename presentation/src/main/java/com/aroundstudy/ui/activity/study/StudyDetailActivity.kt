package com.aroundstudy.ui.activity.study

import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.databinding.ActivityStudyDetailBinding
import com.aroundstudy.ui.activity.study.adapter.StudyDetailFragmentAdapter
import com.aroundstudy.ui.activity.study.viewmodel.StudyDetailViewModel
import com.aroundstudy.util.constants.Constants
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class StudyDetailActivity : BaseActivity() {
    override val binding: ActivityStudyDetailBinding by lazy { ActivityStudyDetailBinding.inflate(layoutInflater) }
    override val viewModel: StudyDetailViewModel by viewModels()

    private var btnShare: ImageButton? = null
    private var btnWish: ImageButton? = null

    private val tabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0 -> {
                    binding.btnChat.isVisible = true
                    binding.btnJoin.isVisible = true
                }
                1 -> {
                    binding.btnChat.isVisible = false
                    binding.btnJoin.isVisible = false
                }
                2 -> {
                    binding.btnChat.isVisible = false
                    binding.btnJoin.isVisible = false
                }
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }

    override fun initData() {
        btnShare = getTitleView(R.id.btnRight2) as ImageButton
        btnWish = getTitleView(R.id.btnRight1) as ImageButton

        viewModel.setStudyData(intent.getParcelableExtra(Constants.ActivityExtra.STUDY_DATA_EXTRA))
    }

    override fun initLayout() {
        title = (viewModel.studyData.value?.title)
        setTitleType(listOf(Constants.TitleType.BTN_BACK, Constants.TitleType.LEFT_TITLE, Constants.TitleType.BTN_RIGHT1, Constants.TitleType.BTN_RIGHT2))
        btnShare?.setImageResource(R.drawable.ic_action_share)
        btnWish?.setImageResource(R.drawable.sel_btn_favorite)

        binding.pagerStudyDetail.adapter = StudyDetailFragmentAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabStudyDetail, binding.pagerStudyDetail) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.study_tab_info)
                }
                1 -> {
                    tab.text = getString(R.string.study_tab_schedule)
                }
                2 -> {
                    tab.text = getString(R.string.study_tab_vote)
                }
            }
        }.attach()
    }

    override fun initListener() {
        binding.tabStudyDetail.addOnTabSelectedListener(tabSelectedListener)
    }

    override fun initObserve() {
        viewModel.studyData.observe(this) {
            binding.txtOpenDate.text = getString(R.string.study_reg_date_foramt, it.regDate)
            binding.btnJoin.isVisible = !it.isJoin
            binding.btnChat.isVisible = it.isJoin

            if (it.isWish) {
                btnWish?.setImageResource(R.drawable.ic_toggle_favorite_fill)
            } else {
                btnWish?.setImageResource(R.drawable.ic_toggle_favorite)
                btnWish?.setColorFilter(ContextCompat.getColor(this, R.color.color_282828))
            }
        }
    }
}