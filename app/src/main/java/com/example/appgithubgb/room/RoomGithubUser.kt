package com.example.appgithubgb.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class RoomGithubUser (
    @PrimaryKey
    var id: Long,
    val login: String,
    val avatarUrl:String,
    val repos_url:String

    )
