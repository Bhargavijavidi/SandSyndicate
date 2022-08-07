package com.example.sandsyndicate.Inputer

import android.annotation.SuppressLint
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityAddExpenseDetailsBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class AddExpenseDetails : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    var total=""
    var credit=""
    var debit=""
    var name=""
    var purpose=""
    var amount=""
    var particular=""

    private lateinit var binding: ActivityAddExpenseDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAddExpenseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        binding.buttonex.setOnClickListener {
         valided()
        }
    }
    private fun valided() {
        total = binding.total.text.toString()
        credit = binding.credit.text.toString()
        debit = binding.debit.text.toString()
        name = binding.nameex.text.toString()
        purpose = binding.puroseex.text.toString()
        amount = binding.amountex.text.toString()
        particular=binding.eparticular.text.toString()

        if (total.isEmpty()) {
            binding.total.error = "This field shouldn't be empty"
        } else if (credit.isEmpty()) {
            binding.credit.error = "This field shouldn't be empty"

        } else if (debit.isEmpty()) {
            binding.debit.error = "This field shouldn't be empty "
        } else if (name.isEmpty()) {
            binding.nameex.error = "This field shouldn't be empty"
        } else if (purpose.isEmpty()) {
            binding.puroseex.error = "This field shouldn't be empty"
        }
        else if (amount.isEmpty()) {
            binding.amountex.error = "This field shouldn't be empty"
        }
        else if(particular.isEmpty()){
            binding.eparticular.error="This field shouldn't be empty"
        }
        else {
          insertData()
        }
    }
    private fun insertData(){
        var insXP=database.getReference("ExpensesDeeds").child(onlyDate()).child(onlyTime())
        insXP.child("Name").setValue(binding.nameex.text.toString())
        insXP.child("Credit").setValue(binding.credit.text.toString())
        insXP.child("debit").setValue(binding.debit.text.toString())
        insXP.child("purpose").setValue(binding.puroseex.text.toString())
        insXP.child("amount").setValue(binding.amountex.text.toString())
        insXP.child("particular").setValue(binding.eparticular.text.toString())
        refreshtf()
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
    fun refreshtf() {
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}