package com.aroundstudy.data.datamodel.kakao.coord_address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddress
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressDoc
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressRoad
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordToAddressDocEntity(
    @SerializedName("road_address")
    val _roadAddress: CoordToAddressRoadEntity,
    @SerializedName("address")
    val _address: CoordToAddressEntity
) : Parcelable, CoordToAddressDoc {
    override val roadAddress: CoordToAddressRoad get() = _roadAddress
    override val address: CoordToAddress get() = _address
}