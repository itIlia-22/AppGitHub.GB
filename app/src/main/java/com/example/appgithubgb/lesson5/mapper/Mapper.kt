package com.example.appgithubgb.lesson5.mapper

import com.example.appgithubgb.lesson5.model.UsersDto
import com.example.appgithubgb.model.GitHubUser

object Mapper {
    fun mapToEntity(dto: UsersDto): GitHubUser {
        return GitHubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl,
            repos_url = dto.repos_url

        )
    }

}