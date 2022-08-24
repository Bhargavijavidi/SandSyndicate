package com.example.sandsyndicate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.databinding.ActivityForgotBinding

class ForgotActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var binding:ActivityForgotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityForgotBinding.inflate(layoutInflater)
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