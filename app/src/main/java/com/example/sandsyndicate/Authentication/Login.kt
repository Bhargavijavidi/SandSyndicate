package com.example.sandsyndicate.Authentication

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast

import com.example.sandsyndicate.Admin.AdminHome
import com.example.sandsyndicate.Approver.ApproverHome
//import com.example.sandsyndicate.ForgotActivity
import com.example.sandsyndicate.Inputer.InputerHome
import com.example.sandsyndicate.R
import com.example.sandsyndicate.TruckOwner.TruckOwnerHome
import com.example.sandsyndicate.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
// import java.sql.Timestamp

class Login : AppCompatActivity() {

    private val database = Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    var emailid = ""
    var password = ""
    private val shared = "Sandsyndicate"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Login.setOnClickListener {
            loginAccess()
        }
        binding.Forgot.setOnClickListener {

            val builder = AlertDialog.Builder(this, R.style.Theme_SandSyndicate)
            builder.setTitle("Reset password")

            val view = layoutInflater.inflate(R.layout.activity_forgot, null)
            builder.setView(view)

            builder.setPositiveButton("reset", { dialoginflate, i ->
                Toast.makeText(this, "reset successful!!", Toast.LENGTH_LONG).show()

            })
            builder.setNegativeButton("cancel", { dialoginflate, i -> })
            builder.show()

        }
        binding.register.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }

    private fun loginAccess() {
        emailid = binding.USER.text.toString()
        password = binding.PASSWORD.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            binding.USER.error = "Invalid email id"
        } else if (password.isEmpty()) {
            binding.PASSWORD.error = "Password is not valid"
        } else {
            firebasesignup()
        }


    }


    private fun firebasesignup() {
        firebaseAuth.signInWithEmailAndPassword(emailid,password)
            .addOnSuccessListener {
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                val uniqueid = firebaseUser!!.uid
                 //Toast.makeText(this,uniqueid,Toast.LENGTH_LONG).show()
                database.getReference("Register").child(uniqueid).get().addOnSuccessListener {
                   if (it.exists()) {
                        val type = it.child("Type").value.toString()
                        val name = it.child("Username").value.toString()
                        val email = it.child("Email").value.toString()
                        val mobilenumber = it.child("Mobile number").value.toString()
                        val timestamp = it.child("timestamp").value.toString()
                        sharedPreferences(name, email,mobilenumber,timestamp)
                       // Toast.makeText(this, "module", Toast.LENGTH_LONG).show()
                        when (type) {
                            "Admin"->
                                startActivity(Intent(this,AdminHome::class.java))
                            "Approver" ->
                                startActivity(Intent(this, ApproverHome::class.java))
                            "Inputer" ->
                                startActivity(Intent(this, InputerHome::class.java))
                            "Truckowner" ->
                                startActivity(Intent(this, TruckOwnerHome::class.java))


                        }
                    } else {
                        Toast.makeText(this, "no user in real time database", Toast.LENGTH_LONG).show()
                    }

                }.addOnFailureListener {
                    Toast.makeText(this, "no user found", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun sharedPreferences(name: String, email: String,mobilenumber:String,timestamp:String) {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(shared, MODE_PRIVATE)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("mobilenumber",mobilenumber)
        editor.putString("timestamp",timestamp)
        editor.apply()
        editor.commit()

    }
}


