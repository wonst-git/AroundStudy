package com.aroundstudy.domain.repository.server

import com.aroundstudy.domain.model.kakao.address.AddressRes
import retrofit2.Response

interface KakaoAddressRepository {
    suspend fun getAddressList(query: String): Response<AddressRes>
}