package com.example.appgithubgb.repository

import com.example.appgithubgb.model.GitHubUser

interface GithubRepo {
    fun getUsers():List<GitHubUser>

}