package com.example.sandsyndicate.Inputer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.*
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityInputerHomeBinding

class InputerHome : AppCompatActivity() {
    private lateinit var binding: ActivityInputerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Sanddetails.setOnClickListener {
            var sandintent=Intent(this,AddSandDetails::class.java)
            startActivity(sandintent)
        }
        binding.addmachine.setOnClickListener {
          var macintent=Intent(this,AddMachineDetails::class.java)
            startActivity(macintent)
        }
        binding.addexpense.setOnClickListener {
            var expintent=Intent(this,AddExpenseDetails::class.java)
            startActivity(expintent)
        }
        binding.viewexpense.setOnClickListener {
           var viewexpintent=Intent(this,ViewExpensesDetails::class.java)
            startActivity(viewexpintent)
        }
        binding.MachineDetails.setOnClickListener {
            var Mintent=Intent(this,ViewMachineDetails::class.java)
            startActivity(Mintent)
        }
        binding.viewsanddetails.setOnClickListener {
            var viewsandintent=Intent(this,ViewSandDetails::class.java)
            startActivity(viewsandintent)
        }
        binding.Profile.setOnClickListener {
            var profileintent=Intent(this,Profile::class.java)
            startActivity(profileintent)
        }
        binding.inputterlogout.setOnClickListener {
            var logintent=Intent(this,Login::class.java)
            startActivity(logintent)
        }
    }
}