package com.yf.messagecenter.data.protocol


//
//    "taskid" : "885",
//    "equipmentid":"99",
//    "frequency":"M",
//    "item":"检查上板功能",
//    "username":"admin",
//    "itemValue":"xxxxx",
//    "result":"OK"
data class UploadTaskResultReq(val taskid:Int, val equipno : String,
                               val frequency:String, val item: String,val itemValue: String,
                               val username: String,  val result: String,val remark:String)