package com.aroundstudy.ui.activity.study

import androidx.activity.viewModels
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.databinding.ActivityMemberListBinding
import com.aroundstudy.ui.activity.study.adapter.MemberListAdapter
import com.aroundstudy.util.LogUtil
import com.aroundstudy.util.constants.Constants

class MemberListActivity : BaseActivity() {
    override val binding by lazy { ActivityMemberListBinding.inflate(layoutInflater) }
    override val viewModel by viewModels<BaseViewModel>()

    private val memberList = ArrayList<String>()

    override fun initData() {
        memberList.addAll(intent.getStringArrayListExtra(Constants.ActivityExtra.STUDY_MEMBER_EXTRA) ?: arrayListOf())
        LogUtil.d("memberList : $memberList")
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.LEFT_TITLE, Constants.TitleType.BTN_BACK))
        title = getString(R.string.study_member_list_title, memberList.size)

        binding.memberList.adapter = MemberListAdapter(memberList)
    }

    override fun initListener() {

    }

    override fun initObserve() {

    }
}