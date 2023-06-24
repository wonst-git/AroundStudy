package com.aroundstudy.domain.model.server.study

interface StudyScheduleData {
    val startDate: Long
    val endDate: Long
    val title: String
    val content: String
    val members: ArrayList<String>
}