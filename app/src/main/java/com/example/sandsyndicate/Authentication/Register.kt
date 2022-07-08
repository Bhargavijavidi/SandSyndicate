package com.example.sandsyndicate.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.Approver.ApproverHome
import com.example.sandsyndicate.R
import com.example.sandsyndicate.TruckOwner.TruckOwnerHome
import com.example.sandsyndicate.databinding.ActivityLoginBinding
import com.example.sandsyndicate.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Signup.setOnClickListener {
            var signintent=Intent(this,ApproverHome::class.java)
            startActivity(signintent)
        }
        binding.Backlogin.setOnClickListener {
            var backintent=Intent(this,TruckOwnerHome::class.java)
            startActivity(backintent)
        }
    }
}