package com.example.newactivty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class bloodtest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bloodtest)

        val patha = listOf("We care Path lab ","SureTest Path Labs","Max Lab","healthcare Path lab")
        val pathlist= findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,patha)
        pathlist.adapter =adapter
    }
    }