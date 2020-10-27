package com.surycaty.quemsoueu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAnimal).setOnClickListener {
            val activity2Intent = Intent(applicationContext, AnimalActivity::class.java)
            startActivity(activity2Intent)
        }
    }
}