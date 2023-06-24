package com.aroundstudy.data.datasource.server

import com.aroundstudy.data.datamodel.kakao.coord_address.CoordToAddressResEntity
import com.aroundstudy.data.service.KakaoService
import retrofit2.Response
import javax.inject.Inject

class KakaoCoordToAddressDataSourceImpl @Inject constructor(private val kakaoService: KakaoService) : KakaoCoordToAddressDataSource {
    override suspend fun getCoordToAddressList(longitude: String, latitude: String): Response<CoordToAddressResEntity> = kakaoService.getCoordToAddressList(longitude, latitude)
}