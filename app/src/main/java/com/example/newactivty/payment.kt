package com.example.newactivty

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pament)
        val  UPI_PAYMENT =1
        val btnPay: Button = findViewById(R.id.button4)



        btnPay.setOnClickListener {
            val upiId = "garimasharma567890@okicici"  // Payee UPI ID (this should be your Google Pay linked UPI ID)
            val name = "Gpay"  // Payee Name (Optional)
            val note = "Payment for Services"  // Transaction note
            val amountValue = "27"

            if (amountValue.isEmpty()) {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Construct the UPI URI with all necessary parameters
            val uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)  // Payee UPI ID
                .appendQueryParameter("pn", name)   // Payee Name (Optional)
                .appendQueryParameter("tn", note)   // Transaction Note
                .appendQueryParameter("am", amountValue)  // Amount to be paid
                .appendQueryParameter("cu", "INR")  // Currency (INR)
                .build()


            val gpayIntent = Intent(Intent.ACTION_VIEW).apply {
                data = uri
                setPackage("com.google.android.apps.nbu.paisa.user")  // Specifically open Google Pay
            }
            startActivity(gpayIntent)

            // Check if Google Pay is installed
//            if (gpayIntent.resolveActivity(packageManager) != null) {
//                startActivity(gpayIntent)
//            } else {
//                Toast.makeText(this, "Google Pay is not installed on your device!", Toast.LENGTH_SHORT).show()
//            }
//            val upiPayIntent = Intent(Intent.ACTION_VIEW)
//            upiPayIntent.data = uri
//
//            // Check if there is any UPI app (like Google Pay) available to handle this request
////            val chooser = Intent.createChooser(upiPayIntent, "Pay with")
//            if (upiPayIntent.resolveActivity(packageManager) != null) {
//                startActivity(upiPayIntent)  // Open Google Pay or any other UPI app
//            } else {
//                Toast.makeText(this, "No UPI app found!", Toast.LENGTH_SHORT).show()  // If no UPI apps are available
//            }
        }

    }
}