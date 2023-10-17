package com.example.fourpicturesonewords.impl.main

import com.example.fourpicturesonewords.contract.MainFragmentContract
import com.example.fourpicturesonewords.data.Database
import com.example.fourpicturesonewords.model.Pictures

class MainModelImpl : MainFragmentContract.Repository{
    private val pictures: ArrayList<Pictures> = Database.instance!!.allQuestions
    override fun getQuestion(level: Int): Pictures {
        return pictures[level]
    }
}