package com.cursosandroidant.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cursosandroidant.list.databinding.ActivityMainBinding

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
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}