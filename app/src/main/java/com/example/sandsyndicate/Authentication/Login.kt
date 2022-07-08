package com.example.sandsyndicate.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.Admin.AdminHome
import com.example.sandsyndicate.Approver.ApproverHome
import com.example.sandsyndicate.Inputer.InputerHome
import com.example.sandsyndicate.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Login.setOnClickListener {
          var intent=Intent(this,AdminHome::class.java)
            startActivity(intent)
        }
        binding.Forgot.setOnClickListener {
            var forgot = Intent(this,InputerHome::class.java)
            startActivity(forgot)
        }
        binding.register.setOnClickListener {
            var register=Intent(this,Register::class.java)
            startActivity(register)
        }
    }
}
