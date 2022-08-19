package com.example.appgithubgb.view

import android.content.Context
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
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val USER_INFO_EXTRA = "USER_INFO_EXTRA"

class UserInfoFragment : MvpAppCompatFragment(), UserInfoView, OnBackPressendListener {

    private lateinit var binding: ItemListUsersBinding
    private val presenter by moxyPresenter {
        UserInfoPresenter(MyApp.instance.router)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(USER_INFO_EXTRA)?.let {
            binding.InfoUserLogin.text = it
        }

    }
/*
class ConvertJpg(val currentContext:Context){
        val file = File("/app/res/january.log")
        val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
        reader.lines().forEach { println(it) }

    }
 */


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
                putString(USER_INFO_EXTRA, login)
            }
            fragment.arguments = bundle
            return fragment
        }

    }


    override fun onBackPressend() = presenter.onBackPressed()


    override fun showOriginImage(pathImageFile: String) {
        //TODO("Not yet implemented")
    }

    override fun showConvertImage(pathImageFile: String) {
      //  TODO("Not yet implemented")
    }
}