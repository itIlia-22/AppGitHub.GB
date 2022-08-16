package com.example.appgithubgb.repository.user

import com.example.appgithubgb.core.navigation.UsersScreen
import com.example.appgithubgb.repository.GithubRepo
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(
    val repo: GithubRepo,
    val router: Router

    ):MvpPresenter<UserView>(){
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
         viewState.initList(repo.getUsers())


    }

    fun openInfoFragment(login:String){
        router.navigateTo(UsersScreen.UsersInfoScreen(login))
    }

    fun onBackPressed(): Boolean {
        router.replaceScreen(UsersScreen)
        return true
    }


}