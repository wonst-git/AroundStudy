package com.aroundstudy.ui.activity.start.login

import android.view.View
import androidx.activity.viewModels
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.databinding.ActivityCompleteBinding
import com.aroundstudy.util.constants.Constants

class CompleteActivity : BaseActivity() {
    override val binding: ActivityCompleteBinding by lazy { ActivityCompleteBinding.inflate(layoutInflater) }
    override val viewModel: BaseViewModel by viewModels()

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            binding.btnOk -> {
                finish()
            }
        }
    }

    override fun initData() {

    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.CUSTOM))
    }

    override fun initListener() {
        binding.btnOk.setOnClickListener(this)
    }

    override fun initObserve() {

    }
}