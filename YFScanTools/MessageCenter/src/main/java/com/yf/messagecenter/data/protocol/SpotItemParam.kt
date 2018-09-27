package com.yf.em.data.protocol

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/*
   收货地址
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class SpotItemParam(
        val id :Int,
        val equipno: String,
        val equipname:String,
        val frequency: String,
        val username:String
) : Parcelable
