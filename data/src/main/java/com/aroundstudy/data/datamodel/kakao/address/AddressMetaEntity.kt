package com.aroundstudy.data.datamodel.kakao.address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.address.AddressMeta
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddressMetaEntity(
    @SerializedName("total_count")
    val _totalCount: Int,
    @SerializedName("pageable_count")
    val _pageableCount: Int,
    @SerializedName("is_end")
    val _isEnd: Boolean
) : Parcelable, AddressMeta {
    override val totalCount: Int
        get() = _totalCount
    override val pageableCount: Int
        get() = _pageableCount
    override val isEnd: Boolean
        get() = _isEnd
}