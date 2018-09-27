package com.yf.messagecenter.data.protocol



//"id": 1,
//"spotinspectionworker": "Y00001130",
//"equipname": "LJ-D-G-JQR000-001",
//"executetime": "2018-08-15 16:00:00",
//"frequency": "M",
//"curstatus": "0",
//"createdate": "2018-08-05 16:00:00",
//"isvalid": true
data class SpotTask(val msgicon : String, val id : Int, val spotinspectionworker:String, val equipname: String,
                    val equipno : String,val executetime: String, val frequency : String, val curstatus: String,
                    val createtime : String
                    )