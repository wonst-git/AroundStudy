package com.aroundstudy.domain.model.kakao.coord_address

interface CoordToAddress {
    val addressName: String
    val region1DepthName: String
    val region2DepthName: String
    val region3DepthName: String
    val mountainYN: String
    val mainAddressNo: String
    val subAddressNo: String
}