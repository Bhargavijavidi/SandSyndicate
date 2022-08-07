package com.example.sandsyndicate

import Adapter.FeedbackAdapter
import Adapter.Feedbackdata
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.databinding.ActivityViewExpensesDetailsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewExpensesDetails : AppCompatActivity() {
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var expensearraylist:ArrayList<Feedbackdata>//
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
        expensearraylist=ArrayList()//
        database.getReference("Register").addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (baby in snapshot.children){
                    val mainarray=Feedbackdata(baby.child("Name").value.toString(),
                    baby.child("Particular").value.toString(),
                    baby.child("Amount").value.toString(),
                    baby.child("Sitenumber").value.toString(),
                    baby.child("Timestamp").value.toString(),R.drawable.ic_baseline_credit_card_24,R.drawable.ic_baseline_local_atm_24)
                    expensearraylist.add(mainarray)
                }
                expensearraylist.reverse()
                binding.Firstlist.adapter=FeedbackAdapter(this@ViewExpensesDetails,expensearraylist)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
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