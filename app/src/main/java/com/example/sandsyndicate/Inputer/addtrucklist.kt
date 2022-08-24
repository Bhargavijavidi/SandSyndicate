package com.example.sandsyndicate.Inputer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityAddtrucklistBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class addtrucklist : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
            var dname=""
            var truckno=""
    private lateinit var binding: ActivityAddtrucklistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddtrucklistBinding.inflate((layoutInflater))
        setContentView(binding.root)
        actionBar=supportActionBar!!
        actionBar.title="back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        binding.addbutton.setOnClickListener {
           truckvalid()
        }
    }
    private fun truckvalid(){
        dname=binding.truckdriver.text.toString()
        truckno=binding.truckNo.text.toString()
        if (dname.isEmpty()){
            binding.truckdriver.error="This fiels should not be empty"
        }
        else if(truckno.isEmpty()){
            binding.truckNo.error="This fiels should not be empty"
        }
        else{
            insert()
        }
    }
    private fun insert(){
        var truck=database.getReference("Truckdetails").child(onlyDate()).child(onlyDate())
        truck.child("Drivername").setValue(binding.truckdriver.text.toString())
        truck.child("Trucknumber").setValue(binding.truckNo.text.toString())
        refreshtofinish()

    }
    fun onlyDate():String{
        var calendar: Calendar
        var simpleDateFormat:SimpleDateFormat
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
        var calendar:Calendar
        var simpleDateFormat:SimpleDateFormat
        var date:String
        var fData:String
        calendar=Calendar.getInstance()
        simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date =simpleDateFormat.format(calendar.time)
        fData=date.subSequence(11,19).toString()
        return fData


    }


    fun currentTimeDate():String{
        var calendar:Calendar
        var simpleDateFormat:SimpleDateFormat
        var date:String
        calendar=Calendar.getInstance()
        simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date =simpleDateFormat.format(calendar.time)
        return date
    }
    fun refreshtofinish(){
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}