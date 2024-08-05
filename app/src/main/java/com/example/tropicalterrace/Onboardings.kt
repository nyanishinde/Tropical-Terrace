package com.example.tropicalterrace

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setMargins
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Onboardings : AppCompatActivity() {

    private lateinit var viewPager:ViewPager2
    private lateinit var nextButton:FloatingActionButton
    private lateinit var indicatorLayout:LinearLayout
    private lateinit var indicators: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboardings)

        viewPager = findViewById(R.id.viewPager)
        nextButton = findViewById(R.id.nextFAB)
        indicatorLayout = findViewById(R.id.indicatorLayout)

        val adapter = OnboardingPagerAdapter(this)
        viewPager.adapter = adapter

        setUpIndicators(adapter.itemCount)
        setCurrentIndicator(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setCurrentIndicator(position)
            }
        })
        nextButton.setOnClickListener {
            val nextItem = viewPager.currentItem + 1;
            if (nextItem < adapter.itemCount){
                viewPager.currentItem=nextItem
            }else{
                finishOnBoarding()
            }
        }

    }

    private fun finishOnBoarding() {
        startActivity(Intent(this,Signin::class.java))
        finish()
    }

    private fun setCurrentIndicator(index: Int) {
        for (i in indicators.indices){
            val drawableId = if (i==index) R.drawable.indicator_active else R.drawable.indicator_inactive
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,drawableId))
        }
    }

    private fun setUpIndicators(itemCount: Int) {

        indicators=Array(itemCount){ImageView(this)}

        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(8,0,8,0)

        for(i in 0 until itemCount){
            indicators[i]=ImageView(this)
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.indicator_inactive))
            indicators[i].layoutParams=params
            indicatorLayout.addView(indicators[i])
        }
    }
}