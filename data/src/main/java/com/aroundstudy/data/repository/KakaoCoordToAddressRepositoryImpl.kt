package com.aroundstudy.data.repository

import com.aroundstudy.data.datasource.server.KakaoCoordToAddressDataSource
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressRes
import com.aroundstudy.domain.repository.server.KakaoCoordToAddressRepository
import retrofit2.Response
import javax.inject.Inject

class KakaoCoordToAddressRepositoryImpl @Inject constructor(private val kakaoCoordToAddressDataSource: KakaoCoordToAddressDataSource) : KakaoCoordToAddressRepository {
    @Suppress("UNCHECKED_CAST")
    override suspend fun getCoordToAddressList(longitude: String, latitude: String): Response<CoordToAddressRes> = kakaoCoordToAddressDataSource.getCoordToAddressList(longitude, latitude) as Response<CoordToAddressRes>
}