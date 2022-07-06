package com.example.sandsyndicate.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.Approver.Approve
import com.example.sandsyndicate.Inputer.Logout
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityAdminHomeBinding

class AdminHome : AppCompatActivity() {
    private lateinit var binding:ActivityAdminHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Home.setOnClickListener {
            var Homeintent=Intent(this,Home::class.java)
            startActivity(Homeintent)
        }
        binding.AdminAccess.setOnClickListener {
            var accessintent=Intent(this,Access::class.java)
            startActivity(accessintent)
        }
        binding.Approve.setOnClickListener {
            var approveintent=Intent(this,Approve::class.java)
            startActivity(approveintent)
        }
         binding.Excel.setOnClickListener {
             var excelintent=Intent(this,Excel::class.java)
             startActivity(excelintent)

         }
        binding.Adminlogout.setOnClickListener {
            var logintent=Intent(this,Logout::class.java)
            startActivity(logintent)
        }


        setContentView(R.layout.activity_admin_home)
    }
}