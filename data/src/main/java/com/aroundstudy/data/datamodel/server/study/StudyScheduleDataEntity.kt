package com.aroundstudy.data.datamodel.server.study

import android.os.Parcelable
import com.aroundstudy.domain.model.server.study.StudyScheduleData
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudyScheduleDataEntity(
    val _title: String,
    val _content: String,
    val _members: ArrayList<String>,
    val _startDate: Long,
    val _endDate: Long
) : Parcelable, StudyScheduleData {
    override val startDate: Long
        get() = _startDate
    override val endDate: Long
        get() = _endDate
    override val title: String
        get() = _title
    override val content: String
        get() = _content
    override val members: ArrayList<String>
        get() = _members
}