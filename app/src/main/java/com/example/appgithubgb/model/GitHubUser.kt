package com.example.appgithubgb.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(val login: String ) : Parcelable


@Parcelize
data class UserInfo(val logIfo:String): Parcelable
