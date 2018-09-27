package com.yf.user.service.impl

import com.kotlin.user.service.UploadService
import com.yf.base.ext.convert
import com.yf.user.data.respository.UploadRepository
import rx.Observable
import javax.inject.Inject

/*
    上传业务实现类
 */
class UploadServiceImpl @Inject constructor(): UploadService {

    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
       return repository.getUploadToken().convert()
    }

}
