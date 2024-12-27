package com.example.newactivty
import android.annotation.SuppressLint
import com.google.firebase.firestore.FirebaseFirestore
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

import com.google.firebase.database.*
class appointmentBooked : AppCompatActivity() {


    class MainActivity : AppCompatActivity() {

        //private lateinit var listView: ListView
        private val firestore = FirebaseFirestore.getInstance() // Initialize Firestore
        // val appointmentList = ArrayList<String>()      // List to hold data

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_appointment_booked)
            val textView=findViewById<TextView>(R.id.textView)
           val listView = findViewById<ListView>(R.id.listView)

           val appointmentList= listOf("Item1","ItemList2")
            // Set up adapter for ListView
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, appointmentList)
            listView.adapter = adapter

//             Fetch data from Firestore
            firestore.collection("appointment data").document("userData").collection("appointments")
                .get()
                .addOnSuccessListener { documents ->
//                    appointmentList.clear()
                    for (document in documents) {
                        val name = document.getString("name") ?: "No Name"
                        val time = document.getString("time") ?: "No Time"
                        val date = document.getString("date") ?: "No Date"
                        textView.text=date
//                        appointmentList.add("$name - $date @ $time")
                    }
                    adapter.notifyDataSetChanged() // Update ListView
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error fetching data: ${e.message}", Toast.LENGTH_LONG).show()
                }
        }
    }

}