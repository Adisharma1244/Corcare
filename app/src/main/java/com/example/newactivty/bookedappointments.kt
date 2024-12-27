package com.example.newactivty

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class bookedappointments : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookedappointments)

         val firestore = FirebaseFirestore.getInstance() // Initialize Firestore
        val textView=findViewById<TextView>(R.id.textView)
         val appointmentList = ArrayList<String>()
        val listView = findViewById<ListView>(R.id.listView)





        firestore.collection("appointment data").document("userData").get()
           .addOnSuccessListener { documents ->

                    val name = documents.getString("name") ?: "No Name"
                    val time = documents.getString("Time") ?: "No Time"
                    val date = documents.getString("date") ?: "No Date"
                        appointmentList.add("Name:$name")
                        appointmentList.add("Date:$date")
                        appointmentList.add("Time:$time")

               val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, appointmentList)
               listView.adapter = adapter

               adapter.notifyDataSetChanged() // Update ListView
                        }
                        .addOnFailureListener { e ->
               Toast.makeText(this, "Error fetching data: ${e.message}", Toast.LENGTH_LONG).show()
            }

    }
}