package com.aroundstudy.ui.activity.start.login

import android.content.Intent
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.databinding.ActivityInputBinding
import com.aroundstudy.ui.activity.start.login.adapter.InputFragmentAdapter
import com.aroundstudy.ui.activity.start.login.viewmodel.InputViewModel
import com.aroundstudy.util.constants.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity : BaseActivity(), View.OnClickListener {
    override val binding by lazy { ActivityInputBinding.inflate(layoutInflater) }

    override val viewModel by viewModels<InputViewModel>()

    private val completeActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        finish()
    }

    private val viewPagerListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            binding.layoutBar.isVisible = position != 3
            when (position) {
                0 -> {
                    binding.btnNext.isEnabled = !viewModel.nickname.value.isNullOrEmpty()
                    binding.bar2.setBackgroundColor(ContextCompat.getColor(this@InputActivity, R.color.color_ececec))
                    binding.bar3.setBackgroundColor(ContextCompat.getColor(this@InputActivity, R.color.color_ececec))
                    binding.btnNext.text = getString(R.string.btn_next)
                }
                1 -> {
                    binding.btnNext.isEnabled = true
                    binding.bar2.setBackgroundColor(ContextCompat.getColor(this@InputActivity, R.color.color_8ec96d))
                    binding.bar3.setBackgroundColor(ContextCompat.getColor(this@InputActivity, R.color.color_ececec))
                    binding.btnNext.text = getString(R.string.btn_next)
                }
                2 -> {
                    binding.btnNext.isEnabled = !viewModel.region.value.isNullOrEmpty()
                    binding.bar2.setBackgroundColor(ContextCompat.getColor(this@InputActivity, R.color.color_8ec96d))
                    binding.bar3.setBackgroundColor(ContextCompat.getColor(this@InputActivity, R.color.color_8ec96d))
                    binding.btnNext.text = getString(R.string.btn_start_study)
                }
            }
            super.onPageSelected(position)
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            binding.btnNext -> {
                if (binding.pagerInput.currentItem == 2) {
                    startCompleteActivity()
                } else {
                    binding.pagerInput.currentItem = binding.pagerInput.currentItem.inc()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.pagerInput.unregisterOnPageChangeCallback(viewPagerListener)
    }

    override fun onBackPressed() {
        if (binding.pagerInput.currentItem != 0) {
            binding.pagerInput.currentItem = binding.pagerInput.currentItem.dec()
        } else {
            super.onBackPressed()
        }
    }

    override fun initData() {

    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.BTN_BACK, Constants.TitleType.CENTER_TITLE))
        setTitle(getString(R.string.input_title))

        (getTitleView(R.id.txtTitle) as TextView).gravity = Gravity.CENTER

        val adapter = InputFragmentAdapter(this)
        binding.pagerInput.adapter = adapter
        binding.pagerInput.isUserInputEnabled = false
    }

    override fun initListener() {
        binding.pagerInput.registerOnPageChangeCallback(viewPagerListener)
        binding.btnNext.setOnClickListener(this)
    }

    override fun initObserve() {
        viewModel.nickname.observe(this) {
            if (binding.pagerInput.currentItem == 0) {
                binding.btnNext.isEnabled = it.isNotEmpty()
            }
        }
        viewModel.region.observe(this) {
            if (binding.pagerInput.currentItem == 2) {
                binding.btnNext.isEnabled = it.isNotEmpty()
            }
        }
    }

    private fun startCompleteActivity() {
        setResult(RESULT_OK)
        val completeIntent = Intent(this, CompleteActivity::class.java)
        completeActivityLauncher.launch(completeIntent)
        overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
    }
}