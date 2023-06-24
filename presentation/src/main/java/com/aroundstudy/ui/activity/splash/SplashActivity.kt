package com.aroundstudy.ui.activity.splash

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aroundstudy.R
import com.aroundstudy.databinding.ActivitySplashBinding
import com.aroundstudy.ui.activity.access.AccessActivity
import com.aroundstudy.ui.activity.start.login.InputActivity
import com.aroundstudy.ui.activity.start.login.LoginActivity
import com.aroundstudy.ui.activity.main.MainActivity
import com.aroundstudy.ui.activity.splash.viewmodel.SplashViewModel
import com.aroundstudy.ui.activity.start.onboarding.OnBoardingActivity
import com.aroundstudy.ui.activity.start.terms.TermsActivity
import com.aroundstudy.util.LogUtil
import com.aroundstudy.util.constants.Constants
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SplashViewModel>()

    private val accessActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            startNextActivity()
        } else {
            finish()
        }
    }

    private val onBoardingActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        viewModel.saveStartSate(Constants.StartState.START_TERMS.ordinal)
        startNextActivity()
    }

    private val termsActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            viewModel.saveStartSate(Constants.StartState.START_LOGIN.ordinal)
            startNextActivity()
        } else {
            finish()
        }
    }

    private val loginActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            viewModel.saveStartSate(Constants.StartState.START_INPUT_DATA.ordinal)
            startNextActivity()
        } else {
            finish()
        }
    }

    private val inputActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            viewModel.saveStartSate(Constants.StartState.START_COMPLETE.ordinal)
            startNextActivity()
        } else {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initData()
        initLayout()
        initListener()

        CoroutineScope(Dispatchers.Main).launch {
            delay(500)
            startNextActivity()
        }
    }

    private fun initData() {

    }

    private fun initLayout() {

    }

    private fun initListener() {
        if (viewModel.fcmToken.isEmpty()) {
            FirebaseMessaging.getInstance().token
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        viewModel.saveFcmToken(it.result)
                    }
                }
        } else {
            LogUtil.d("fcm Token : ${viewModel.fcmToken}")
        }
    }

    private fun startNextActivity() {
        if (getPermissionDenied() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            accessActivityResult.launch(Intent(this, AccessActivity::class.java))
        } else {
            when (viewModel.startState) {
                Constants.StartState.START_ON_BOARDING.ordinal -> {
                    val onBoardingIntent = Intent(this, OnBoardingActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    onBoardingActivityResult.launch(onBoardingIntent)
                    overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
                }
                Constants.StartState.START_TERMS.ordinal -> {
                    val termsIntent = Intent(this, TermsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    termsActivityLauncher.launch(termsIntent)
                    overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
                }
                Constants.StartState.START_LOGIN.ordinal -> {
                    val loginIntent = Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    loginActivityLauncher.launch(loginIntent)
                    overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
                }
                Constants.StartState.START_INPUT_DATA.ordinal -> {
                    val inputIntent = Intent(this, InputActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    inputActivityLauncher.launch(inputIntent)
                    overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
                }
                Constants.StartState.START_COMPLETE.ordinal -> {
                    val mainIntent = Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(mainIntent)
                    finish()
                }
            }
        }
    }

    private fun getPermissionDenied(): Boolean = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED
    } else {
        false
    }
}