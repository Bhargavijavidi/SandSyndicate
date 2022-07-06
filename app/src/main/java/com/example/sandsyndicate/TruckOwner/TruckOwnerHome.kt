package com.example.sandsyndicate.TruckOwner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityTruckOwnerHomeBinding

class TruckOwnerHome : AppCompatActivity() {
    private lateinit var binding: ActivityTruckOwnerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTruckOwnerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.truckList.setOnClickListener {
            var Homeintent= Intent(this,TruckList::class.java)
            startActivity(Homeintent)
        }
        binding.Profile.setOnClickListener {
            var accessintent=Intent(this,TruckProfile::class.java)
            startActivity(accessintent)
        }
        binding.truckDetail.setOnClickListener {
            var approveintent=Intent(this,TruckDetails::class.java)
            startActivity(approveintent)
        }
        binding.logout.setOnClickListener {
            var excelintent=Intent(this,TruckLogout::class.java)
            startActivity(excelintent)

        }
        }
}