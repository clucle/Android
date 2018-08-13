package com.github.clucle.pagingtutor

import android.app.Application

class PagingApplication : Application() {
    init {
        instance = this
    }
    companion object {
        private var instance: PagingApplication? = null
        fun applicationContext() : PagingApplication {
            return instance!!
        }
    }
}
