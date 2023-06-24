package com.aroundstudy.ui.activity.start.login

import android.view.View
import androidx.activity.viewModels
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.databinding.ActivityLoginBinding
import com.aroundstudy.util.LogUtil
import com.aroundstudy.util.constants.Constants
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.AuthError
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class LoginActivity : BaseActivity(), View.OnClickListener {
    override val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override val viewModel: BaseViewModel by viewModels()

    private val kakaoLoginCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            LogUtil.e("카카오 로그인 실패 : $error")
            if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                LogUtil.e("카카오 로그인 사용자 취소")
            } else if (error is AuthError && error.reason == AuthErrorCause.AccessDenied) {
                LogUtil.e("카카오 로그인 사용자 거절")
            }
        } else if (token != null) {
            LogUtil.d("카카오 로그인 Token : ${token.accessToken}")
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            binding.btnKakao -> {
                startKakaoLogin()
            }
            binding.btnApple -> {
                setResult(RESULT_OK)
                finish()
            }
            binding.btnGoogle -> {
                setResult(RESULT_OK)
                finish()
            }
            binding.btnNaver -> {
                setResult(RESULT_OK)
                finish()
            }
        }
    }

    override fun initData() {
        KakaoSdk.init(this, Constants.LoginAppKey.KAKAO_APP_KEY)
        LogUtil.d("카카오 로그인 해시키 : ${KakaoSdk.keyHash}")
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.CUSTOM))
    }

    override fun initListener() {
        binding.btnKakao.setOnClickListener(this)
        binding.btnApple.setOnClickListener(this)
        binding.btnGoogle.setOnClickListener(this)
        binding.btnNaver.setOnClickListener(this)
    }

    override fun initObserve() {

    }

    private fun startKakaoLogin() {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this, callback = kakaoLoginCallback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = kakaoLoginCallback)
        }
    }
}