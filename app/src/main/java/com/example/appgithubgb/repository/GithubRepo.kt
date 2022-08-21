package com.example.appgithubgb.repository

import com.example.appgithubgb.model.GitHubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepo {
    fun getUsers():Single<List<GitHubUser>>
    fun getGitUsers(login:String):Single<GitHubUser>
    fun getRepoUsers(repo:String):Single<GitHubUser>


}