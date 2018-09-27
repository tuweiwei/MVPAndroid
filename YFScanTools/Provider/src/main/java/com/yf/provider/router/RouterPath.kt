package com.yf.provider.router

/*
    模块路由 路径定义
 */
object RouterPath{
    //用户模块
    class UserCenter{
        companion object {
            const val PATH_LOGIN = "/userCenter/login"
        }
    }

    //用户模块
    class App{
        companion object {
            const val PATH_MAIN = "/app/main"
        }
    }

    class OrderCenter{
        companion object {
            const val PATH_ORDER_CONFIRM = "/orderCenter/confirm"
        }
    }

    //锡膏模块
    class TidModule{
        companion object {
            const val PATH_TID = "/Tidmodule/tid"
        }
    }

    //消息模块
    class MessageCenter{
        companion object {
            const val PATH_MESSAGE_PUSH = "/messageCenter/push"
            const val PATH_MESSAGE_ORDER = "/messageCenter/order"
        }
    }


}
