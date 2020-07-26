package com.example.recyclerviewclicks

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var btnDelete: Button? = null
    val adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupAdapter()
        setupListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.plus->adapter.add(ItemData("new 1","new 2"))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.recyclerview)
        btnDelete = findViewById(R.id.btnDelete)

    }

    private fun setupAdapter() {
        recyclerView?.adapter = adapter
        adapter.update(getData())

    }

    private fun setupListeners() {
        btnDelete?.setOnClickListener {
            adapter.delete(0)
        }

    }

    private fun getData(): ArrayList<ItemData> {
        val list = arrayListOf<ItemData>()
        for (i in 1..50) {
            list.add(ItemData("title $i", "love $i"))
        }
        return list
    }
}
