package com.yf.base.rx

import com.yf.base.common.ResultCode
import com.yf.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1


//特针对Boolean类型
class BaseFuncBoolean<T> : Func1<BaseResp<T>,Observable<Boolean>>{
    override fun call(t: BaseResp<T>): Observable<Boolean> {

        if (t.status != ResultCode.SUCCESS){

            return Observable.error(BaseException(t.status,t.message))
        }

        return Observable.just(true)
    }

}