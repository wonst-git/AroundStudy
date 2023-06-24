package com.aroundstudy.domain.usecase.server.kakao

import com.aroundstudy.domain.repository.server.KakaoAddressRepository
import javax.inject.Inject

class GetAddressUseCase @Inject constructor(private val kakaoAddressRepository: KakaoAddressRepository) {
    suspend operator fun invoke(query: String) = kakaoAddressRepository.getAddressList(query)
}