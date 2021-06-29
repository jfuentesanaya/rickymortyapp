package com.jfuentes.rickymortyapp.presentation.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.jfuentes.rickymortyapp.R

class SplashActivity : AppCompatActivity() {

    private val delay : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splah)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(ListActivity.getCallingIntent(this))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            finish()
        }, delay)
    }

}