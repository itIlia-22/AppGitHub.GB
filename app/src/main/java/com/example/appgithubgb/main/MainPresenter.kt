package com.example.appgithubgb.main

import com.example.appgithubgb.core.navigation.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    val router: Router

    ):MvpPresenter<MainView> (){
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)




    }

    fun onBackPressed() {
        router.exit()
    }


}