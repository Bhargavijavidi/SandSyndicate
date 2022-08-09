package com.example.sandsyndicate

import Adapter.machineadapter
import Adapter.machinedata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.databinding.ActivityViewMachineDetailsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewMachineDetails : AppCompatActivity() {
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
   private lateinit var machinearraylist:ArrayList<machinedata>
    private lateinit var actionBar: ActionBar
    private lateinit var binding:ActivityViewMachineDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewMachineDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        //used to list refresh
        binding.listmachine.setOnRefreshListener(){
            Handler().postDelayed({
                refreshtofinish()
                binding.listmachine.isRefreshing=false

            },2000)
        }

        machinearraylist= ArrayList()
        database.getReference("MachineDeets").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (b in snapshot.children) {
                    for (a in b.children) {
                        val c = machinedata(
                            a.child("Machine name").value.toString(),
                            a.child("Fuel").value.toString(),
                            a.child("Startnumber").value.toString(),
                            a.child("Endnumber").value.toString(),
                            a.child("Drivername").value.toString(),

                            )
                        machinearraylist.add(c)

                    }
                }
                machinearraylist
                binding.secondlist.adapter=machineadapter(this@ViewMachineDetails,machinearraylist)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
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
