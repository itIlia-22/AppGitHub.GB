package com.example.appgithubgb.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appgithubgb.room.RoomGithubUser
import com.example.appgithubgb.room.UserDAO

@Database(
    entities = [RoomGithubUser::class],
    version = 1)
abstract class DataBGitHub : RoomDatabase() {


    abstract fun userDao(): UserDAO

    companion object {
        fun create(context: Context): DataBGitHub {
            return Room.databaseBuilder(
                context,
                DataBGitHub::class.java,
                "gitHub.db"
            ).build()

        }
    }


}