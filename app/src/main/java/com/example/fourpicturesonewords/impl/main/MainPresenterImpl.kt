package com.example.fourpicturesonewords.impl.main

import android.content.Context
import android.view.View
import androidx.navigation.Navigation
import com.example.fourpicturesonewords.R
import com.example.fourpicturesonewords.contract.MainFragmentContract
import com.example.fourpicturesonewords.model.Pictures
import com.example.fourpicturesonewords.utils.MySharedPreference

class MainPresenterImpl(
    repository: MainFragmentContract.Repository,
    view: MainFragmentContract.View,
    context: Context
) : MainFragmentContract.Presenter {
    private val repository: MainFragmentContract.Repository
    private val view: MainFragmentContract.View
    private val context: Context


    override fun init() {
        val sharedPreference: MySharedPreference? = MySharedPreference.getInstance(context)
        view.currentLevel(sharedPreference!!.level + 1)
        val picture: Pictures = repository.getQuestion(sharedPreference.level)!!
        view.loadImageCurrentLevel(
            picture.picturesOne,
            picture.picturesTwo,
            picture.picturesThree,
            picture.picturesFour
        )
    }

    override fun onClickSetting() {
        TODO("Not yet implemented")
    }

    override fun onClickPlay(view: View?) {
        Navigation.findNavController(view!!).navigate(R.id.action_mainFragment_to_gameFragment)
    }

    override fun onClickLanguageButton() {
        TODO("Not yet implemented")
    }

    override fun onClickInfoButton() {
        TODO("Not yet implemented")
    }

    override fun onCLickUzb() {
        TODO("Not yet implemented")
    }

    override fun onClickRus() {
        TODO("Not yet implemented")
    }

    override fun onClickEng() {
        TODO("Not yet implemented")
    }

    init {
        this.repository = repository
        this.view = view
        this.context = context
    }
}