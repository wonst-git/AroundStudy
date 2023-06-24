package com.aroundstudy.domain.model.server.study

interface StudyVoteData {
    val title: String
    val voteItem: ArrayList<StudyVoteItemData>
    val isSecret: Boolean
    val availMultiple: Boolean
    val endDate: Long?
}