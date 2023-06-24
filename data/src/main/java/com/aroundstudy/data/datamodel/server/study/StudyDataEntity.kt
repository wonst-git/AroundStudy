package com.aroundstudy.data.datamodel.server.study

import android.os.Parcelable
import com.aroundstudy.domain.model.server.study.StudyData
import com.aroundstudy.domain.model.server.study.StudyScheduleData
import com.aroundstudy.domain.model.server.study.StudyVoteData
import com.aroundstudy.domain.model.server.study.StudyVoteItemData
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudyDataEntity(
    val _title: String,
    val _content: String,
    val _category: String,
    val _regDate: String,
    val _process: String,
    val _place: String,
    val _time: String,
    val _members: ArrayList<String>,
    val _isJoin: Boolean,
    val _isWish: Boolean,
    val _maxNumberPeople: Int,
    val _schedule: ArrayList<StudyScheduleDataEntity>,
    val _votes: ArrayList<StudyVoteDataEntity>
) : Parcelable, StudyData {
    override val title: String
        get() = _title
    override val content: String
        get() = _content
    override val category: String
        get() = _category
    override val regDate: String
        get() = _regDate
    override val process: String
        get() = _process
    override val place: String
        get() = _place
    override val time: String
        get() = _time
    override val members: ArrayList<String>
        get() = _members
    override val isJoin: Boolean
        get() = _isJoin
    override val isWish: Boolean
        get() = _isWish
    override val maxNumberPeople: Int
        get() = _maxNumberPeople
    override val schedules: ArrayList<StudyScheduleData>
        get() = ArrayList(_schedule.map { StudyScheduleDataEntity(it._title, it._content, it._members, it._startDate, it._endDate) })
    override val votes: ArrayList<StudyVoteData>
        get() = ArrayList(_votes.map { StudyVoteDataEntity(it._title, it._voteItem, it._isSecret, it._availMultiple, it._endDate) })
}