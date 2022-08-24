package com.example.sandsyndicate.TruckOwner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.Profile
import com.example.sandsyndicate.databinding.ActivityTruckOwnerHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TruckOwnerHome : AppCompatActivity() {
    private lateinit var binding: ActivityTruckOwnerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTruckOwnerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Profile.setOnClickListener {
            startActivity(Intent(this,Profile::class.java))
        }
        binding.truckList.setOnClickListener{
            startActivity(Intent(this,ViewTruckList::class.java
            ))
        }


        binding.trucklogout.setOnClickListener {
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