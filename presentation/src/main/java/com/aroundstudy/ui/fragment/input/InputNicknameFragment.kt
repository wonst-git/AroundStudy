package com.aroundstudy.ui.fragment.input

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentInputNicknameBinding
import com.aroundstudy.ui.activity.start.login.viewmodel.InputViewModel

class InputNicknameFragment : BaseFragment(), TextWatcher, View.OnClickListener {

    private lateinit var _binding: FragmentInputNicknameBinding
    override val binding get() = _binding

    private val viewModel by activityViewModels<InputViewModel>()

    override fun onClick(v: View?) {
        when (v) {
            binding.btnClear -> {
                binding.editNickname.text.clear()
            }
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        viewModel.setNickname(s.toString())
        binding.btnClear.isVisible = !s.isNullOrEmpty()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInputNicknameBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {
        binding.editNickname.setText(viewModel.nickname.value)
    }

    override fun initListener() {
        binding.btnClear.setOnClickListener(this)
        binding.editNickname.addTextChangedListener(this)
    }

    override fun initObserve() {

    }
}