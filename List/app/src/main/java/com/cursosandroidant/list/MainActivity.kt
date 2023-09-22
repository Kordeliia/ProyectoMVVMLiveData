package com.cursosandroidant.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
=======
>>>>>>> parent of 65d5652 (Commit final app)
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursosandroidant.list.databinding.ActivityMainBinding
import kotlin.random.Random

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
class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
=======
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
>>>>>>> parent of 65d5652 (Commit final app)
        setupRecyclerView()
        setupBotton()
    }

    private fun setupBotton() {
        binding.btnSave.setOnClickListener {
            val itemEntity = ItemEntity(Random.nextLong(), binding.etText.text.toString())
            //Accion de salvar para siguiente apartado
        }
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter(this)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onClick(itemEntity: Any) {
        
    }
}