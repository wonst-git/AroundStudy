package com.aroundstudy.ui.activity.search

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.databinding.ActivitySearchStudyBinding
import com.aroundstudy.domain.model.database.SearchHistory
import com.aroundstudy.ui.activity.search.adapter.HotStudyAdapter
import com.aroundstudy.ui.activity.search.adapter.SearchCategoryAdapter
import com.aroundstudy.ui.activity.search.adapter.SearchHistoryAdapter
import com.aroundstudy.ui.activity.search.adapter.SearchStudyListAdapter
import com.aroundstudy.ui.activity.search.viewmodel.SearchStudyViewModel
import com.aroundstudy.util.LogUtil
import com.aroundstudy.util.constants.Constants
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchStudyActivity : BaseActivity(), TextWatcher {
    override val binding by lazy { ActivitySearchStudyBinding.inflate(layoutInflater) }
    override val viewModel by viewModels<SearchStudyViewModel>()

    private var editSearch: EditText? = null

    private val onHistoryClick: (SearchHistory, Boolean) -> Unit = { searchData, isDelete ->
        if (isDelete) {
            viewModel.deleteSearchHistory(searchData)
        } else {
            viewModel.insertSearchHistory(searchData.searchText)
            editSearch?.setText(searchData.searchText)
        }
    }

    private val onCategoryClick: (String, Int) -> Unit = { category, position ->
        if (viewModel.selectedCategoryList.value?.contains(category) == true) {
            viewModel.removeSelectedCategoryList(category)
        } else {
            viewModel.addSelectedCategoryList(category)
        }
        binding.categoryList.adapter?.notifyItemChanged(position)
    }

    private val onStudyClick: (StudyDataEntity) -> Unit = {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (editSearch?.text.isNullOrEmpty()) {
            binding.layoutSearch.isVisible = false
            binding.layoutSearchBefore.isVisible = true

            viewModel.removeAllSelectedCategoryList()
            binding.categoryList.adapter = SearchCategoryAdapter(viewModel.categoryList, viewModel.selectedCategoryList, onCategoryClick)
        } else {
            binding.layoutSearch.isVisible = true
            binding.layoutSearchBefore.isVisible = false

            filterStudyList(viewModel.selectedCategoryList.value)
        }
    }

    override fun afterTextChanged(s: Editable?) {}

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            binding.btnDeleteAll -> {
                viewModel.deleteAllSearchHistory()
            }
            binding.layoutParent -> {
                saveSearchText()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        editSearch?.removeTextChangedListener(this)
    }

    override fun initData() {
        editSearch = getTitleView(R.id.editSearch) as? EditText
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.BTN_BACK, Constants.TitleType.SEARCH))
        editSearch?.hint = getString(R.string.search_study_hint)
        binding.categoryList.adapter = SearchCategoryAdapter(viewModel.categoryList, viewModel.selectedCategoryList, onCategoryClick)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initListener() {
        editSearch?.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                saveSearchText()
            }
            true
        }

        editSearch?.addTextChangedListener(this)

        binding.btnDeleteAll.setOnClickListener(this)

        binding.root.setOnTouchListener { _, event ->
            if (event?.action == MotionEvent.ACTION_DOWN && isKeyBoardShowing()) {
                LogUtil.d("saveSearchText()")
                saveSearchText()
            }
            true
        }
    }

    override fun initObserve() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getSearchHistoryList().observe(this@SearchStudyActivity) {
                binding.recentSearchList.adapter = SearchHistoryAdapter(it, onHistoryClick)
            }
        }
        viewModel.hotStudyList.observe(this) {
            binding.pagerHotStudy.adapter = HotStudyAdapter(it, onStudyClick)
            TabLayoutMediator(binding.tabIndicator, binding.pagerHotStudy, true) { _, _ -> }.attach()
        }
        viewModel.selectedCategoryList.observe(this) {
            filterStudyList(it)
        }
    }

    private fun filterStudyList(categories: MutableSet<String>?) {
        val filterStudyList = viewModel.studyList.filter {
            if (categories.isNullOrEmpty()) {
                it.title.contains(editSearch?.text.toString())
            } else {
                categories.contains(it.category) && it.title.contains(editSearch?.text.toString())
            }
        }
        binding.studyList.adapter = SearchStudyListAdapter(ArrayList(filterStudyList), onStudyClick)
    }

    private fun saveSearchText() {
        if (editSearch?.text?.isNotEmpty() == true) {
            viewModel.insertSearchHistory(editSearch?.text.toString())
        }
        showKeyboard(editSearch!!, false)
    }
}