package com.example.sandsyndicate.Inputer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityAddSandDetailsBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class AddSandDetails : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    var drivername=""
    var Trucknumber=""
    var qualitybrass=""
    var message=""
    var sitenumber=""
    private lateinit var binding: ActivityAddSandDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddSandDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        binding.subbutton.setOnClickListener {
            validsand()
        }
    }
    private fun validsand(){
        drivername=binding.driver.text.toString()
        Trucknumber=binding.truck.text.toString()
        qualitybrass=binding.quality.text.toString()
        message=binding.message.text.toString()
        sitenumber=binding.siteno.text.toString()
        if(drivername.isEmpty()){
            binding.driver.error="This field shouldn't be empty"
        }
        else if(Trucknumber.isEmpty()){
            binding.truck.error="This field shouldn't be empty"
        }
        else if(qualitybrass.isEmpty()){
            binding.quality.error="This field shouldn't be empty"
        }
        else if(message.isEmpty()){
            binding.message.error="This field shouldn't be empty"
        }
        else if(sitenumber.isEmpty()){
            binding.siteno.error="This field shouldn't be empty"
        }
        else{
            insertData()
        }
    }

    private fun insertData(){
        var insSd=database.getReference("Sanddeets").child(onlyDate()).child(onlyTime())
        insSd.child("Driver Name").setValue(binding.driver.text.toString())
        insSd.child("Truck number").setValue(binding.truck.text.toString())
        insSd.child("Quality brass").setValue(binding.quality.text.toString())
        insSd.child("Message").setValue(binding.message.text.toString())
        insSd.child("site number").setValue(binding.siteno.text.toString())

        refreshtf()
    }
    fun onlyDate():String{
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat
        var date:String
        var fData:String
        calendar = Calendar.getInstance()
        simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date=simpleDateFormat.format(calendar.time)
        fData = date.subSequence(0,10).toString()
        return fData
    }
    fun onlyTime():String
    {
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat
        var date:String
        var fData:String
        calendar= Calendar.getInstance()
        simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date =simpleDateFormat.format(calendar.time)
        fData=date.subSequence(11,19).toString()
        return fData


    }
    /*fun currentTimeDate():String{
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat
        var date:String
        calendar= Calendar.getInstance()
        simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date =simpleDateFormat.format(calendar.time)
        return date
    }*/
    fun refreshtf(){
        startActivity(intent)
        finish()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}