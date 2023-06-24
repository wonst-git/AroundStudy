package com.aroundstudy.ui.activity.category

import android.content.Intent
import android.view.View
import android.widget.ImageButton
import androidx.activity.viewModels
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.databinding.ActivityCategoryListBinding
import com.aroundstudy.ui.activity.category.adapter.CategoryListAdapter
import com.aroundstudy.ui.activity.category.viewmodel.CategoryListViewModel
import com.aroundstudy.ui.activity.search.SearchStudyActivity
import com.aroundstudy.util.constants.Constants

class CategoryListActivity : BaseActivity() {
    override val binding by lazy { ActivityCategoryListBinding.inflate(layoutInflater) }
    override val viewModel by viewModels<CategoryListViewModel>()

    private var btnSearch: ImageButton? = null

    private val onCategoryClick: (String) -> Unit = {
        startCategoryStudyActivity(it)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            btnSearch -> {
                startSearchActivity()
            }
        }
    }

    override fun initData() {
        btnSearch = getTitleView(R.id.btnRight2) as ImageButton
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.BTN_BACK, Constants.TitleType.LEFT_TITLE, Constants.TitleType.BTN_RIGHT2))
        setTitle(getString(R.string.category_title))

        btnSearch?.setImageResource(R.drawable.ic_action_search)

        binding.categoryList.adapter = CategoryListAdapter(viewModel.categories, onCategoryClick)
    }

    override fun initListener() {
        btnSearch?.setOnClickListener(this)
    }

    override fun initObserve() {

    }

    private fun startSearchActivity() {
        val searchActivityIntent = Intent(this, SearchStudyActivity::class.java)
        startActivity(searchActivityIntent)
    }

    private fun startCategoryStudyActivity(category: String) {
        val categoryStudyActivityIntent = Intent(this, CategoryStudyActivity::class.java)
            .putExtra(Constants.ActivityExtra.STUDY_CATEGORY_EXTRA, category)
        startActivity(categoryStudyActivityIntent)
    }
}