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
import com.example.sandsyndicate.ForgotActivity
import com.example.sandsyndicate.Inputer.InputerHome
import com.example.sandsyndicate.R
import com.example.sandsyndicate.TruckOwner.TruckOwnerHome
import com.example.sandsyndicate.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private val shared = "Sandsyndicate"
    private lateinit var firebaseAuth: FirebaseAuth
    private val database =
        Firebase.database("https://sand-syndicate-default-rtdb.asia-southeast1.firebasedatabase.app/")
    var emailid = ""
    var password = ""
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Login.setOnClickListener {
            loginaccess()
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

    private fun loginaccess() {
        emailid = binding.USER.text.toString()
        password = binding.PASSWORD.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            binding.USER.error = "Invalid email id"
        } else if (password.isEmpty()) {
            binding.PASSWORD.error = "Password is not valid"
        } else {
            firebaselogin()
        }


    }


    private fun firebaselogin() {
        firebaseAuth.signInWithEmailAndPassword(
            binding.USER.text.toString(),
            binding.PASSWORD.text.toString()
        )
            .addOnSuccessListener {
                val firebaseuser = firebaseAuth.currentUser
                val email = firebaseuser!!.email
                val uniqueid = firebaseuser!!.uid
                // Toast.makeText(this,uniqueid,Toast.LENGTH_LONG).show()
                database.getReference("Register").child(uniqueid).get().addOnSuccessListener {
                    if (it.exists()) {
                        var type = it.child("module").value.toString()
                        var name = it.child("username").value.toString()
                        var email = it.child("emailid").value.toString()
                        var mobilenumber = it.child("mobilenumber").value.toString()
                        var timestamp = it.child("timestamp").value.toString()
                        sharedPreferences(name, email, mobilenumber,timestamp)
                        Toast.makeText(this, "module", Toast.LENGTH_LONG).show()

                        when (type) {
                            "Approver" ->
                                startActivity(Intent(this, ApproverHome::class.java))
                            "Inputer" ->
                                startActivity(Intent(this, InputerHome::class.java))
                            "Truckowner" ->
                                startActivity(Intent(this, TruckOwnerHome::class.java))
                            "Admin"->
                                startActivity(Intent(this,AdminHome::class.java))

                        }
                    } else {
                        Toast.makeText(this, "no user in real time database", Toast.LENGTH_LONG)
                            .show()
                    }

                }.addOnFailureListener {
                    Toast.makeText(this, "no user found", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun sharedPreferences(type: String, name: String, email: String,mobilenumber:String,timestamp:String) {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(shared, MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("mobilenumber",mobilenumber)
        editor.putString("type", type)
        editor.putString("timestamp", timestamp)
        editor.apply()
        editor.commit()

    }

}


