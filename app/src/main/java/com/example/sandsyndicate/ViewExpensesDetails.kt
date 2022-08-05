package com.example.sandsyndicate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.databinding.ActivityViewExpensesDetailsBinding

class ViewExpensesDetails : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var binding: ActivityViewExpensesDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewExpensesDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //used for list refresh
        binding.listexpense.setOnRefreshListener() {
            Handler().postDelayed({
                refreshtofinish()
                binding.listexpense.isRefreshing = false

            }, 2000)
        }
    }

    fun refreshtofinish() {
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}