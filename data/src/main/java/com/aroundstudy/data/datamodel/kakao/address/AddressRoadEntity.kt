package com.aroundstudy.data.datamodel.kakao.address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.address.AddressRoad
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddressRoadEntity(
    @SerializedName("address_name")
    val _addressName: String,
    @SerializedName("region_1depth_name")
    val _region1depthName: String,
    @SerializedName("region_2depth_name")
    val _region2depthName: String,
    @SerializedName("region_3depth_name")
    val _region3depthName: String,
    @SerializedName("road_name")
    val _roadName: String,
    @SerializedName("underground_yn")
    val _undergroundYN: String,
    @SerializedName("main_building_no")
    val _mainBuildingNo: String,
    @SerializedName("sub_building_no")
    val _subBuildingNo: String,
    @SerializedName("building_name")
    val _buildingName: String,
    @SerializedName("zone_no")
    val _zoneNo: String,
    @SerializedName("x")
    val _x: String,
    @SerializedName("y")
    val _y: String
) : Parcelable, AddressRoad {
    override val addressName: String
        get() = _addressName
    override val region1depthName: String
        get() = _region1depthName
    override val region2depthName: String
        get() = region2depthName
    override val region3depthName: String
        get() = region3depthName
    override val roadName: String
        get() = _roadName
    override val undergroundYN: String
        get() = _undergroundYN
    override val mainBuildingNo: String
        get() = _mainBuildingNo
    override val subBuildingNo: String
        get() = _subBuildingNo
    override val buildingName: String
        get() = _buildingName
    override val zoneNo: String
        get() = _zoneNo
    override val x: String
        get() = _x
    override val y: String
        get() = _y
}