package com.example.appgithubgb.repository.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appgithubgb.R
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.repository.userinfo.OnItemClickListener

class UserAdapter(
    private val onItemClickListener: OnItemClickListener,
) : RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {


    var user: List<GitHubUser> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        return GithubUserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(user[position])
    }

    override fun getItemCount(): Int = user.size


    inner class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val uLogin by lazy {
            itemView.findViewById<TextView>(R.id.tvUserLogin)
        }

        fun bind(item: GitHubUser) = with(item) {
            uLogin.text = login

            itemView.setOnClickListener {
                onItemClickListener.ItemClick(login)
            }


        }


    }


}