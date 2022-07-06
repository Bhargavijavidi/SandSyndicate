package com.example.sandsyndicate.Approver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import com.example.sandsyndicate.*
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.Inputer.Logout
import com.example.sandsyndicate.databinding.ActivityApproverHomeBinding

class ApproverHome : AppCompatActivity() {
    private lateinit var binding: ActivityApproverHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityApproverHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Details.setOnClickListener {
            var approveintent=Intent(this,ApproveDetails::class.java)
               startActivity(approveintent)
        }
        binding.Approverprofile.setOnClickListener {
            var profileintent=Intent(this,Profile::class.java)
            startActivity(profileintent)
        }
        binding.ApproverMachinedetails.setOnClickListener {
            var vmdintent=Intent(this,MachineDetails::class.java)
            startActivity((vmdintent))
        }
        binding.ApproverExpenses.setOnClickListener {
            var expintent=Intent(this,Expenses::class.java)
            startActivity(expintent)
        }
        binding.Sanddetails.setOnClickListener {
            var sandintent=Intent(this,Approversanddetails::class.java)
            startActivity(sandintent)
        }
        binding.ApproverLogout.setOnClickListener {
            var logintent=Intent(this,Login::class.java)
            startActivity(logintent)
        }
    }
}