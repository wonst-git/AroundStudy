package com.aroundstudy.ui.activity.category.viewmodel

import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.util.TestUtil

class CategoryListViewModel: BaseViewModel() {
    val categories: ArrayList<String> = TestUtil.testCategoryList
}