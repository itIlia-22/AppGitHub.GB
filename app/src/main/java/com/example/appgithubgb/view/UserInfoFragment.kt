package com.example.appgithubgb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appgithubgb.MyApp
import com.example.appgithubgb.core.OnBackPressendListener
import com.example.appgithubgb.databinding.ItemListUsersBinding
import com.example.appgithubgb.repository.userinfo.UserInfoPresenter
import com.example.appgithubgb.repository.userinfo.UserInfoView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

const val USER_DETAILS_EXTRA = "USER_DETAILS_EXTRA"

class UserInfoFragment : MvpAppCompatFragment(), UserInfoView, OnBackPressendListener {

    private lateinit var binding: ItemListUsersBinding
    private val presenter by moxyPresenter {
        UserInfoPresenter(MyApp.instance.router)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(USER_DETAILS_EXTRA)?.let {
            binding.InfoUserLogin.text = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return ItemListUsersBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    }


    companion object {


        fun getInstance(login: String):UserInfoFragment{
            val fragment = UserInfoFragment()
            val bundle = Bundle().apply {
                putString(USER_DETAILS_EXTRA, login)
            }
            fragment.arguments = bundle
            return fragment
        }

    }


    override fun onBackPressend() = presenter.onBackPressed()
}