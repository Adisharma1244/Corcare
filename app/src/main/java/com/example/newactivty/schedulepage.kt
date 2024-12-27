package com.example.newactivty

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class schedulepage : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var tvdate: TextView
    private val calendar = Calendar.getInstance()
    val db = FirebaseFirestore.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedulepage)

        // Initialize Firebase reference
        database = FirebaseDatabase.getInstance().getReference("appointments")
        tvdate = findViewById(R.id.editEditTextdate)
        val nameInput = findViewById<EditText>(R.id.editTextText)
        val timeInput = findViewById<EditText>(R.id.editTextTime)
        val button = findViewById<Button>(R.id.button2)

        // Handle date picker
        tvdate.setOnClickListener {
            val datePicker = DatePickerDialog(this, { _, year, month, day ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, day)

                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                tvdate.text = dateFormat.format(selectedDate.time)
            },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        // Handle button click to save data
        button.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val time = timeInput.text.toString().trim()
            val date = tvdate.text.toString().trim()

            if (name.isEmpty() || time.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                saveToFirebase(name, time, date)
                val tent = Intent(this, payment::class.java)
                startActivity(tent)
//                val appointmentssss = findViewById<Button>(R.id.button2)
//                appointmentssss.setOnClickListener {
//
//
//                }

            }
        }
    }

    private fun saveToFirebase(name: String, time: String, date: String) {
        // Generate a unique key
        val appointmentId = db.collection("appointment data").document("userData")
        if(appointmentId ==null)
        {
            Toast.makeText(this, "Id ${appointmentId}", Toast.LENGTH_SHORT).show()
        }
        // Create a data object
        val appointment = hashMapOf(
            "name" to name,
            "Time" to time,
            "date" to date
        )

        // Save to Firebase
        appointmentId.set(appointment)
            .addOnSuccessListener {
                Toast.makeText(this, "Appointment saved successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to save: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
