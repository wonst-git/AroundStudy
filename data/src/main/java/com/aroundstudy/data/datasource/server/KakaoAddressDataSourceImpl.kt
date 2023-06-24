package com.aroundstudy.data.datasource.server

import com.aroundstudy.data.datamodel.kakao.address.AddressResEntity
import com.aroundstudy.data.service.KakaoService
import retrofit2.Response
import javax.inject.Inject

class KakaoAddressDataSourceImpl @Inject constructor(private val kakaoService: KakaoService) : KakaoAddressDataSource {
    override suspend fun getAddressList(query: String): Response<AddressResEntity> = kakaoService.getAddressList(query)
}