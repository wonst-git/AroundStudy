package com.aroundstudy.ui.activity.study.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aroundstudy.ui.fragment.study.detail.StudyInfoFragment
import com.aroundstudy.ui.fragment.study.detail.StudyScheduleFragment
import com.aroundstudy.ui.fragment.study.detail.StudyVoteFragment

class StudyDetailFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragmentList = arrayListOf<Fragment>(StudyInfoFragment(), StudyScheduleFragment(), StudyVoteFragment())

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}