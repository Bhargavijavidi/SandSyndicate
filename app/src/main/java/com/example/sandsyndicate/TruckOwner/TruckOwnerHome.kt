package com.example.sandsyndicate.TruckOwner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.Profile
import com.example.sandsyndicate.databinding.ActivityTruckOwnerHomeBinding

class TruckOwnerHome : AppCompatActivity() {
    private lateinit var binding: ActivityTruckOwnerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTruckOwnerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.TruckList.setOnClickListener {
            var Homeintent= Intent(this,
                ViewTruckList::class.java)
            startActivity(Homeintent)
        }
        binding.TruckProfile.setOnClickListener {
            var accessintent=Intent(this,Profile::class.java)
            startActivity(accessintent)
        }
        binding.TruckDetails.setOnClickListener {
            var approveintent=Intent(this,
                ViewTruckDetails::class.java)
            startActivity(approveintent)
        }
        binding.TruckLogout.setOnClickListener {
            var logintent=Intent(this,Login::class.java)
            startActivity(logintent)

        }
        }
}