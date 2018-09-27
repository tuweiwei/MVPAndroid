package com.yf.usercenter.data.api

import com.yf.base.data.protocol.BaseResp
import com.yf.user.data.protocol.EditUserReq
import com.yf.usercenter.data.protocol.LoginReq
import com.yf.usercenter.data.protocol.RegisterReq
import com.yf.usercenter.data.protocol.ResetPwdReq
import com.yf.usercenter.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable


//访问网络 获取数据接口
interface UserApi {
    /*
        用户注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>

    /*
        用户登录
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>


    /*
        修改密码
     */
    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq):Observable<BaseResp<String>>


    /*
        编辑用户资料
     */
    @POST("userCenter/editUser")
    fun editUser(@Body req: EditUserReq):Observable<BaseResp<UserInfo>>

    /*
      积分统计
   */
    @POST("userCenter/score")
    fun calcScore(@Body req: LoginReq):Observable<BaseResp<String>>
}