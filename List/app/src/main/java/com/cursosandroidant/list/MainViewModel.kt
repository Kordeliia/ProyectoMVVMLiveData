package com.cursosandroidant.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/****
 * Project: List
 * From: com.cursosandroidant.list
 * Created by Alain Nicolás Tello on 30/09/21 at 11:27
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class MainViewModel : ViewModel() {
    private var interactor = MainInteractor()

    val items = interactor.items

    val errorMsg: MutableLiveData<String> = MutableLiveData()

    fun addItem(itemEntity: Any){
        try {
            interactor.addItem(itemEntity)
        } catch (e: Exception) {
            errorMsg.value = e.message
        }
    }

    fun updateItem(itemEntity: Any){
        try {
            interactor.updateItem(itemEntity)
        } catch (e: Exception) {
            errorMsg.value = e.message
        }
    }
}