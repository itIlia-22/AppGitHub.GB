package com.example.appgithubgb.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appgithubgb.R
import com.example.appgithubgb.databinding.ItemListBinding
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.view.OnItemFragment
import com.example.appgithubgb.view.UserInfo


class AdapterUser(private val onItemFragment: OnItemFragment) :
    RecyclerView.Adapter<GithubUserViewHolder>() {
    var user: List<GitHubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubUserViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(user[position])

    }

    override fun getItemCount(): Int = user.size

}

class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val uLogin by lazy {
        itemView.findViewById<TextView>(R.id.tvUserLogin)
    }

    fun bind(item: GitHubUser)  {
        uLogin.text = item.login

        uLogin.setOnClickListener {

        }


    }


}