package com.surycaty.quemsoueu

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AnimalActivity : AppCompatActivity() {

    private lateinit var animals: Array<String>
    private lateinit var txtName: TextView
    private lateinit var txtCountDown: TextView
    private lateinit var countDown: CountDownTimer
    private lateinit var progressBar: ProgressBar

    private val FORMAT_COUNTER = "%02d"
    private val START_VALUE = 90L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        animals = resources.getStringArray(R.array.animals)

        txtName = findViewById(R.id.txtAnimalName)
        txtCountDown = findViewById(R.id.txtCountDown)
        progressBar = findViewById(R.id.progressBar)

        countDown = object : CountDownTimer(START_VALUE * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txtCountDown.text = String.format(FORMAT_COUNTER, millisUntilFinished / 1000)
                progressBar.progress = txtCountDown.text.toString().toInt()
            }

            override fun onFinish() {
                txtCountDown.setTextColor(Color.RED)
                playEndSound()
            }
        }

        getCard()

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_UP -> getCard()
        }
        return super.onTouchEvent(event)
    }

    fun playEndSound() {
        val player: MediaPlayer = MediaPlayer.create(this, R.raw.sound_end)
        player.start()
    }

    private fun getCard() {

        val img = findViewById<ImageView>(R.id.imgAnimal)

        val animal = animals.random()

        when (animal) {
            "Camelo" -> img.setImageResource(R.drawable.img_camel)
            "Gato" -> img.setImageResource(R.drawable.img_cat)
            "Vaca" -> img.setImageResource(R.drawable.img_cow)
            "Cachorro" -> img.setImageResource(R.drawable.img_dog)
            "Pato" -> img.setImageResource(R.drawable.img_duck)
            "Elefante" -> img.setImageResource(R.drawable.img_elephant)
            "Peixe" -> img.setImageResource(R.drawable.img_fish)
            "Girafa" -> img.setImageResource(R.drawable.img_girafa)
            "Ganso" -> img.setImageResource(R.drawable.img_goose)
            "Lula" -> img.setImageResource(R.drawable.img_grilled_squid)
            "Joaninha" -> img.setImageResource(R.drawable.img_ladybug)
            "Leão" -> img.setImageResource(R.drawable.img_lion)
            "Macaco" -> img.setImageResource(R.drawable.img_monkey)
            "Panda" -> img.setImageResource(R.drawable.img_panda)
            "Pinguim" -> img.setImageResource(R.drawable.img_pinguin)
            "Coelho" -> img.setImageResource(R.drawable.img_rabbit)
            "Rato" -> img.setImageResource(R.drawable.img_rat)
            "Camarão" -> img.setImageResource(R.drawable.img_shrimp_prawn)
            "Cobra" -> img.setImageResource(R.drawable.img_snake)
            "Tigre" -> img.setImageResource(R.drawable.img_tigre)
            "Touro" -> img.setImageResource(R.drawable.img_touro)
            "Tartaruga" -> img.setImageResource(R.drawable.img_turtle)
            "Tubarão" -> img.setImageResource(R.drawable.img_wireshark)
            "Zebra" -> img.setImageResource(R.drawable.img_zebra)
            else -> img.setImageResource(R.drawable.img_elephant)

        }

        txtName.text = animal

        txtCountDown.setTextColor(Color.WHITE)

        countDown.start()

    }

}