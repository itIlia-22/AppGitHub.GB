package com.example.appgithubgb.main

import android.os.Bundle
import com.example.appgithubgb.R
import com.example.appgithubgb.core.OnBackPressendListener
import com.example.appgithubgb.databinding.ActivityMainBinding
import com.example.appgithubgb.MyApp
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(MyApp.instance.router) }
    private val navigator = AppNavigator(this, R.id.container)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        MyApp.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        MyApp.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressendListener && currentFragment.onBackPressend()) {
                return
            }
        }
        presenter.onBackPressed()

    }
}