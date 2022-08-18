package com.example.appgithubgb.repository.impl

import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.repository.GithubRepo
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl: GithubRepo {

    private val repo = listOf(
        GitHubUser("Vovka"),
        GitHubUser("Alisa"),
        GitHubUser("Liza"),
        GitHubUser("Ivan"),
        GitHubUser("Moscow")
    )


    override fun getUsers(): Single<List<GitHubUser>> {
        return Single.create{ listData->
            listData.onSuccess(repo)

        }
    }
}