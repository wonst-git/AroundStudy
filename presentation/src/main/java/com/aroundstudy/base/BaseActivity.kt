package com.aroundstudy.base

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.aroundstudy.R
import com.aroundstudy.databinding.ActivityBaseBinding
import com.aroundstudy.ui.activity.access.AccessActivity
import com.aroundstudy.util.constants.Constants
import com.aroundstudy.util.constants.Constants.TitleType.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {
    private val baseBinding by lazy { ActivityBaseBinding.inflate(layoutInflater) }

    abstract val binding: ViewBinding
    abstract val viewModel: BaseViewModel

    abstract fun initData()
    abstract fun initLayout()
    abstract fun initListener()
    abstract fun initObserve()

    private var permissionDenied = false

    private var locationManager: LocationManager? = null

    private val accessActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode != RESULT_OK) {
            finish()
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            baseBinding.btnBack -> {
                onBackPressed()
            }
            baseBinding.btnClear -> {
                baseBinding.editSearch.setText("")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        baseInitListener()
        baseInitObserve()

        initData()
        initLayout()
        initListener()
        initObserve()

        checkDefaultPermissions()
    }

    override fun onResume() {
        super.onResume()

        checkDefaultPermissions()
        if (permissionDenied) {
            startAccessActivity()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_ltr, R.anim.slide_out_ltr)
    }

    override fun setContentView(layoutResID: Int) {
        setContentAddView(layoutInflater.inflate(layoutResID, null))
    }

    override fun setContentView(view: View?) {
        setContentAddView(view)
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
    }

    private fun setContentAddView(view: View?) {
        view?.run {
            baseBinding.layoutContents.removeAllViews()
            baseBinding.layoutContents.addView(this, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        }

        super.setContentView(baseBinding.root)
    }

    private fun baseInitListener() {
        baseBinding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                baseBinding.btnClear.isVisible = baseBinding.editSearch.text.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        baseBinding.btnClear.setOnClickListener(this)
        baseBinding.btnBack.setOnClickListener(this)
    }

    private fun baseInitObserve() {
        viewModel.isLoading.observe(this) {
            showProgress(it)
        }
    }

    private fun showProgress(isVisible: Boolean) {
        baseBinding.progressBar.isVisible = isVisible
        baseBinding.progressBar.isClickable = isVisible
    }

    fun showKeyboard(v: View, isShow: Boolean) {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (isShow) {
                imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
            } else {
                if (imm.isActive) {
                    imm.hideSoftInputFromWindow(v.applicationWindowToken, 0)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setTitleType(type: List<Constants.TitleType>) {

        baseBinding.layoutTitle.isVisible = CUSTOM !in type

        baseBinding.btnBack.isVisible = BTN_BACK in type

        baseBinding.btnRight1.isVisible = BTN_RIGHT1 in type
        baseBinding.btnRight2.isVisible = BTN_RIGHT2 in type
        baseBinding.btnText.isVisible = BTN_RIGHT_TEXT in type

        baseBinding.txtTitle.isVisible = LEFT_TITLE in type
        baseBinding.txtCenterTitle.isVisible = CENTER_TITLE in type

        baseBinding.imgLogo.isVisible = MAIN_LOGO in type
        baseBinding.txtMainTitle.isVisible = MAIN_TITLE in type

        baseBinding.layoutSearch.isVisible = SEARCH in type
    }

    override fun setTitle(title: CharSequence?) {
        super.setTitle(title)
        baseBinding.txtTitle.text = title
        baseBinding.txtCenterTitle.text = title
        baseBinding.txtMainTitle.text = title

    }

    fun getTitleView(resId: Int): View? = when (resId) {
        baseBinding.btnBack.id -> {
            baseBinding.btnBack
        }
        baseBinding.btnRight1.id -> {
            baseBinding.btnRight1
        }
        baseBinding.btnRight2.id -> {
            baseBinding.btnRight2
        }
        baseBinding.txtTitle.id -> {
            baseBinding.txtTitle
        }
        baseBinding.btnText.id -> {
            baseBinding.btnText
        }
        baseBinding.editSearch.id -> {
            baseBinding.editSearch
        }
        else -> {
            null
        }
    }

    fun getLocation(): Location? {
        if (locationManager == null) {
            locationManager = getSystemService(Context.LOCATION_SERVICE) as? LocationManager
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            val isNetworkEnabled = locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            return if (isNetworkEnabled == true) {
                locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            } else {
                locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            }
        }

        return null
    }

    fun isKeyBoardShowing(): Boolean = resources.displayMetrics.heightPixels > baseBinding.root.height

    private fun checkDefaultPermissions() {
        permissionDenied = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED
        } else {
            false
        }
    }

    private fun startAccessActivity() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            accessActivityResult.launch(Intent(this, AccessActivity::class.java))
        }
    }
}