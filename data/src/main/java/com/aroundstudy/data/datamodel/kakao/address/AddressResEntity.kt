package com.aroundstudy.data.datamodel.kakao.address

import android.os.Parcelable
import com.aroundstudy.domain.model.kakao.address.AddressDoc
import com.aroundstudy.domain.model.kakao.address.AddressMeta
import com.aroundstudy.domain.model.kakao.address.AddressRes
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddressResEntity(
    @SerializedName("meta")
    val _meta: AddressMetaEntity,
    @SerializedName("documents")
    val _documents: ArrayList<AddressDocEntity>
) : Parcelable, AddressRes {
    override val meta: AddressMeta
        get() = _meta
    override val documents: ArrayList<AddressDoc>
        get() = ArrayList(_documents ?: arrayListOf())
}