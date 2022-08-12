package com.example.appgithubgb.view

import com.example.appgithubgb.main.AdapterUser
import com.example.appgithubgb.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface OnItemFragment: MvpView {
    fun mIatem(gitHubUser: GitHubUser)

}