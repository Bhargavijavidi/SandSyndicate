package com.example.sandsyndicate.Admin

import Adapter.approveradapter
import Adapter.approverdata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import androidx.core.os.postDelayed
import com.example.sandsyndicate.R
import com.example.sandsyndicate.databinding.ActivityAddapproverlistBinding
import com.example.sandsyndicate.databinding.ActivityViewapproverlistBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class viewapproverlist : AppCompatActivity() {
    private var database=
        Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var approverarraylist:ArrayList<approverdata>
    private lateinit var actionBar: ActionBar
    private lateinit var binding:ActivityViewapproverlistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewapproverlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar=supportActionBar!!
        actionBar.title="back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        binding.apprefresh.setOnRefreshListener() {
            Handler().postDelayed({
                refreshtofinsh()
                binding.apprefresh.isRefreshing = false

            }, 1000)
        }

            approverarraylist= ArrayList()
            database.getReference("Approver list details").addValueEventListener(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (v in snapshot.children) {
                        for (u in v.children) {
                            val s = approverdata(
                                u.child("Name").value.toString(),
                                u.child("Email").value.toString(),
                                u.child("contact").value.toString(),
                                u.child("Type").value.toString(),
                                R.drawable.ic_baseline_check_24,
                                R.drawable.ic_baseline_disabled_by_default_24,
                            )
                            approverarraylist.add(s)

                        }
                    }
                        approverarraylist
                        binding.applist.adapter=approveradapter(this@viewapproverlist,approverarraylist
                        )
                    }


                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }

    private fun refreshtofinsh(){
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    }
