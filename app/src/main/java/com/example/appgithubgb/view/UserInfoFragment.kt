package com.example.appgithubgb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appgithubgb.core.OnBackPressendListener
import com.example.appgithubgb.databinding.FragmentUserBinding
import com.example.appgithubgb.databinding.ItemListBinding
import com.example.appgithubgb.databinding.ItemListUsersBinding
import com.example.appgithubgb.main.AdapterUser
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.repository.UserPresenter
import com.example.appgithubgb.repository.impl.UserRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserInfoFragment : MvpAppCompatFragment(), ViewUser, OnBackPressendListener {

    private lateinit var banding: ItemListUsersBinding
    private val presenter: UserPresenter by moxyPresenter { UserPresenter(UserRepositoryImpl(),MyApp.instance.router) }

   // private val adapter = AdapterUser(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return ItemListUsersBinding.inflate(inflater, container, false).also {
            banding = it
        }.root

    }


    companion object {

        @JvmStatic
        fun getInstance() = UserInfoFragment()
    }

    override fun initList(list: List<GitHubUser>) {
      //  adapter.user = list
    }

    override fun onBackPressend()= presenter.onBackPressed()
}