package com.example.sandsyndicate

import Adapter.sandadapter
import Adapter.sanddata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.sandsyndicate.databinding.ActivityViewSandDetailsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewSandDetails : AppCompatActivity() {
    private var database=Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var sandarraylist:ArrayList<sanddata>
    private lateinit var actionBar: ActionBar
    private lateinit var binding:ActivityViewSandDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewSandDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar = supportActionBar!!
        actionBar.title = "back"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        //used to refresh list
       binding.listsand.setOnRefreshListener(){
            Handler().postDelayed({
                refreshtofinish()
                binding.listsand.isRefreshing=false
            },1000)
        }

        sandarraylist= ArrayList()
        database.getReference("Sanddeets").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (s in snapshot.children){
                    for(d in s.children){
                        val l=sanddata(
                            d.child("Driver Name").value.toString(),
                            d.child("Truck number").value.toString(),
                            d.child("Quality brass").value.toString(),
                            d.child("Message").value.toString(),
                            d.child("site number").value.toString(),
                            R.drawable.load,
                            R.drawable.stock)
                        sandarraylist.add(l)
                    }
                    sandarraylist
                    binding.thirdlist.adapter=sandadapter(this@ViewSandDetails,sandarraylist)
                }
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