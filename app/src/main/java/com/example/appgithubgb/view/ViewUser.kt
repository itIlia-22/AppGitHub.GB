package com.example.appgithubgb.view

import com.example.appgithubgb.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ViewUser : MvpView {
 fun initList(list: List<GitHubUser>)


}