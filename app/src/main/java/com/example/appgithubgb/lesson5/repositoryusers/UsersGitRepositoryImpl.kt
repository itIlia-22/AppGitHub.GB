package com.example.appgithubgb.lesson5.repositoryusers

import com.example.appgithubgb.lesson5.UsersApi
import com.example.appgithubgb.lesson5.doCompletable
import com.example.appgithubgb.lesson5.mapper.Mapper
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.repository.GithubRepo
import com.example.appgithubgb.room.UserDAO
import io.reactivex.rxjava3.core.Single

class UsersGitRepositoryImpl constructor(
    private val usersApi: UsersApi,
    private val userDao: UserDAO,
    private val network: Single<Boolean>

    ) : GithubRepo {
    override fun getUsers(): Single<List<GitHubUser>> {
        return network.flatMap {
            if (it){
                FethcFromApi(true)
            }else{
                getFromDao()
            }
        }
    }

    private fun FethcFromApi(shoudPersist: Boolean): Single<List<GitHubUser>> {
        return usersApi.getAllUsers()
            .doCompletable(shoudPersist){
                userDao.insertAll(it.map(Mapper::mapToDAO)  )
            }
            .map { it.map(Mapper::mapToEntity) }
    }

    private fun getFromDao():Single<List<GitHubUser>>{
        return userDao.getAll().map{it.map ( Mapper::mapToEntity )}
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