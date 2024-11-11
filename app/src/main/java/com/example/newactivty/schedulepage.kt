package com.example.newactivty

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class schedulepage : AppCompatActivity() {
    lateinit var tvdate:TextView
    private val calendar = Calendar.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedulepage)

        tvdate = findViewById<TextView>(R.id.editEditTextdate)
        val button = findViewById<Button>(R.id.button2 )

        tvdate.setOnClickListener{
            val datee = DatePickerDialog(this,{DatePicker,year:Int,monthOfYear: Int,dayOfMonth:Int ->
                val selectedDate =Calendar.getInstance()
                selectedDate.set(year,monthOfYear,dayOfMonth)

                val dateFormat = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())

                val formatedDate = dateFormat.format(selectedDate.time)

                tvdate.text = formatedDate

            },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datee.show()
        }


         button.setOnClickListener {

               val name = findViewById<EditText>(R.id.editTextText)
               val name1 = name.text.toString()
               val editText = findViewById<EditText>(R.id.editTextTime)
               val time = editText.text.toString()
               val dateText = tvdate.text.toString()

             if (""==name1 ||""==time||""==dateText){
                 Toast.makeText(this, "PLEAS recheck your Detalis", Toast.LENGTH_LONG).show()

             }



             else{
            val intent = Intent(this, fixappointment::class.java).also {
                it.putExtra("Time", time)
                it.putExtra("date", dateText)
                it.putExtra("Name", name1)
                startActivity(it)
            }
            }
         }

    }
}