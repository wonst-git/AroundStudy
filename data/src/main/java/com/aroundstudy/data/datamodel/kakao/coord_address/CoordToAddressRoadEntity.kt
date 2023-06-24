package com.aroundstudy.data.datamodel.kakao.coord_address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressRoad
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordToAddressRoadEntity(
    @SerializedName("address_name")
    val _addressName: String,
    @SerializedName("region_1depth_name")
    val _region1DepthName: String,
    @SerializedName("region_2depth_name")
    val _region2DepthName: String,
    @SerializedName("region_3depth_name")
    val _region3DepthName: String,
    @SerializedName("road_name")
    val _roadName: String,
    @SerializedName("underground_yn")
    val _undergroundYN: String,
    @SerializedName("main_building_no")
    val _mainBuildingNo: String,
    @SerializedName("sub_building_no")
    val _subBuildingNo: String,
    @SerializedName("zone_no")
    val _zoneNo: String
) : Parcelable, CoordToAddressRoad {
    override val addressName: String get() = _addressName
    override val Region1DepthName: String get() = _region1DepthName
    override val Region2DepthName: String get() = _region2DepthName
    override val Region3DepthName: String get() = _region3DepthName
    override val roadName: String get() = _roadName
    override val undergroundYN: String get() = _undergroundYN
    override val mainBuildingNo: String get() = _mainBuildingNo
    override val subBuildingNo: String get() = _subBuildingNo
    override val zoneNo: String get() = _zoneNo
}