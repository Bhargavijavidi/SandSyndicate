package com.example.sandsyndicate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.Admin.AdminHome
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainbutton.setOnClickListener {


            startActivity(Intent(this,Login::class.java))
        }
    }
}
