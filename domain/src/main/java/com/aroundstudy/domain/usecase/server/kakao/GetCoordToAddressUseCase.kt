package com.aroundstudy.domain.usecase.server.kakao

import com.aroundstudy.domain.repository.server.KakaoCoordToAddressRepository
import javax.inject.Inject

class GetCoordToAddressUseCase @Inject constructor(private val kakaoCoordToAddressRepository: KakaoCoordToAddressRepository) {
    suspend operator fun invoke(longitude: String, latitude: String) = kakaoCoordToAddressRepository.getCoordToAddressList(longitude, latitude)
}