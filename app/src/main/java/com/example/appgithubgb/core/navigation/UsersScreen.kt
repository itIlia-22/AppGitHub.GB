package com.example.appgithubgb.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.appgithubgb.view.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen:FragmentScreen{
    override fun createFragment(factory: FragmentFactory): Fragment {
       return UserFragment.getInstance()
    }

}