package com.aroundstudy.data.datasource.server

import com.aroundstudy.data.datamodel.kakao.coord_address.CoordToAddressResEntity
import retrofit2.Response

interface KakaoCoordToAddressDataSource {
    suspend fun getCoordToAddressList(longitude: String, latitude: String): Response<CoordToAddressResEntity>
}