package com.example.sandsyndicate.Inputer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.Expenses
import com.example.sandsyndicate.MachineDetails
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityInputerHomeBinding
import kotlin.math.exp

class InputerHome : AppCompatActivity() {
    private lateinit var binding: ActivityInputerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInputerHomeBinding.inflate(layoutInflater)


        setContentView(binding.root)
        binding.Sanddetails.setOnClickListener {
            var sintent=Intent(this,SandDetails::class.java)
        startActivity(sintent)
        }
        binding.addmachine.setOnClickListener {
            var macintent=Intent(this,MachineDetails::class.java)
            startActivity(macintent)
        }
        binding.addexpense.setOnClickListener {
            var expintent=Intent(this,Expenses::class.java)
            startActivity(expintent)

        }
        binding.viewexpense.setOnClickListener {
            var veintent=Intent(this,ViewExpenses::class.java)
            startActivity(veintent)
        }
        binding.viewsanddetails.setOnClickListener {
            var sintent=Intent(this,ViewSandDetails::class.java)
            startActivity(sintent)
        }
        binding.inputterlogout.setOnClickListener {
          var logintent=Intent(this,Login::class.java)
            startActivity(logintent)
        }
    }
}