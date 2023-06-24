package com.aroundstudy.ui.activity.main

import android.content.Intent
import android.view.View
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.databinding.ActivityMainBinding
import com.aroundstudy.ui.activity.category.CategoryListActivity
import com.aroundstudy.ui.activity.main.viewmodel.MainViewModel
import com.aroundstudy.ui.activity.search.SearchStudyActivity
import com.aroundstudy.util.constants.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val viewModel by viewModels<MainViewModel>()

    private var navController: NavController? = null

    private var btnCategory: ImageButton? = null
    private var btnSearch: ImageButton? = null

    private val destinationChangedListener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        when (destination.id) {
            R.id.menuHome -> {
                setTitleType(listOf(Constants.TitleType.MAIN_LOGO, Constants.TitleType.BTN_RIGHT1, Constants.TitleType.BTN_RIGHT2))
            }
            R.id.menuStudy -> {
                setTitleType(listOf(Constants.TitleType.MAIN_TITLE, Constants.TitleType.BTN_RIGHT2))
                setTitle(getString(R.string.main_menu_study))
            }
            R.id.menuChat -> {
                setTitleType(listOf(Constants.TitleType.MAIN_TITLE, Constants.TitleType.BTN_RIGHT2))
                setTitle(getString(R.string.main_menu_chat))
            }
            R.id.menuMore -> {
                setTitleType(listOf(Constants.TitleType.MAIN_TITLE, Constants.TitleType.BTN_RIGHT2))
                setTitle(getString(R.string.main_menu_more))
            }
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            btnCategory -> {
                startCategoryActivity()
            }
            btnSearch -> {
                startSearchActivity()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        navController?.removeOnDestinationChangedListener(destinationChangedListener)
    }

    override fun initData() {
        btnCategory = getTitleView(R.id.btnRight1) as? ImageButton
        btnSearch = getTitleView(R.id.btnRight2) as? ImageButton
    }

    override fun initLayout() {
        setContentView(binding.root)
        setTitleType(listOf(Constants.TitleType.MAIN_LOGO, Constants.TitleType.BTN_RIGHT1, Constants.TitleType.BTN_RIGHT2))

        navController = (supportFragmentManager.findFragmentById(binding.fragmentContainer.id) as NavHostFragment).navController

        binding.bottomNav.setupWithNavController(navController!!)

        btnCategory?.setImageResource(R.drawable.ic_navigation_category)
        btnSearch?.setImageResource(R.drawable.ic_action_search)
    }

    override fun initListener() {
        btnCategory?.setOnClickListener(this)
        btnSearch?.setOnClickListener(this)

        navController?.addOnDestinationChangedListener(destinationChangedListener)
    }

    override fun initObserve() {

    }

    private fun startSearchActivity() {
        val searchActivityIntent = Intent(this, SearchStudyActivity::class.java)
        startActivity(searchActivityIntent)
    }

    private fun startCategoryActivity() {
        val categoryActivityIntent = Intent(this, CategoryListActivity::class.java)
        startActivity(categoryActivityIntent)
    }
}