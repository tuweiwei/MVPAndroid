package com.yf.usercenter.service

import com.yf.usercenter.data.protocol.UserInfo
import rx.Observable


interface UserService {

    fun register(username:String,password:String): Observable<Boolean>
    fun login(username:String, password:String):Observable<UserInfo>
    fun resetPwd(username:String,password: String):Observable<Boolean>
    //编辑用户资料
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<UserInfo>
}