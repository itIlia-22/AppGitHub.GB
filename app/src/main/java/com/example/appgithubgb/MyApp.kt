package com.example.appgithubgb

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.appgithubgb.room.database.DataBGitHub
import com.example.appgithubgb.utils.ConnetivityListener
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class MyApp: Application() {

    val dataBase:DataBGitHub by lazy {
        DataBGitHub.create(this)
    }
    private lateinit var connetivityListener: ConnetivityListener

     companion object{
         lateinit var instance: MyApp
     }
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
/*        connetivityListener = ConnetivityListener(
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        )*/



    }

    fun getConnectObservable() = connetivityListener.status()
    fun getConnectSingle() = connetivityListener.statusSingle()

}