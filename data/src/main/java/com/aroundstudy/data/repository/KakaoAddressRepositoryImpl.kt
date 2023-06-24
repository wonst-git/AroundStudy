package com.aroundstudy.data.repository

import com.aroundstudy.data.datasource.server.KakaoAddressDataSource
import com.aroundstudy.domain.model.kakao.address.AddressRes
import com.aroundstudy.domain.repository.server.KakaoAddressRepository
import retrofit2.Response
import javax.inject.Inject

class KakaoAddressRepositoryImpl @Inject constructor(private val kakaoAddressDataSource: KakaoAddressDataSource) : KakaoAddressRepository {
    @Suppress("UNCHECKED_CAST")
    override suspend fun getAddressList(query: String): Response<AddressRes> = kakaoAddressDataSource.getAddressList(query) as Response<AddressRes>
}