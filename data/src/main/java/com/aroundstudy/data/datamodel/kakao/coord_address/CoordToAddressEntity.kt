package com.aroundstudy.data.datamodel.kakao.coord_address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddress
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordToAddressEntity(
    @SerializedName("address_name")
    val _addressName: String,
    @SerializedName("region_1depth_name")
    val _region1DepthName: String,
    @SerializedName("region_2depth_name")
    val _region2DepthName: String,
    @SerializedName("region_3depth_name")
    val _region3DepthName: String,
    @SerializedName("mountain_yn")
    val _mountainYN: String,
    @SerializedName("main_address_no")
    val _mainAddressNo: String,
    @SerializedName("sub_address_no")
    val _subAddressNo: String
) : Parcelable, CoordToAddress {
    override val addressName: String get() = _addressName
    override val region1DepthName: String get() = _region1DepthName
    override val region2DepthName: String get() = _region2DepthName
    override val region3DepthName: String get() = _region3DepthName
    override val mountainYN: String get() = _mountainYN
    override val mainAddressNo: String get() = _mainAddressNo
    override val subAddressNo: String get() = _subAddressNo
}