package com.example.sandsyndicate

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.Authentication.Register
import com.example.sandsyndicate.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    var name = ""
    var designation = ""
    var emailid= ""
    var address = ""
    private val shared = "Sandsyndicate"
    private lateinit var actionBar: ActionBar
    private lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(shared, MODE_PRIVATE)
       if(name.isEmpty())        {
           binding.proname.error="This field shouldn't be emppty"
       }
        else if(designation.isEmpty()){
            binding.prodesignation.error="This field shouldn't be emppty"
       }
        else if(emailid.isEmpty()){
            binding.proedit.error="This field shouldn't be emppty"
       }
        else if(address.isEmpty()){
            binding.proaddress.error="This field shouldn't be emppty"
       }
        binding.proedit.setOnClickListener {
            startActivity(Intent(this,Register::class.java))
        }
        Toast.makeText(this,sharedPreferences.getString("Name","default"),Toast.LENGTH_LONG).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}




