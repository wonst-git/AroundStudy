package com.aroundstudy.data.datamodel.kakao.coord_address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressDoc
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressRes
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordToAddressResEntity(
    @SerializedName("meta")
    val _meta: CoordToAddressMetaEntity,
    @SerializedName("documents")
    val _documents: ArrayList<CoordToAddressDocEntity>
) : CoordToAddressRes, Parcelable {
    override val meta get() = _meta
    override val documents: ArrayList<CoordToAddressDoc> get() = ArrayList(_documents)
}