package com.example.appgithubgb.room

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
abstract class UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: RoomGithubUser): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(users: List<RoomGithubUser>): Completable

    @Update
    abstract fun update(user: RoomGithubUser): Completable

    @Delete
    abstract fun delete(users: List<RoomGithubUser>): Completable

    @Query("SELECT * FROM users")
    abstract fun getAll(): Single<List<RoomGithubUser>>

}