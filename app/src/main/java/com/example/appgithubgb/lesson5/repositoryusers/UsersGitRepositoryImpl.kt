package com.example.appgithubgb.lesson5.repositoryusers

import com.example.appgithubgb.lesson5.UsersApi
import com.example.appgithubgb.lesson5.mapper.Mapper
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.repository.GithubRepo
import io.reactivex.rxjava3.core.Single

class UsersGitRepositoryImpl constructor(
    private val usersApi: UsersApi
    ):GithubRepo {
    override fun getUsers(): Single<List<GitHubUser>> {
       return usersApi.getAllUsers()
           .map{it.map(Mapper::mapToEntity)}
    }

    override fun getGitUsers(login: String): Single<GitHubUser> {
        return usersApi.getUser(login)
            .map(Mapper::mapToEntity)
    }

    override fun getRepoUsers(repo: String): Single<GitHubUser> {
        return usersApi.getRepo(repo)
            .map(Mapper::mapToEntity)
    }
}