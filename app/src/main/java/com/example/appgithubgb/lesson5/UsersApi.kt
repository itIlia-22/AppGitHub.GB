package com.example.appgithubgb.lesson5

import com.example.appgithubgb.lesson5.model.UsersDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path




interface UsersApi {
    @GET("/users")
    fun getAllUsers(): Single<List<UsersDto>>

    @GET("/users/{login}")
    fun getUser(@Path("login") login: String): Single<UsersDto>

    @GET("/users/{repos_url}/repos")
    fun getRepo(@Path("repos_url") repos_url: String): Single<UsersDto>






}