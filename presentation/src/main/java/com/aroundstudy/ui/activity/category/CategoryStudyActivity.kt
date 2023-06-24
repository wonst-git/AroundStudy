package com.aroundstudy.ui.activity.category

import android.content.Intent
import android.view.View
import android.widget.ImageButton
import androidx.activity.viewModels
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.databinding.ActivityCategoryStudyBinding
import com.aroundstudy.ui.activity.category.adapter.CategoryStudyAdapter
import com.aroundstudy.ui.activity.category.viewmodel.CategoryStudyViewModel
import com.aroundstudy.ui.activity.search.SearchStudyActivity
import com.aroundstudy.util.constants.Constants

class CategoryStudyActivity : BaseActivity() {

    override val binding by lazy { ActivityCategoryStudyBinding.inflate(layoutInflater) }

    override val viewModel: CategoryStudyViewModel by viewModels()

    private var category: String = ""
    private var btnSearch: ImageButton? = null

    private val onStudyClick: (StudyDataEntity) -> Unit = {

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
        category = intent.getStringExtra(Constants.ActivityExtra.STUDY_CATEGORY_EXTRA) ?: ""
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.BTN_BACK, Constants.TitleType.LEFT_TITLE, Constants.TitleType.BTN_RIGHT2))
        title = category

        binding.studyList.adapter = CategoryStudyAdapter(ArrayList(viewModel.studyList.filter { it.category.equals(category, true) }), onStudyClick)
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
}