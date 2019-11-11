package com.example.bwapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val buttonClick = findViewById<TextView>(R.id.tv_click_me)
        //buttonClick.setOnClickListener {
        //   Toast.makeText(this@MainActivity, "Nice!", Toast.LENGTH_SHORT).show()
        //}
    }
}
