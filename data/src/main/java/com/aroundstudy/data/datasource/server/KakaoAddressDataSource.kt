package com.aroundstudy.data.datasource.server

import com.aroundstudy.data.datamodel.kakao.address.AddressResEntity
import retrofit2.Response

interface KakaoAddressDataSource {
    suspend fun getAddressList(query: String): Response<AddressResEntity>
}