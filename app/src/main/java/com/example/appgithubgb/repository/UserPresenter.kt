package com.example.appgithubgb.repository

import com.example.appgithubgb.model.GitHubUser
import com.example.modelviewpresenter.lesson2.view.GithubRepo
import com.example.modelviewpresenter.lesson2.view.MainViewUser
import moxy.MvpPresenter

class UserPresenter(
    val repo: GithubRepo
    ):MvpPresenter<MainViewUser> (){
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repo.getUsers())
    }

}