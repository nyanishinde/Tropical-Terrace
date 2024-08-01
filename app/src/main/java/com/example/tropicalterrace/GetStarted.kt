package com.example.tropicalterrace

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tropicalterrace.databinding.ActivityGetStartedBinding

class GetStarted : AppCompatActivity() {

    private lateinit var binding: ActivityGetStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_get_started)

        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(this,Signin::class.java))
            finish()
        }

    }
}