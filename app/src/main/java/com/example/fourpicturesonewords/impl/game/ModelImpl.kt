package com.example.fourpicturesonewords.impl.game

import com.example.fourpicturesonewords.contract.GameFragmentContract
import com.example.fourpicturesonewords.data.Database
import com.example.fourpicturesonewords.model.Pictures

class ModelImpl : GameFragmentContract.Model {
    private val pictures: ArrayList<Pictures> = Database.instance!!.allQuestions
    override operator fun get(level: Int): Pictures {
        return pictures[level]
    }

    override val allLevel: ArrayList<Pictures>
        get() = pictures

}