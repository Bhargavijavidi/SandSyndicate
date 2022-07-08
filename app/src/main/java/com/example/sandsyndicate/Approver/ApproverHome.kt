package com.example.sandsyndicate.Approver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.*
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityApproverHomeBinding

class ApproverHome : AppCompatActivity() {
    private lateinit var binding:ActivityApproverHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityApproverHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.details.setOnClickListener {
            var detailsintent=Intent(this,ApproveDetails::class.java)
            startActivity(detailsintent)
        }
        binding.Approverprofile.setOnClickListener {
            var approveintent=Intent(this,Profile::class.java)
            startActivity(approveintent)


        }
        binding.ApproverMachinedetails.setOnClickListener {
            var Approvemachintent=Intent(this,ViewMachineDetails::class.java)
            startActivity(Approvemachintent)
        }
        binding.ApproverExpenses.setOnClickListener {
            var expintent=Intent(this,ViewExpensesDetails::class.java)
            startActivity(expintent)
        }
        binding.Sanddetails.setOnClickListener {
            var Sandintent=Intent(this,ViewSandDetails::class.java)
            startActivity(Sandintent)
        }
        binding.ApproverLogout.setOnClickListener {
            var logintent=Intent(this,Login::class.java)
            startActivity(logintent)
        }
    }
}