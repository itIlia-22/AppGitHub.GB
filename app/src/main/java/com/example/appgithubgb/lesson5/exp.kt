package com.example.appgithubgb.lesson5

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.appgithubgb.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_baseline_supervised_user_circle_24)
        .into(this)
}

fun <T> Single<T>.subscribeByDefault(): Single<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun Disposable.disposeBy(bag: CompositeDisposable) {
    bag.add(this)
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}


fun <T> Single<T>.doCompletable(
    pradicate:Boolean,
    completableCreate: (data:T)-> Completable
):Single<T>{
    return if (pradicate){
        this.flatMap {
            completableCreate(it).andThen(Single.just(it))
        }
    }else{
        this
    }
}
