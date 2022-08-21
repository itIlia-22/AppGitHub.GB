package com.example.appgithubgb.lesson5.view

import com.example.appgithubgb.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView : MvpView {

 fun showLod()
 fun hideLod()
 fun show(user:GitHubUser)


}