package com.richterapps.classesmodelo

import android.app.Application

class MyApplication: Application() {

    var helperDB:HelperDB?=null
        private set

    companion object{
        lateinit var instance: MyApplication
    }

    override fun onCreate(){
        super.onCreate()
        instance = this
        helperDB = HelperDB(this)
    }
}