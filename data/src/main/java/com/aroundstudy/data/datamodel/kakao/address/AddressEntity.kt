package com.aroundstudy.data.datamodel.kakao.address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.address.Address
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddressEntity(
    @SerializedName("address_name")
    val _addressName: String,
    @SerializedName("region_1depth_name")
    val _region1depthName: String,
    @SerializedName("region_2depth_name")
    val _region2depthName: String,
    @SerializedName("region_3depth_name")
    val _region3depthName: String,
    @SerializedName("region_3depth_h_name")
    val _region3depthHName: String,
    @SerializedName("h_code")
    val _hCode: String,
    @SerializedName("b_code")
    val _bCode: String,
    @SerializedName("mountain_yn")
    val _mountainYN: String,
    @SerializedName("main_address_no")
    val _mainAddressNo: String,
    @SerializedName("sub_address_no")
    val _subAddressNo: String,
    @SerializedName("x")
    val _x: String,
    @SerializedName("y")
    val _y: String
) : Parcelable, Address {
    override val addressName: String
        get() = _addressName
    override val region1depthName: String
        get() = _region1depthName
    override val region2depthName: String
        get() = _region2depthName
    override val region3depthName: String
        get() = _region3depthName
    override val region3depthHName: String
        get() = _region3depthHName
    override val hCode: String
        get() = _hCode
    override val bCode: String
        get() = _bCode
    override val mountainYN: String
        get() = _mountainYN
    override val mainAddressNo: String
        get() = _mainAddressNo
    override val subAddressNo: String
        get() = _subAddressNo
    override val x: String
        get() = _x
    override val y: String
        get() = _y
}