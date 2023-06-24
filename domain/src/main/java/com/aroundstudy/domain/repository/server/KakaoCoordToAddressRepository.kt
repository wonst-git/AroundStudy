package com.aroundstudy.domain.repository.server

import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressRes
import retrofit2.Response

interface KakaoCoordToAddressRepository {
    suspend fun getCoordToAddressList(longitude: String, latitude: String): Response<CoordToAddressRes>
}