package com.example.appgithubgb.lesson5

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import moxy.viewstate.strategy.StateStrategyType

data class UsersDto(
    @Expose
    @SerializedName("id")
    val id:Long,
    @Expose
    @SerializedName("login")
    val login:String,
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl:String,
    @Expose
    @SerializedName("repos_url")
    val repos_url:String,

)
