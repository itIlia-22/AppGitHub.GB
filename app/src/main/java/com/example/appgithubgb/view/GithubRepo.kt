package com.example.modelviewpresenter.lesson2.view

import com.example.appgithubgb.model.GitHubUser

interface GithubRepo {
    fun getUsers():List<GitHubUser>

}