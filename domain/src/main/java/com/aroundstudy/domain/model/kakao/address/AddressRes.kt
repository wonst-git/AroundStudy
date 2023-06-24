package com.aroundstudy.domain.model.kakao.address

interface AddressRes {
    val meta: AddressMeta
    val documents: ArrayList<AddressDoc>
}