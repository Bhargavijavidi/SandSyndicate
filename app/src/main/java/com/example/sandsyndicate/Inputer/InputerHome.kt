package com.example.sandsyndicate.Inputer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.*
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityInputerHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class InputerHome : AppCompatActivity() {
    private lateinit var binding: ActivityInputerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Sanddetails.setOnClickListener {
         startActivity(Intent(this,AddSandDetails::class.java))
        }
        binding.addmachine.setOnClickListener {
            startActivity(Intent(this,AddMachineDetails::class.java))
        }
        binding.addexpense.setOnClickListener {
            startActivity(Intent(this,AddExpenseDetails::class.java))
        }
        binding.inputtertrucklist.setOnClickListener{
            startActivity(Intent(this,addtrucklist::class.java))
        }
        binding.viewexpense.setOnClickListener {
            startActivity(Intent(this,ViewExpensesDetails::class.java))
        }
        binding.MachineDetails.setOnClickListener {
            startActivity(Intent(this,ViewMachineDetails::class.java))
        }
        binding.viewsanddetails.setOnClickListener {
            startActivity(Intent(this,ViewSandDetails::class.java))
        }
        binding.Profile.setOnClickListener {
            startActivity(Intent(this,Profile::class.java))
        }
        binding.inputterlogout.setOnClickListener {
            MaterialAlertDialogBuilder(this,)
                .setTitle("Logout")
                .setMessage("Are You Sure You want to logout")
                .setNegativeButton("No"){dialog,which->

                }
                .setPositiveButton("yes"){dialog,which->
                    startActivity(Intent(this,Login::class.java))

                }
                .show();

        }
    }
}