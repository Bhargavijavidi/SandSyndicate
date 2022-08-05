package com.example.sandsyndicate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.sandsyndicate.Admin.AdminHome
import com.example.sandsyndicate.Authentication.Login
import com.example.sandsyndicate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            startActivity(Intent(this,Login::class.java))
        },1000)
        val animationf=AnimationUtils.loadAnimation(this,R.anim.fade)
        binding.mainbutton.startAnimation(animationf);
    }
}
