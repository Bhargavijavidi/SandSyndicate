package com.example.sandsyndicate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.databinding.ActivityViewSandDetailsBinding

class ViewSandDetails : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var binding:ActivityViewSandDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewSandDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        //used to refresh list
        binding.listsand.setOnRefreshListener(){
            Handler().postDelayed({
                refreshtofinish()
                binding.listsand.isRefreshing=false
            },2000)
        }
    }
    fun refreshtofinish()
    {
        startActivity(intent)
        finish()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}