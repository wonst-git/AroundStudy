package com.aroundstudy.data.datamodel.kakao.address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.address.Address
import com.aroundstudy.domain.model.kakao.address.AddressDoc
import com.aroundstudy.domain.model.kakao.address.AddressRoad
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddressDocEntity(
    @SerializedName("address_name")
    val _addressName: String,
    @SerializedName("y")
    val _y: String,
    @SerializedName("x")
    val _x: String,
    @SerializedName("address_type")
    val _addressType: String,
    @SerializedName("address")
    val _address: AddressEntity,
    @SerializedName("road_address")
    val _roadAddress: AddressRoadEntity
) : Parcelable, AddressDoc {
    override val addressName: String
        get() = _addressName
    override val y: String
        get() = _y
    override val x: String
        get() = _x
    override val addressType: String
        get() = _addressType
    override val address: Address
        get() = _address
    override val roadAddress: AddressRoad
        get() = _roadAddress
}