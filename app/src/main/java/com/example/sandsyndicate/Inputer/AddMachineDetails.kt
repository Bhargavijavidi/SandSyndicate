package com.example.sandsyndicate.Inputer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityAddMachineDetailsBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class
AddMachineDetails : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private var database =
        Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    var machinename = ""
    var fuel = ""
    var startnumber = ""
    var endnumber = ""
    var drivername = ""
    private lateinit var binding: ActivityAddMachineDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMachineDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        binding.addbutton.setOnClickListener {
            mdvalid()
        }
    }

    private fun mdvalid() {
        machinename = binding.machine.text.toString()
        fuel = binding.fuel.text.toString()
        startnumber = binding.startno.text.toString()
        endnumber = binding.endno.text.toString()
        drivername = binding.drivername.text.toString()
        if (machinename.isEmpty()) {
            binding.machine.error = "This field shouldn't be empty"
        } else if (fuel.isEmpty()) {
            binding.fuel.error = "This field shouldn't  be empty"
        } else if (startnumber.isEmpty()) {
            binding.startno.error = "This field shouldn't be empty"
        } else if (endnumber.isEmpty()) {
            binding.endno.error = "This field shouldn't be empty"
        } else if (drivername.isEmpty()) {
            binding.drivername.error = "This field shouldn't be empty"
        } else {
            insertData()
        }

    }

    private fun insertData() {
        var insMd = database.getReference("MachineDeets").child(onlyDate()).child(onlyTime())
        insMd.child("Drivername").setValue(binding.drivername.text.toString())
        insMd.child("Fuel").setValue(binding.fuel.text.toString())
        insMd.child("Startnumber").setValue(binding.startno.text.toString())
        insMd.child("Endnumber").setValue(binding.endno.text.toString())
        insMd.child("Machine name").setValue(binding.machine.text.toString())
        refreshtf()
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

   /* fun currentTimeDate(): String {
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat
        var date: String
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date = simpleDateFormat.format(calendar.time)
        return date
    }*/

    fun refreshtf() {
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
