package com.aroundstudy.ui.activity.start.terms

import android.view.View
import androidx.activity.viewModels
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.databinding.ActivityTermsBinding
import com.aroundstudy.ui.activity.start.terms.adapter.TermsListAdapter
import com.aroundstudy.ui.activity.start.terms.viewmodel.TermsViewModel
import com.aroundstudy.util.constants.Constants


class TermsActivity : BaseActivity(), View.OnClickListener {
    override val binding by lazy { ActivityTermsBinding.inflate(layoutInflater) }
    override val viewModel: TermsViewModel by viewModels()

    private val testTermsList = arrayListOf(
        Triple(0, "개인정보 수집 이용 동의서", true),
        Triple(1, "개인정보 수집 이용 동의서2", true),
        Triple(2, "제 3자 정보 제공 동의", false),
        Triple(3, "제 3자 정보 제공 동의2", false)
    )

    private val testRequiredList = ArrayList<Triple<Int, String, Boolean>>()
    private val testOptionalList = ArrayList<Triple<Int, String, Boolean>>()

    private var testRequiredAdapter: TermsListAdapter? = null
    private var testOptionalAdapter: TermsListAdapter? = null

    private val clickListener: (Int, Boolean) -> Unit = { id, isChecked ->
        if (isChecked) {
            viewModel.addCheck(listOf(id))
        } else {
            viewModel.removeCheck(listOf(id))
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            binding.layoutCheckAll -> {
                if (!binding.chkAll.isChecked) {
                    viewModel.addCheck(testTermsList.map { it.first })
                } else {
                    viewModel.removeCheck(testTermsList.map { it.first })
                }
            }
            binding.btnNext -> {
                setResult(RESULT_OK)
                finish()
            }
        }
    }

    override fun initData() {
        testRequiredList.addAll(testTermsList.filter { it.third })
        testOptionalList.addAll(testTermsList.filter { !it.third })

        testRequiredAdapter = TermsListAdapter(testRequiredList, viewModel.checkedList.value!!, clickListener)
        testOptionalAdapter = TermsListAdapter(testOptionalList, viewModel.checkedList.value!!, clickListener)
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.CUSTOM))

        binding.termsRequireList.adapter = testRequiredAdapter
        binding.termsOptionalList.adapter = testOptionalAdapter
    }

    override fun initListener() {
        binding.layoutCheckAll.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
    }

    @Suppress("NotifyDataSetChanged")
    override fun initObserve() {
        viewModel.checkedList.observe(this) { checkedList ->
            testRequiredAdapter?.notifyDataSetChanged()
            testOptionalAdapter?.notifyDataSetChanged()
            binding.chkAll.isChecked = testTermsList.size == checkedList.size
            binding.btnNext.isEnabled = checkedList.containsAll(testRequiredList.map { it.first })
        }
    }
}