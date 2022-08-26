package com.example.appgithubgb.lesson5.mapper

import com.example.appgithubgb.lesson5.model.UsersDto
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.room.RoomGithubUser

object Mapper {
    fun mapToEntity(dto: UsersDto): GitHubUser {
        return GitHubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl,
            repos_url = dto.repos_url

        )
    }

    fun mapToEntity(roomData: RoomGithubUser): GitHubUser {
        return GitHubUser(
            login = roomData.login,
            id = roomData.id,
            avatarUrl = roomData.avatarUrl,
            repos_url = roomData.repos_url

        )
    }

    fun mapToDAO(dto: UsersDto): RoomGithubUser {
        return RoomGithubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl,
            repos_url = dto.repos_url

        )
    }

}