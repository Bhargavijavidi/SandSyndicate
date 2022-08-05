package com.example.sandsyndicate.Approver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.*
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityApproverHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ApproverHome : AppCompatActivity() {
    private lateinit var binding:ActivityApproverHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityApproverHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.details.setOnClickListener {
            startActivity(Intent(this,ApproveDetails::class.java))
        }
        binding.Approverprofile.setOnClickListener {
            startActivity(Intent(this,Profile::class.java))
        }
        binding.ApproverMachinedetails.setOnClickListener {
            startActivity(Intent(this,ViewMachineDetails::class.java))
        }
        binding.ApproverExpenses.setOnClickListener {
            startActivity(Intent(this,ViewExpensesDetails::class.java))
        }
        binding.Sanddetails.setOnClickListener {
            startActivity(Intent(this,ViewSandDetails::class.java))
        }
        binding.ApproverLogout.setOnClickListener {
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