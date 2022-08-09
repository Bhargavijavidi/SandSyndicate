package com.example.sandsyndicate.Admin

import Adapter.approveradapter
import Adapter.approverdata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityApproveBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Approve : AppCompatActivity() {
    private var database =
        Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var approvearraylist: ArrayList<approverdata>
    private lateinit var actionBar: ActionBar
    private lateinit var binding: ActivityApproveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApproveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        binding.apprefresh.setOnRefreshListener() {
            Handler().postDelayed({
                refreshtofinish()
                binding.apprefresh.isRefreshing = false

            }, 2000)

            approvearraylist = ArrayList()
            database.getReference("Register").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (v in snapshot.children) {
                        for (u in v.children) {
                            val s = approverdata(
                                u.child("Username").value.toString(),
                                u.child("EmailId").value.toString(),
                                u.child("Mobile number").value.toString(),
                                u.child("Type").value.toString(),
                                R.drawable.ic_baseline_check_24,
                                R.drawable.ic_baseline_disabled_by_default_24)
                            approvearraylist.add(s)


                        }
                        approvearraylist
                        binding.applist.adapter=approveradapter(this@Approve,approvearraylist)

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }

    private fun refreshtofinish(){
        startActivity(intent)
        finish()

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
