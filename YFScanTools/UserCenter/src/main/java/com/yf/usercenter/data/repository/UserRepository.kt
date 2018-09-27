package com.yf.usercenter.data.repository

import com.yf.base.data.net.RetrofitFactory
import com.yf.base.data.protocol.BaseResp
import com.yf.user.data.protocol.EditUserReq
import com.yf.usercenter.data.api.UserApi
import com.yf.usercenter.data.protocol.LoginReq
import com.yf.usercenter.data.protocol.RegisterReq
import com.yf.usercenter.data.protocol.ResetPwdReq
import com.yf.usercenter.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject


//数据层
class UserRepository @Inject constructor() {
    /*
       用户注册
    */
    fun register(mobile:String,pwd:String): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile,pwd))
    }

    /*
        用户登录
     */
    fun login(mobile:String,pwd:String): Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile,pwd))
    }

    /*
        重置密码
     */
    fun resetPwd(mobile:String,pwd:String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).resetPwd(ResetPwdReq(mobile,pwd))
    }

    /*
      编辑用户资料
   */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).editUser(EditUserReq(userIcon,userName,userGender,userSign))
    }
}