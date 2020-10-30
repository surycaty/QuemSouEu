package com.surycaty.quemsoueu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.surycaty.quemsoueu.activity.AnimalActivity
import com.surycaty.quemsoueu.activity.DesenhoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.btnAnimal).setOnClickListener {
            val activity2Intent = Intent(applicationContext, AnimalActivity::class.java)
            startActivity(activity2Intent)
        }

        findViewById<ImageButton>(R.id.btnDesenho).setOnClickListener {
            val activity2Intent = Intent(applicationContext, DesenhoActivity::class.java)
            startActivity(activity2Intent)
        }
    }
}