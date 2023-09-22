package com.cursosandroidant.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursosandroidant.list.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
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
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
        setupRecyclerView()
        setupBotton()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.items.observe(this, { items ->
            adapter.submitList(items)
        })

        mainViewModel.errorMsg.observe(this, {error ->
            Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
        })
    }

    private fun setupBotton() {
        binding.btnSave.setOnClickListener {
            val itemEntity = ItemEntity(Random.nextLong(), binding.etText.text.toString())
            mainViewModel.addItem(itemEntity)
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

    override fun onClick(itemEntity: ItemEntity) {
        mainViewModel.updateItem(itemEntity)
    }
}