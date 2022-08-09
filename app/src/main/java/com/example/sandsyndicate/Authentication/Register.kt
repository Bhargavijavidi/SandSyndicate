package com.example.sandsyndicate.Authentication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import com.example.sandsyndicate.Admin.AdminHome
import com.example.sandsyndicate.Approver.ApproverHome
import com.example.sandsyndicate.Inputer.InputerHome
import com.example.sandsyndicate.R
import com.example.sandsyndicate.TruckOwner.TruckOwnerHome
import com.example.sandsyndicate.databinding.ActivityLoginBinding
import com.example.sandsyndicate.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class Register : AppCompatActivity() {
    private var database =
        Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var firebaseAuth: FirebaseAuth
    var username = ""
    var password = ""
    var emailid = ""
    var mobilenumber = ""
    var type = ""
    private val shared="Sandsyndicate"
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mode = resources.getStringArray(R.array.modules)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdownitem, mode)
        binding.modulees.setAdapter(arrayAdapter)
        binding.modulees.setOnItemClickListener { adapterView, view, i, l ->
            type=adapterView.getItemAtPosition(i).toString()
        }

        binding.Signup.setOnClickListener {
            signupaccess()
        }
        binding.Backlogin.setOnClickListener {

            startActivity(Intent(this,Login::class.java))
        }
    }

    private fun signupaccess() {
        username = binding.user2.text.toString()
        password = binding.password2.text.toString()
        emailid = binding.mailid.text.toString()
        mobilenumber = binding.mobileno.text.toString()
        if (username.isEmpty()) {
            binding.user2.error = "Invalid user name"
        } else if (password.isEmpty()) {
            binding.password2.error = "Invalid Password"
        } else if (emailid.isEmpty()) {
            binding.mailid.error = "Invalid Email id"
        } else if (mobilenumber.isEmpty()) {
            binding.mobileno.error = "Mobile number is incorrect"
        } else {

            Toast.makeText(this,"Registered successfully",Toast.LENGTH_LONG).show()
            firebasesignup()
        }

    }

    private fun firebasesignup() { firebaseAuth.createUserWithEmailAndPassword(binding.mailid.text.toString(),binding.password2.text.toString())
        .addOnSuccessListener {
            val firebaseUser=firebaseAuth.currentUser
            val email=firebaseUser!!.email
            val uniqueid=firebaseUser!!.uid
            insertData(uniqueid)
        }
        .addOnFailureListener {
            Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
        }

    }

    private fun insertData(uniqueid: String) {
        var Register = database.getReference("Register").child(uniqueid)
       var name= Register.child("Username").setValue(binding.user2.text.toString())
       var password= Register.child("Password").setValue(binding.password2.text.toString())
       var email= Register.child("EmailId").setValue(binding.mailid.text.toString())
       var mobilenumber= Register.child("Mobile number").setValue(binding.mobileno.text.toString())
        var typer=  Register.child("Type").setValue(binding.modulees.text.toString())
        var timestamp=Register.child("timestamp").setValue(currentTimeNDate())
         sharedPreferences(name.toString(),email.toString(),mobilenumber.toString(),timestamp.toString()) {

             //switch case


             when (type) {
                 "Approver" ->
                     startActivity(Intent(this, ApproverHome::class.java))
                 "Inputer" ->
                     startActivity(Intent(this, InputerHome::class.java))
                 "Truck Owner" ->
                     startActivity(Intent(this, TruckOwnerHome::class.java))
             }
         }

   /* fun onlyDate(): String {
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
            simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            date = simpleDateFormat.format(calendar.time)
            fData = date.subSequence(11, 19).toString()
            return fData


        }*/
        fun refreshtofinish() {
            startActivity(intent)
            finish()
        }
        }

    private fun sharedPreferences(name: String, email: String, mobilenumber: String, timestamp: String, function: () -> Unit) {
        val sharedPreferences:SharedPreferences=this.getSharedPreferences(shared, MODE_PRIVATE)
        //mode set
        val editor:SharedPreferences.Editor=sharedPreferences.edit()
        //editor
        editor.putString("name",name)
        editor.putString("email",email)
        editor.putString("mobilenumber",mobilenumber)
        editor.putString("timestamp",timestamp)
        editor.apply()
        editor.commit()

    }

    private fun currentTimeNDate(): String {
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat
        var date: String
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        date = simpleDateFormat.format(calendar.time)
        return date
    }
}



