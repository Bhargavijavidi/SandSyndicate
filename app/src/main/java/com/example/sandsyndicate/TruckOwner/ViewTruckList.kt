package com.example.sandsyndicate.TruckOwner

import Adapter.truckadapter
import Adapter.truckdata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.databinding.ActivityViewTruckListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewTruckList : AppCompatActivity() {
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var actionBar: ActionBar
    private lateinit var truckarraylist:ArrayList<truckdata>
    private lateinit var binding:ActivityViewTruckListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewTruckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        binding.listtruck.setOnRefreshListener(){
            Handler().postDelayed({
                refreshtofinish()
                binding.listtruck.isRefreshing=false
            },1000)
        }
        truckarraylist= ArrayList()
        database.getReference("Truckdetails").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (A in snapshot.children){
                    for(B in A.children){
                        val main=truckdata(
                            B.child("Drivername").value.toString(),
                            B.child("Trucknumber").value.toString()
                        )
                        truckarraylist.add(main)

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        truckarraylist.reverse()
        binding.trucklistlast.adapter=truckadapter(this@ViewTruckList,truckarraylist)

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