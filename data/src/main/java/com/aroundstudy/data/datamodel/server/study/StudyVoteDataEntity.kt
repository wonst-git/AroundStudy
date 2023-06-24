package com.aroundstudy.data.datamodel.server.study

import android.os.Parcelable
import com.aroundstudy.domain.model.server.study.StudyVoteData
import com.aroundstudy.domain.model.server.study.StudyVoteItemData
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudyVoteDataEntity(
    val _title: String,
    val _voteItem: ArrayList<StudyVoteItemDataEntity>,
    val _isSecret: Boolean,
    val _availMultiple: Boolean,
    val _endDate: Long?
) : Parcelable, StudyVoteData {
    override val title: String
        get() = _title
    override val voteItem: ArrayList<StudyVoteItemData>
        get() = ArrayList(_voteItem.map { StudyVoteItemDataEntity(it._itemTitle, it._voteMembers) })
    override val isSecret: Boolean
        get() = _isSecret
    override val availMultiple: Boolean
        get() = _availMultiple
    override val endDate: Long?
        get() = _endDate
}