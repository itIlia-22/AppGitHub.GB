package com.example.appgithubgb.repository.user

import com.example.appgithubgb.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {
 fun initList(list: List<GitHubUser>)
 fun showLod()
 fun hideLod()
 fun onLodError()


}