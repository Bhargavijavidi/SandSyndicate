package com.example.sandsyndicate

import Adapter.FeedbackAdapter
import Adapter.Feedbackdata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat.startActivity
import com.example.sandsyndicate.databinding.ActivityViewExpensesDetailsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.content.Intent as Intent1

class ViewExpensesDetails : AppCompatActivity() {
    private var database =
        Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var expensearraylist: ArrayList<Feedbackdata>//
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
 binding.listexpense.setOnRefreshListener(){
     Handler().postDelayed({
         refreshtofinish()
         binding.listexpense.isRefreshing=false
     },1000)
 }
        expensearraylist = ArrayList()//
        database.getReference("ExpensesDeeds").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (baby in snapshot.children) {
                    for (z in baby.children) {
                        val mainarray = Feedbackdata(
                            z.child("Name").value.toString(),
                            z.child("Purpose").value.toString(),
                            z.child("amount").value.toString(),
                            z.child("sitenumber").value.toString(),
                            R.drawable.ic_baseline_credit_card_24,
                            R.drawable.ic_baseline_local_atm_24
                        )
                        expensearraylist.add(mainarray)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        expensearraylist
        binding.Firstlist.adapter = FeedbackAdapter(this@ViewExpensesDetails, expensearraylist)
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




