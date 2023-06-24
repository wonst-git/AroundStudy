package com.aroundstudy.data.service

import com.aroundstudy.data.datamodel.kakao.address.AddressResEntity
import com.aroundstudy.data.datamodel.kakao.coord_address.CoordToAddressResEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoService {

    @GET("v2/local/search/address.json")
    suspend fun getAddressList(
        @Query("query") query: String,
        @Query("size") size: Int = 30,
        @Header(AUTHORIZATION) authorization: String = REST_KEY
    ): Response<AddressResEntity>

    @GET("v2/local/geo/coord2address.json")
    suspend fun getCoordToAddressList(
        @Query("x") longitude: String,
        @Query("y") latitude: String,
        @Header(AUTHORIZATION) authorization: String = REST_KEY
    ): Response<CoordToAddressResEntity>

    companion object {
        const val BASE_URL = "https://dapi.kakao.com"
        const val TIME_OUT = 15L
        const val AUTHORIZATION = "Authorization"
        const val REST_KEY = "KakaoAK 14524f0b57fdfcd9f4a8f3892db1b0ff"
    }
}