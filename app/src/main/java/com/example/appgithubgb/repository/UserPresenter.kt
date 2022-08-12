package com.example.appgithubgb.repository

import com.example.modelviewpresenter.lesson2.view.GithubRepo
import com.example.appgithubgb.view.ViewUser
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(
    val repo: GithubRepo,
    val router: Router

    ):MvpPresenter<ViewUser> (){
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
         viewState.initList(repo.getUsers())


    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }


}