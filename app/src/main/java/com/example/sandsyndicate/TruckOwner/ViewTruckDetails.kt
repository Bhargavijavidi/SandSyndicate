package com.example.sandsyndicate.TruckOwner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityViewTruckDetailsBinding

class ViewTruckDetails : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var binding: ActivityViewTruckDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()

    }
}