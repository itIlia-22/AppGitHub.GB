package com.example.appgithubgb.repository.impl

import com.example.appgithubgb.model.GitHubUser
import com.example.modelviewpresenter.lesson2.view.GithubRepo

class UserRepositoryImpl: GithubRepo {

    private val repo = listOf(
        GitHubUser("Vovka"),
        GitHubUser("Alisa"),
        GitHubUser("Liza"),
        GitHubUser("Ivan"),
        GitHubUser("Moscow")
    )


    override fun getUsers(): List<GitHubUser> {
        return repo
    }
}