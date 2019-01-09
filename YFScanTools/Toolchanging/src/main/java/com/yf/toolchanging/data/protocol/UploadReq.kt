package com.yf.milling.data.protocol

data class UploadReq(val millingMaterialno:String, val millingToolno:String,
                     val millingAge:String, val millingDistance:String,
                     val millingUser:String, val millingPcb:String)