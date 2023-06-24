package com.aroundstudy.ui.activity.access

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.aroundstudy.databinding.ActivityAccessBinding
import com.aroundstudy.util.constants.Constants

@RequiresApi(Build.VERSION_CODES.M)
class AccessActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy { ActivityAccessBinding.inflate(layoutInflater) }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnOk -> {
                requestPermission()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (checkSelfPermission(Constants.Permission.PERMISSION_LOCATION[0]) == PackageManager.PERMISSION_GRANTED) {
            setResult(RESULT_OK)
            finish()
        } else {
            if (shouldShowRequestPermissionRationale(Constants.Permission.PERMISSION_LOCATION[0])) {
                AlertDialog.Builder(this).apply {
                    setTitle("권한")
                    setMessage("권한 획득에 실패하였습니다.\n다시 시도해 주세요.")
                    setPositiveButton("확인") { _, _ -> }
                    show()
                }
            } else {
                AlertDialog.Builder(this).apply {
                    setTitle("권한 획득 실패")
                    setMessage("권한을 허용하기 위해서 설정으로 이동합니다.")
                    setPositiveButton("확인") { _, _ ->
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", packageName, null)
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        }
                        startActivity(intent)
                    }
                    setNegativeButton("취소") { dialog, _ ->
                        dialog.dismiss()
                    }
                    show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        initListener()
    }

    override fun onResume() {
        super.onResume()
        if (!getPermissionDenied()) {
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun initLayout() {
        setContentView(binding.root)
    }

    private fun initListener() {
        binding.btnOk.setOnClickListener(this)
    }


    private fun requestPermission() {
        val permissions = Constants.Permission.PERMISSION_CAMERA + Constants.Permission.PERMISSION_LOCATION + Constants.Permission.PERMISSION_EXTERNAL_STORAGE

        requestPermissions(permissions, 100)
    }

    private fun getPermissionDenied(): Boolean = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED
    } else {
        false
    }
}