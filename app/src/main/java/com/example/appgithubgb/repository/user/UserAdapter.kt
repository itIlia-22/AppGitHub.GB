package com.example.appgithubgb.repository.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appgithubgb.databinding.ItemListBinding
import com.example.appgithubgb.lesson5.loadImage
import com.example.appgithubgb.model.GitHubUser
import com.example.appgithubgb.repository.userinfo.OnItemClickListener
typealias OnItemClickListener = (login: String) -> Unit
class UserAdapter(
    private val onItemClickListener: OnItemClickListener,
) : RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {


    var user: List<GitHubUser> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GithubUserViewHolder(binding,onItemClickListener)

    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(user[position])
    }

    override fun getItemCount(): Int = user.size


    inner class GithubUserViewHolder(
        private val binding: ItemListBinding,
       private val onItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: GitHubUser) = with(binding) {
            tvUserLogin.text = item.login
            ivUserAvatar.loadImage(item.avatarUrl)
            root.setOnClickListener {
                onItemClickListener.ItemClick(item.login)
            }






        }


    }


}