package com.example.sandsyndicate.Admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityDownloadExcelFileBinding

class DownloadExcelFIle : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var binding:ActivityDownloadExcelFileBinding
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
