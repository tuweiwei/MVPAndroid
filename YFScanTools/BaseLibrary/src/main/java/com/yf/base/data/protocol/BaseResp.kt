package com.yf.base.data.protocol

//响应对象 json格式返回 out参数 只能返回不能修改
data class BaseResp<out T>(val status:Int , val message: String, val data:T)