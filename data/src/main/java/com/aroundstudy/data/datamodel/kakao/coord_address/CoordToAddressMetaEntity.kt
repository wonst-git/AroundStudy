package com.aroundstudy.data.datamodel.kakao.coord_address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressMeta
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordToAddressMetaEntity(
    @SerializedName("total_count")
    val _totalCount: Int
) : Parcelable, CoordToAddressMeta {
    override val totalCount get() = _totalCount
}