package com.aroundstudy.ui.activity.study.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.util.TestUtil
import kotlin.time.TestTimeSource

class StudyDetailViewModel : BaseViewModel() {

    private val _studyData: MutableLiveData<StudyDataEntity> = MutableLiveData<StudyDataEntity>()
    private val _suggestStudyList = MutableLiveData<ArrayList<StudyDataEntity>>(TestUtil.testHotStudyList)

    val studyData: LiveData<StudyDataEntity> get() = _studyData
    val suggestStudyList: LiveData<ArrayList<StudyDataEntity>> get() = _suggestStudyList

    fun setStudyData(study: StudyDataEntity?) {
        study?.let {
            _studyData.value = it
        }
    }
}