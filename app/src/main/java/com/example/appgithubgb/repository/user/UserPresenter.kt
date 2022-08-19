package com.example.appgithubgb.repository.user

import android.util.Log
import com.example.appgithubgb.core.navigation.UsersScreen
import com.example.appgithubgb.repository.GithubRepo
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import java.lang.Exception
import java.util.concurrent.TimeUnit

class UserPresenter(
    val repo: GithubRepo,
    val router: Router,

    ) : MvpPresenter<UserView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLod()
        repo.getUsers()
            .delay(1000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.initList(it)
                viewState.hideLod()
            }, {
                Log.e("1", "Что то пошло не так")
            })


    }

    fun openInfoFragment(login: String) {
        router.navigateTo(UsersScreen.UsersInfoScreen(login))
    }

    fun onBackPressed(): Boolean {
        router.replaceScreen(UsersScreen)
        return true
    }


}