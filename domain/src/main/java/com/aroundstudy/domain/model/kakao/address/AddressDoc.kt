package com.aroundstudy.domain.model.kakao.address

interface AddressDoc {
    val addressName: String
    val y: String
    val x: String
    val addressType: String
    val address: Address
    val roadAddress: AddressRoad
}