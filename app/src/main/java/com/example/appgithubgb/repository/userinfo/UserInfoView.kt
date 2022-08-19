package com.example.appgithubgb.repository.userinfo

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserInfoView:MvpView {
    fun showOriginImage(pathImageFile: String)
    fun showConvertImage(pathImageFile: String)
}