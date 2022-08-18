package com.example.appgithubgb.repository

import com.example.appgithubgb.model.GitHubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepo {
    fun getUsers():Single<List<GitHubUser>>

}