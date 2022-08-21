package com.example.appgithubgb.lesson5.user

import com.example.appgithubgb.lesson5.disposeBy
import com.example.appgithubgb.lesson5.subscribeByDefault
import com.example.appgithubgb.lesson5.view.UserDetailsView
import com.example.appgithubgb.repository.GithubRepo
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class DetailsPresenter(
    val repo: GithubRepo,
    val router: Router,

    ) : MvpPresenter<UserDetailsView>() {
    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLod()
        repo.getGitUsers(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.show(it)
                    viewState.hideLod()
                },
                {}
            ).disposeBy(bag)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }


}