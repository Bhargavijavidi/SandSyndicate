package com.example.sandsyndicate.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.*
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityAdminHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AdminHome : AppCompatActivity() {
    private lateinit var binding:ActivityAdminHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.approve.setOnClickListener{
            startActivity(Intent(this,viewapproverlist::class.java))
        }
        binding.MachineDetails.setOnClickListener {
            startActivity(Intent(this, ViewMachineDetails::class.java))
        }
        binding.Sanddetails.setOnClickListener {
            startActivity(Intent(this, ViewSandDetails::class.java))

        }
        binding.expdetails.setOnClickListener{
            startActivity(Intent(this,ViewExpensesDetails::class.java))
    }
        binding.Profile.setOnClickListener {
            startActivity(Intent(this,Profile::class.java))
        }

        binding.logout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Are You Sure You want to logout")
                .setNegativeButton("No"){dialog, which->

                }
                .setPositiveButton("yes"){dialog, which->
                    startActivity(Intent(this,Login::class.java))

                }
                .show();

        }



    }
}