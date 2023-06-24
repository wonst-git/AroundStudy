package com.aroundstudy.domain.model.kakao.coord_address

interface CoordToAddressRes{
    val meta: CoordToAddressMeta
    val documents: ArrayList<CoordToAddressDoc>
}