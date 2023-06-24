package com.aroundstudy.util.constants

import android.Manifest

object Constants {
    enum class TitleType {
        CUSTOM,
        LEFT_TITLE,
        CENTER_TITLE,
        MAIN_LOGO,
        MAIN_TITLE,
        SEARCH,
        BTN_BACK,
        BTN_RIGHT1,
        BTN_RIGHT2,
        BTN_RIGHT_TEXT,
    }

    enum class StartState {
        START_ON_BOARDING,
        START_TERMS,
        START_LOGIN,
        START_INPUT_DATA,
        START_COMPLETE
    }

    object LoginAppKey {
        const val KAKAO_APP_KEY = "07e54cac8037a3e8fcf5d9b7ec609da5"
    }

    object Permission {
        val PERMISSION_LOCATION = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
        val PERMISSION_CAMERA = arrayOf(Manifest.permission.CAMERA)
        val PERMISSION_EXTERNAL_STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    object ActivityExtra {
        const val SEARCH_ADDRESS_EXTRA = "searchAddressExtra"
        const val STUDY_MEMBER_EXTRA = "studyMemberExtra"
        const val STUDY_DATA_EXTRA = "studyDataExtra"
        const val STUDY_CATEGORY_EXTRA = "studyCategoryExtra"
    }
}