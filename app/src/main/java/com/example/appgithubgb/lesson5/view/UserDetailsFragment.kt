package com.example.appgithubgb.lesson5.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appgithubgb.MyApp
import com.example.appgithubgb.core.OnBackPressendListener
import com.example.appgithubgb.databinding.FragmentDetailsUserBinding
import com.example.appgithubgb.lesson5.loadImage
import com.example.appgithubgb.lesson5.makeGone
import com.example.appgithubgb.lesson5.makeVisible
import com.example.appgithubgb.lesson5.repositoryusers.UsersGitRepositoryImpl
import com.example.appgithubgb.lesson5.retrofit.Network
import com.example.appgithubgb.lesson5.user.DetailsPresenter
import com.example.appgithubgb.model.GitHubUser
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, OnBackPressendListener {

    lateinit var binding: FragmentDetailsUserBinding
    private val presenter: DetailsPresenter by moxyPresenter {
        DetailsPresenter(UsersGitRepositoryImpl(
            Network.usersApi,
            MyApp.instance.dataBase.userDao(),
            MyApp.instance.getConnectSingle()),
            MyApp.instance.router)
    }

    companion object {

        private const val ARG_LOGIN = "ARG_LOGIN"

        fun getInstance(login: String): UserDetailsFragment {
            return UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, login)
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentDetailsUserBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ARG_LOGIN)?.let {
            presenter.loadUser(it)
        }

    }


    override fun onBackPressend() = presenter.onBackPressed()


    override fun showLod() {
        binding?.apply {
            tvUserLogin.makeGone()
            ivUserAvatar.makeGone()
            tvUserRepo.makeGone()
            progress.makeVisible()
        }

    }

    override fun hideLod() {
        binding?.apply {
            tvUserLogin.makeVisible()
            ivUserAvatar.makeVisible()
            tvUserRepo.makeVisible()
            progress.makeGone()
        }
    }

    override fun show(user: GitHubUser) {
        binding?.apply {
            tvUserLogin.text = user.login
            tvUserRepo.text = user.repos_url
            ivUserAvatar.loadImage(user.avatarUrl)
        }

    }

}