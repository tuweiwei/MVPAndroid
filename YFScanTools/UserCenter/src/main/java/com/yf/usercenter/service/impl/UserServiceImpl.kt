package com.yf.usercenter.service.impl

import com.yf.base.ext.convert
import com.yf.base.ext.convertBoolean
import com.yf.usercenter.data.protocol.UserInfo
import com.yf.usercenter.data.repository.UserRepository
import com.yf.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

//提供注入
class UserServiceImpl @Inject constructor() :UserService{

    @Inject
    lateinit var userRepository:UserRepository

    override fun register(username: String, password: String): Observable<Boolean> {

         return userRepository.register(username,password).convertBoolean()
    }

    override fun login(username: String, password: String): Observable<UserInfo> {
        return userRepository.login(username,password).convert()
    }

    override fun resetPwd(username: String, password: String): Observable<Boolean> {
        return userRepository.resetPwd(username, password).convertBoolean()
    }

    /*
       修改用户资料
    */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return userRepository.editUser(userIcon,userName,userGender,userSign).convert()
    }
}