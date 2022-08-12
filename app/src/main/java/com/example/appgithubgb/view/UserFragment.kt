package com.example.appgithubgb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appgithubgb.R
import com.example.appgithubgb.core.OnBackPressendListener
import com.example.appgithubgb.databinding.FragmentUserBinding
import com.example.appgithubgb.main.AdapterUser
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.repository.UserPresenter
import com.example.appgithubgb.repository.impl.UserRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(), ViewUser, OnBackPressendListener,OnItemFragment {

    private lateinit var banding: FragmentUserBinding
    private val presenter: UserPresenter by moxyPresenter { UserPresenter(UserRepositoryImpl(),MyApp.instance.router) }

    private val adapter = AdapterUser(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(banding) {
            RecyclerViewUsers.layoutManager = LinearLayoutManager(requireContext())
            RecyclerViewUsers.adapter = adapter



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentUserBinding.inflate(inflater, container, false).also {
            banding = it
        }.root

    }


    companion object {

        @JvmStatic
        fun getInstance() = UserFragment()
    }

    override fun initList(list: List<GitHubUser>) {
        adapter.user = list
    }

    override fun onBackPressend() = presenter.onBackPressed()

    override fun mIatem(gitHubUser: GitHubUser) {
     banding.RecyclerViewUsers.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container,UserInfoFragment.getInstance()).commit()
        }
    }


}