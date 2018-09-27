package com.yf.messagecenter.data.protocol

//
//id": 5,
//"equipname": null,
//"equipno": "LJ-D-G-SBJ000-001",
//"fileno": "5.4.1",
//"spotinspectionitem": "传动部位加油",
//"frequency": "M"
data class SpotItem(val id : Int,val equipname : String, val equipno: String,
                    val fileno : String, val spotinspectionitem: String, val frequency: String)