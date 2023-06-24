package com.aroundstudy.data.datamodel.server.study

import android.os.Parcelable
import com.aroundstudy.domain.model.server.study.StudyVoteItemData
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudyVoteItemDataEntity(
    val _itemTitle: String,
    val _voteMembers: ArrayList<String>
) : Parcelable, StudyVoteItemData {
    override val itemTitle: String
        get() = _itemTitle
    override val voteMembers: ArrayList<String>
        get() = _voteMembers
}