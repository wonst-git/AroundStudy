package com.aroundstudy.domain.model.kakao.address

interface Address {
    val addressName: String
    val region1depthName: String
    val region2depthName: String
    val region3depthName: String
    val region3depthHName: String
    val hCode: String
    val bCode: String
    val mountainYN: String
    val mainAddressNo: String
    val subAddressNo: String
    val x: String
    val y: String
}