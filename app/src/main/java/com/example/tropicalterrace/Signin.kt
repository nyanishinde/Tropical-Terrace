package com.example.tropicalterrace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tropicalterrace.databinding.ActivitySigninBinding

    private lateinit var binding: ActivitySigninBinding

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySigninBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_signin)

        val signupBtn = findViewById<TextView>(R.id.signupBtn)
        signupBtn.setOnClickListener {
            startActivity(Intent(this,Signup::class.java))
        }
    }
}