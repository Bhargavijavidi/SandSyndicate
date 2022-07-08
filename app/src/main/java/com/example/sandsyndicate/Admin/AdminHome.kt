package com.example.sandsyndicate.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.*
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityAdminHomeBinding

class AdminHome : AppCompatActivity() {
    private lateinit var binding:ActivityAdminHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.approve.setOnClickListener {
            var appintent=Intent(this,Approve::class.java)
            startActivity(appintent)
        }
        binding.excel.setOnClickListener {
            var excelintent=Intent(this,DownloadExcelFIle::class.java)
        startActivity(excelintent)
        }
        binding.MachineDetails.setOnClickListener {
           var machineintent=Intent(this,ViewMachineDetails::class.java)
            startActivity(machineintent)
        }
       binding.Sanddetails.setOnClickListener {
           var sandintent=Intent(this,ViewSandDetails::class.java)
           startActivity(sandintent)

        }
        binding.Profile.setOnClickListener {
            var profileintent=Intent(this,Profile::class.java)
            startActivity(profileintent)
        }
        binding.logout.setOnClickListener {
            var logoutintent=Intent(this,Login::class.java)
            startActivity(logoutintent)
        }


    }
}