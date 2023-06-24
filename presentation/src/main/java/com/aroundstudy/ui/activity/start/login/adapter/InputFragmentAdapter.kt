package com.aroundstudy.ui.activity.start.login.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aroundstudy.ui.fragment.input.InputGenderFragment
import com.aroundstudy.ui.fragment.input.InputNicknameFragment
import com.aroundstudy.ui.fragment.input.InputRegionFragment

class InputFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = listOf(InputNicknameFragment(), InputGenderFragment(), InputRegionFragment())

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]
}