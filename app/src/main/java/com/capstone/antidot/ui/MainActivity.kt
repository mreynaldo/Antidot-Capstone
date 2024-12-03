package com.capstone.antidot.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.antidot.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var profilePicture: ImageView
    private lateinit var greetingText: TextView
    private lateinit var reminderTime: TextView
    private lateinit var reminderMedicine: TextView
    private lateinit var reminderInstruction: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize Views
//        profilePicture = findViewById(R.id.profile_picture)
//        greetingText = findViewById(R.id.greeting_text)
//        reminderTime = findViewById(R.id.reminder_time)
//        reminderMedicine = findViewById(R.id.reminder_medicine)
//        reminderInstruction = findViewById(R.id.reminder_instruction)

        // Set Example Data
        greetingText.text = "Hi, Darlene Robertson!"
        reminderTime.text = "09:00"
        reminderMedicine.text = "Nama Obat"
        reminderInstruction.text = "Sebelum/Setelah Makan"

        // Setup Bottom Navigation
//        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
//        bottomNavigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.nav_home -> {
//                    Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.nav_diagnosis -> {
//                    Toast.makeText(this, "Diagnosis Selected", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.nav_history -> {
//                    Toast.makeText(this, "History Selected", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                else -> false
//            }
//        }
    }
}