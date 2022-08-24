package com.example.sandsyndicate.Approver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityAddapproverlistBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class addapproverlist : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    var name2=""
    var email2=""
    var contact2=""
    var type2=""
    private lateinit var binding:ActivityAddapproverlistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddapproverlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mode = resources.getStringArray(R.array.modules)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdownitem, mode)
        binding.appspinner.setAdapter(arrayAdapter)
        binding.appspinner.setOnItemClickListener { adapterView, view, i, l ->
            type2=adapterView.getItemAtPosition(i).toString()
        }

        actionBar=supportActionBar!!
        actionBar.title="back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        binding.appadd.setOnClickListener {
            appvalid()
        }
    }
    private fun appvalid(){
        name2=binding.appname.text.toString()
        email2=binding.emial1.text.toString()
        contact2=binding.contact1.text.toString()
        type2=binding.appspinner.text.toString()
        if(name2.isEmpty()){
            binding.appname.error="This field shouldn't be empty"
        }
        else if (email2.isEmpty()){
            binding.emial1.error="This field shouldn't be empty"
        }
        else if(contact2.isEmpty()){
            binding.contact1.error="This field shouldn't be empty"
        }
        else if(type2.isEmpty()){
            binding.appspinner.error="Please select one"
        }
        else{
            insertappdata()
        }
    }
    private fun insertappdata(){
        var app=database.getReference("Approver list details").child(onlyDate()).child(onlyTime())
        app.child("Name").setValue(binding.appname.text.toString())
        app.child("Email").setValue(binding.emial1.text.toString())
        app.child("contact").setValue(binding.contact1.text.toString())
        app.child("Type").setValue(binding.appspinner.text.toString())
        refreshtofinish()
    }
    fun onlyDate(): String {
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat
        var date: String
        var fData: String
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date = simpleDateFormat.format(calendar.time)
        fData = date.subSequence(0, 10).toString()
        return fData
    }

    fun onlyTime(): String {
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat
        var date: String
        var fData: String
        calendar = Calendar.getInstance()
        simpleDateFormat =
            SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date = simpleDateFormat.format(calendar.time)
        fData = date.subSequence(11, 19).toString()
        return fData


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