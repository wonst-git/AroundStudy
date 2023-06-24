package com.aroundstudy.ui.fragment.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentInputGenderBinding
import com.aroundstudy.ui.activity.start.login.viewmodel.InputViewModel

class InputGenderFragment : BaseFragment(), RadioGroup.OnCheckedChangeListener {

    private lateinit var _binding: FragmentInputGenderBinding
    override val binding get() = _binding

    private val viewModel by activityViewModels<InputViewModel>()

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        if (binding.rdoMan.isChecked) {
            viewModel.gender = 0
        } else {
            viewModel.gender = 1
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInputGenderBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {
        if (viewModel.gender == 0) {
            binding.rdgGender.check(binding.rdoMan.id)
        } else {
            binding.rdgGender.check(binding.rdoWomen.id)
        }
    }

    override fun initListener() {
        binding.rdgGender.setOnCheckedChangeListener(this)
    }

    override fun initObserve() {

    }
}