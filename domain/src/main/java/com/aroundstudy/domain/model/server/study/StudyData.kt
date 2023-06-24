package com.aroundstudy.domain.model.server.study

interface StudyData {
    val title: String
    val content: String
    val category: String
    val regDate: String
    val process: String
    val place: String
    val time: String
    val members: ArrayList<String>
    val isJoin: Boolean
    val isWish: Boolean
    val maxNumberPeople: Int
    val schedules: ArrayList<StudyScheduleData>
    val votes: ArrayList<StudyVoteData>
}