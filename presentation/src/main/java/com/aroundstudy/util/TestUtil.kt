package com.aroundstudy.util

import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.data.datamodel.server.study.StudyScheduleDataEntity
import com.aroundstudy.data.datamodel.server.study.StudyVoteDataEntity
import com.aroundstudy.data.datamodel.server.study.StudyVoteItemDataEntity

object TestUtil {
    val testCategoryList = arrayListOf("취업·이직", "데이터·개발", "디자인", "외국어", "재테크", "창업·부업", "국가고시", "자격증", "인문·교양", "뷰티·패션", "사진·영상", "취미·기타")

    val testStudyList = arrayListOf(
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "외국어", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            true, true, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "재테크", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "데이터·개발", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, true, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "취업·이직", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "디자인", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "외국어", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "데이터·개발", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, true, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "디자인 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "취업·이직", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "디자인", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "취업·이직", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            true, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "디자인", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            true, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "외국어", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, true, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "디자인", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "취업·이직", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "취업·이직", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "데이터·개발", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, true, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "디자인", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "외국어", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, true, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "외국어", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "데이터·개발", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "디자인", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        )
    )

    val testHotStudyList = arrayListOf(
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "외국어", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, true, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "데이터·개발", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            true, false, 50, arrayListOf(), arrayListOf()
        ),
        StudyDataEntity(
            "온라인 아침 출석 영어회화 스터디",
            "아침에 일어나서 온라인으로 서로 인사하고 짧게 영어로 당일 시사 등 얘기하실 분들 참여해주세요. 스터디 시간은 오전 7~9시 사이며 30~40분 정도 짧게 진행됩니다.꾸준히 했으면 좋겠습니다.",
            "디자인", "22.01.20", "비대면(온라인)", "줌, 구글미트, 웨일온", "화, 목, 토 / 오전 7:00",
            arrayListOf("홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"),
            false, false, 50, arrayListOf(
                StudyScheduleDataEntity("스케줄1", "끝난 스케줄1 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1668524400000, 1668610800000),
                StudyScheduleDataEntity("스케줄2", "진행중 스케줄2 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3", "홍길동4"), 1668610800000, 1672412400000),
                StudyScheduleDataEntity("스케줄3", "시작전 스케줄3 데이터 입니다.", arrayListOf("홍길동1", "홍길동2", "홍길동3"), 1672498800000, 1672585200000),
            ), arrayListOf(
                StudyVoteDataEntity(
                    "투표1", arrayListOf(
                        StudyVoteItemDataEntity("투표항목1", arrayListOf("홍길동1", "홍길동2", "홍길동3")),
                        StudyVoteItemDataEntity("투표항목2", arrayListOf("홍길동1", "홍길동2", "홍길동3"))
                    ), true, true, 1672412400000
                )
            )
        )
    )
}