package com.cursosandroidant.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.concurrent.thread

/****
 * Project: List
 * From: com.cursosandroidant.list
 * Created by Alain Nicolás Tello on 30/09/21 at 11:28
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class MainInteractor {
    val items: MutableLiveData<MutableList<Any>> = MutableLiveData()

    init {
        items.value = mutableListOf()
    }

    fun addItem(itemEntity: Any) {
        items.value?.let {
            val newData: MutableList<Any> = mutableListOf(itemEntity)
            newData.addAll(it)
            items.value = newData
        }
    }

    fun updateItem(itemEntity: Any){
        items.value?.let {
            val index = it.indexOf(itemEntity)
            it.set(index, itemEntity)
        }
    }
}