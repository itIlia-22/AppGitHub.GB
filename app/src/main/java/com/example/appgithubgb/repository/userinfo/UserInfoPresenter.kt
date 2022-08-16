package com.example.appgithubgb.repository.userinfo

import com.example.appgithubgb.core.navigation.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserInfoPresenter(
    val router: Router,

    ) : MvpPresenter<UserInfoView>() {


    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }


}